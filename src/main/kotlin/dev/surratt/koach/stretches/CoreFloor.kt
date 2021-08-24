package dev.surratt.koach.stretches

import dev.surratt.koach.Stretch

// floor cross body knee to chest
val floorCrossBodyKneeToChest = Stretch(
    name = "floor cross body knee to chest",
    bilateral = true,
    repetitions = 3,
    duration = 20,
    sets = 1,
    description =
    """pull knee toward opposite shoulder.""".trimIndent()
)

// floor trunk rotation
val floorTrunkRotation = Stretch(
    name = "floor trunk rotation",
    bilateral = true,
    repetitions = 10,
    duration = 5,
    sets = 1,
    description =
    """keeping back flat and feet together, rotate knees to one side.""".trimIndent()
)

// floor knee to chest
val floorKneeToChest = Stretch(
    name = "floor knee to chest",
    bilateral = true,
    repetitions = 5,
    duration = 10,
    sets = 1,
    description =
    """with hand behind knee pull knee to chest until a comfortable stretch is felt in lower back and buttocks.""".trimIndent()
)

// floor angry cat stretch
val floorAngryCatStretch = Stretch(
    name = "floor angry cat stretch",
    bilateral = false,
    repetitions = 10,
    duration = 5,
    sets = 1,
    description =
    """Tuck chin and tighten stomach, arching back""".trimIndent()
)

// floor half butterfly stretch
val floorHalfButterflyStretch = Stretch(
    name = "floor half butterfly stretch",
    bilateral = true,
    repetitions = 5,
    duration = 10,
    sets = 2,
    description =
    """Laying on back, feet flat on ground and knees raised, lower one knee to the ground.""".trimIndent()
)

// floor full butterfly stretch
val floorFullButterflyStretch = Stretch(
    name = "loor full butterfly stretch",
    bilateral = false,
    repetitions = 5,
    duration = 5,
    sets = 1,
    description =
    """Laying on back, feet flat on ground and knees raised, lower both knees to the ground.""".trimIndent()
)

// floor lower back lift
val floorLowerBackLift = Stretch(
    name = "floor lower back lift",
    bilateral = false,
    repetitions = 10,
    duration = 5,
    sets = 1,
    description =
    """With feet on the ground and knees raised, lift hips off the ground, keeping back and shoulders flat.""".trimIndent()
)

// floor back lift
val floorBackLift = Stretch(
    name = "floor back lift",
    bilateral = false,
    repetitions = 10,
    duration = 5,
    sets = 1,
    description =
    """With feet on the ground and knees raised, lift hips off the ground, keeping shoulders flat.""".trimIndent()
)

val floorStretches = listOf<Stretch>(
    floorAngryCatStretch,
    floorFullButterflyStretch,
    floorBackLift,
    floorTrunkRotation,
    floorKneeToChest,
    floorCrossBodyKneeToChest,
    floorHalfButterflyStretch,
    floorLowerBackLift
)

fun main() {

}
