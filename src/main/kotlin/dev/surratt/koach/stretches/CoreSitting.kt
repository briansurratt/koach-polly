package dev.surratt.koach.stretches

import dev.surratt.koach.Stretch

val sittingNeckStretch = Stretch(
    name = "sitting neck stretch",
    bilateral = true,
    repetitions = 3,
    duration = 30,
    sets = 1,
    description = 
    """Sit with back straight, place one hand on small of back.  Grasp back of head with other hand and gently pull head down in that direction.""".trimIndent()
)

// sitting levator scapula stretch
val sittingLevatorScapulaStretch = Stretch(
    name = "sitting levator scapula stretch",
    bilateral = true,
    repetitions = 10,
    duration = 5,
    sets = 1,
    description =
    """place both hands on head, gently stretch head down and away.""".trimIndent()
)

// sitting lower back stretch
val sittingLowerBackStretch = Stretch(
    name = "sitting lower back stretch",
    bilateral = false,
    repetitions = 5,
    duration = 10,
    sets = 1,
    description =
    """sit in a chair with knees spread apart. bend forward to the floor until a comfortable stretch is felt in the lower back.""".trimIndent()
)

// sitting upper trapezius stretch
val sittingUpperTrapeziusStretch = Stretch(
    name = "sitting upper trapezius stretch",
    bilateral = true,
    repetitions = 5,
    duration = 10,
    sets = 1,
    description =
    """reach behind back with one hand. tilt head away until stretch is felt.""".trimIndent()
)
