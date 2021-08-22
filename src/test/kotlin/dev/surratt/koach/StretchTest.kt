package dev.surratt.koach

import assertk.assertThat
import assertk.assertions.contains
import org.junit.jupiter.api.Test

internal class StretchTest {

    private val testStretch = Stretch(
        name = "do the work",
        bilateral = false,
        repetitions = 3,
        duration = 5,
        sets = 11,
        description = """Do what I say."""
    )

    @Test
    fun `short description includes name`() {
        assertThat(testStretch.shortDescription()).contains("do-the-work")
    }

    @Test
    fun `includes cross of sets and reps`() {
        assertThat(testStretch.shortDescription()).contains("11_X_3")
    }

}