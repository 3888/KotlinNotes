package contest.codewars.level7kyu

import java.util.*

fun main() {

    highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4")

}

private fun highAndLowMy(numbers: String): String {
    val list = numbers.split(" ")
        .map {
            it.toInt()
        }
    val max = Collections.max(list)
    val min = Collections.min(list)

    return "$max $min"
}

private fun highAndLow(numbers: String): String {
    val x = numbers.split(" ").map { it.toInt() }.sorted()
    return "${x.last()} ${x.first()}"
}

private fun highAndLow2(numbers: String) = numbers.split(" ")
    .map(String::toInt)
    .sorted()
    .run { listOf(last(), first()) }
    .joinToString(" ")

fun highAndLow3(numbers: String): String {
    val res = numbers
        .split(' ')
        .map {
            it.toInt()
        }

    return "${res.maxOf { it }} ${res.minOf { it }}"
}