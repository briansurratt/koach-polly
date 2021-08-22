package dev.surratt.koach

data class Stretch(
    val name: String,
    val description: String,
    val bilateral: Boolean = false,
    val sets: Int = 1,
    val repetitions: Int,
    val duration: Int
) {

    fun shortDescription() : String {
        return name.replace(" ", "-").toLowerCase() + "_" + sets + "_X_" + repetitions
    }

}

