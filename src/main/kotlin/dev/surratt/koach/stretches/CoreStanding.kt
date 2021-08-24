package dev.surratt.koach.stretches

import dev.surratt.koach.Stretch
import dev.surratt.koach.processStretches


// standing I band stretch
val standingIBandStretch = Stretch(
    name = "standing I band stretch",
    bilateral = true,
    repetitions = 3,
    duration = 20,
    sets = 1,
    description =
    """Cross one leg behind the other leg. Bend at waist, reaching for the floor.""".trimIndent()
)

// standing quad stretch
val standingQuadStretch = Stretch(
    name = "standing quad stretch",
    bilateral = true,
    repetitions = 3,
    duration = 20,
    sets = 1,
    description =
    """Grab ankle and pull heel towards buttock.""".trimIndent()
)

// standing scapular retraction
val standingScapularRetraction = Stretch(
    name = "standing scapular retraction",
    bilateral = false,
    repetitions = 20,
    duration = 5,
    sets = 1,
    description =
    """With elbows be to 90 degrees, pinch shoulder blades together and rotate arms out, keeping elbows bent.""".trimIndent()
)

// standing wall push
val standingWallPush = Stretch(
    name = "standing wall push",
    bilateral = true,
    repetitions = 3,
    duration = 20,
    sets = 1,
    description =
    """Stand with foot back, leg straight, forward leg bent. Keeping heel on floor and turned slightly out, lean into wall until stretch is fel in the calf.""".trimIndent()
)

// standing ham string stretch
val standingHamStringStretch = Stretch(
    name = "standing ham string stretch",
    bilateral = true,
    repetitions = 5,
    duration = 20,
    sets = 1,
    description =
    """Place foot on stool. slowly lean forward, keeping back straight, until stretch is felt in back of thigh.""".trimIndent()
)

val coreStanding = listOf<Stretch>(
    standingIBandStretch,
    standingQuadStretch,
    standingWallPush,
    standingScapularRetraction,
    standingHamStringStretch
)

fun main() {
    processStretches(coreStanding)
}