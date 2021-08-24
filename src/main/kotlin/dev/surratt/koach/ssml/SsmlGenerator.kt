package dev.surratt.koach.ssml

import com.mirego.dsl.ssml.element.*
import dev.surratt.koach.Stretch

const val READY_PAUSE_SECONDS = 1
const val REPETITION_BREAK_SECONDS = 3
const val COUNT_PAUSE_MILLISECONDS = 750

class SsmlGenerator {

    fun generate(stretch: Stretch): String {

        val ssml = speak {

            p {

                s { +stretch.name }
                s { +stretch.description }

                if (stretch.sets > 1) {
                    s { +"${stretch.sets} sets of ${stretch.repetitions} repetitions." }
                } else {
                    s { +"${stretch.repetitions} repetitions." }
                }

                if (stretch.bilateral) {
                    s { +"alternating sides." }
                }

            }
            +"\n"
            `break`(time = "${READY_PAUSE_SECONDS}s")
            +"\n"

            for (set in stretch.sets downTo 1) {

                if (stretch.sets > 1) {
                    if (set == 1) {
                        +"Final set."
                    } else if (set < stretch.sets) {
                        +"$set sets remaining"
                    }
                }

                // repetitions loop
                for (repetition in stretch.repetitions downTo 1) {

                    p {
                        s {
                            if (repetition == 1) {
                                +"Last repetition."
                            } else if (repetition < stretch.repetitions) {
                                +"$repetition repetitions remaining"
                            }
                        }
                    }

                    p {
                        s { +"Ready." }
                        s { +"Begin." }
                    }

                    +"\n"
                    // count loop
                    val duration = stretch.duration

                    if (stretch.bilateral) {
                        +"left side"
                        `break`(time = "${READY_PAUSE_SECONDS}s")
                        generateCount(duration)
                        +"right side"
                        `break`(time = "${READY_PAUSE_SECONDS}s")
                        generateCount(duration)
                    } else {
                        generateCount(duration)
                    }


                    +"And relax."
                    +"\n"
                    `break`(time = "${REPETITION_BREAK_SECONDS}s")
                    +"\n"
                }
            }

        }

        return ssml.toString()

    }

    private fun Speak.generateCount(duration: Int) {
        for (count in 1..duration) {
            +count.toString()
            `break`(time = "${COUNT_PAUSE_MILLISECONDS}ms")
            +"\n"
        }
    }

}