package dev.surratt.koach.ssml

import assertk.assertAll
import assertk.assertThat
import assertk.assertions.*
import dev.surratt.koach.Stretch
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SsmlGeneratorTest {

    private val testStretch = Stretch(
        name = "floor lower back lift",
        bilateral = false,
        repetitions = 7,
        duration = 5,
        sets = 3,
        description = """Do what I say."""
    )

    private val generator = SsmlGenerator()
    private lateinit var ssmlScript: String

    @BeforeEach
    fun setup() {
        ssmlScript = generator.generate(testStretch)
        println("*******")
        println(ssmlScript)
        println("*******")
    }

    @Test
    fun `includes name`() {
        assertThat(ssmlScript).contains(testStretch.name)
    }

    @Test
    fun `includes the description`() {
        assertThat(ssmlScript).contains(testStretch.description)
    }

    @Test
    fun `starts with speak tag`() {
        assertThat(ssmlScript).startsWith("<speak>")
    }

    @Test
    fun `sends with speak tag`() {
        assertThat(ssmlScript).endsWith("</speak>")
    }

    @Test
    fun `includes sets and repetition count`() {
        assertThat(ssmlScript).contains("3 sets of 7 repetitions")
    }

    @Test
    fun `announces start of each set`() {
        assertAll {
            for (i in (testStretch.sets - 1) downTo 2) {
                assertThat(ssmlScript).contains("$i sets remaining")
            }
        }
    }

    @Test
    fun `announces final set`() {
        assertThat(ssmlScript).contains("Final set.")
    }

    @Test
    fun `doesn't announce first set`() {
        assertThat(ssmlScript).doesNotContain("${testStretch.sets} set remaining.")
    }

    @Test
    fun `doesn't announce sets if only one`() {

        val justOneSet = Stretch(
            name = "floor lower back lift",
            bilateral = false,
            repetitions = 7,
            duration = 5,
            description = """Do what I say."""
        )

        val script = SsmlGenerator().generate(justOneSet)

        assertThat(script).doesNotContain("set", true)


    }

    @Test
    fun `break between counts`() {
        val count = ssmlScript.countOccurrences("""<break time="${COUNT_PAUSE_MILLISECONDS}ms"/>""")
        assertThat(count).isEqualTo(testStretch.duration * testStretch.repetitions * testStretch.sets)
    }

    @Test
    fun `break for ready pause`() {
        assertThat(ssmlScript).contains("""<break time="${READY_PAUSE_SECONDS}s"/>""")
    }

    @Test
    fun `counts down repetitions`() {

        assertAll {
            for (i in (testStretch.repetitions - 1) downTo 2) {
                assertThat(ssmlScript).contains("$i repetitions remaining")
            }
        }

    }

    @Test
    fun `contains ready message`() {
        assertThat(ssmlScript).contains("Ready.")
    }

    @Test
    fun `contains begin message`() {
        assertThat(ssmlScript).contains("Begin.")
    }

    @Test
    fun `doesn't not count 1 repetitions remaining`() {
        assertThat(ssmlScript).doesNotContain("1 repetitions remaining")
    }

    @Test
    fun `doesn't not count total repetitions remaining`() {
        assertThat(ssmlScript).doesNotContain("${testStretch.repetitions} repetitions remaining")
    }

    @Test
    fun `contains last repetition prompts`() {
        assertThat(ssmlScript).contains("Last repetition.")
    }

    @Test
    fun `contains relax after each repetition`() {
        assertThat(ssmlScript.countOccurrences("And relax.")).isEqualTo(testStretch.repetitions * testStretch.sets)
    }

    fun String.countOccurrences(substring: String): Int {
        return this.windowed(substring.length).filter { it == substring }.count()
    }

    @Test
    fun `break after each repetition`() {
        val count = ssmlScript.countOccurrences("""<break time="${REPETITION_BREAK_SECONDS}s"/>""")
        assertThat(count).isEqualTo(testStretch.repetitions * testStretch.sets)
    }

}