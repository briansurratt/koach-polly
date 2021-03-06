/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package dev.surratt.koach

import dev.surratt.koach.aws.polly
import dev.surratt.koach.ssml.SsmlGenerator
import software.amazon.awssdk.services.polly.model.VoiceId
import java.io.File
import java.nio.file.Files


fun main(args: Array<String>) {

    val stretch = Stretch(
        name = "floor lower back lift",
        bilateral = false,
        repetitions = 5,
        duration = 5,
        sets = 3,
        description = """With feet on the ground and knees raised, lift hips off the ground, keeping back and shoulders flat."""
    )

    val ssmlText = SsmlGenerator().generate(stretch)

    val fileName = stretch.shortDescription() + ".mp3"

    println("fileName = $fileName")

    val file = File(fileName)
    file.createNewFile()

    println("file = ${file.absoluteFile}")

    polly()
        .synthesize(ssmlText)
        .withVoice(VoiceId.JOANNA)
        .toFile(file)

}

fun generateScriptToFile(stretch: Stretch) {
    val ssmlText = SsmlGenerator().generate(stretch)
    val fileName = stretch.shortDescription() + ".mp3"
    val file = File(fileName)
    println("file = ${file.absolutePath}")
    polly()
        .synthesize(ssmlText)
        .withVoice(VoiceId.JOANNA)
        .toFile(file)
}

fun processStretches(stretches: List<Stretch>) {

    stretches.forEach { stretch ->
        println("Processing ${stretch.name}")
        generateScriptToFile(stretch)

    }

}
