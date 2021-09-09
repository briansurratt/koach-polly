package dev.surratt.koach.ssml

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.endsWith
import assertk.assertions.startsWith
import dev.surratt.koach.resist.ResistanceExercise
import org.junit.jupiter.api.*

internal class ResistanceSsmGeneratorTest {

    @Nested
    @DisplayName("Given a resistance exercise")
    inner class GivenResistanceExercise {

        private val generator = SsmlGenerator()
        private lateinit var ssmlScript: String
        private val exercise = ResistanceExercise(
            name = "the most important exercise",
            description = "do the thing",
            repetitions = 5,
            sets = 2,
            hold = 3
        )

        @Nested
        @DisplayName("When generate is called")
        inner class WhenGenerateIsCalled {

            @BeforeEach
            fun setup() {
                ssmlScript = generator.generate(exercise)
            }

            @Test
            @DisplayName("Then script has open SSML tag")
            fun `then script has open SSML tag`() {
                assertThat(ssmlScript).startsWith("<speak>")

            }

            @Test
            @DisplayName("Then script has the close SSML tag")
            fun `then script has the close SSML tag`() {
                assertThat(ssmlScript).endsWith("</speak>")
            }

            @Test
            @DisplayName("Then the name is included in the script")
            fun `then the name is included in the script`() {
                assertThat(ssmlScript).contains(exercise.name)
            }

            @Test
            @DisplayName("Then the description is included in the script")
            fun `then the description is included in the script`() {
                assertThat(ssmlScript).contains(exercise.description)
            }

            @Test
            @DisplayName("Then the number of sets is included in the script")
            fun `then the number of sets is included in the script`() {
                assertThat(ssmlScript).contains("${exercise.sets } sets")
            }

            @Test
            @DisplayName("Then the hold duration is included in the script")
            fun `then the hold duration is included in the script`() {
                fail("Test not implemented")
            }

            @Test
            @DisplayName("Then first set is not announced")
            fun `then first set is not announced`() {
                fail("Test not implemented")
            }

            @Test
            @DisplayName("Then last set is not counted")
            fun `then last set is not counted`() {
                fail("Test not implemented")
            }

            @Test
            @DisplayName("Then last set is announces")
            fun `then last set is announces`() {
                fail("Test not implemented")
            }

        }

        @Nested
        @DisplayName("When there is just one set")
        inner class WhenThereIsJustOneSet {

            @Test
            @DisplayName("Then sets are not announced")
            fun `then sets are not announced`() {
                fail("Test not implemented")
            }

        }

    }

    @Nested
    @DisplayName("Given a resistance exercise with no hold")
    inner class GivenAResistanceExerciseWithNoHold {



    }

    @Nested
    @DisplayName("Given a resistance exercise with one set")
    inner class GivenAResistanceExerciseWithOneSet {


    }

}