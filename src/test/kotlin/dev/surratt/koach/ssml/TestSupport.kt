package dev.surratt.koach.ssml

fun String.countOccurrences(substring: String): Int {
    return this.windowed(substring.length).count { it == substring }
}