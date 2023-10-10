package contest.codewars.level7kyu

import java.util.*
import kotlin.math.abs
import kotlin.math.max

private fun main() {
    val a1 = arrayOf(
        "hoqq",
        "bbllkw",
        "oox",
        "ejjuyyy",
        "plmiis",
        "xxxzgpsssa",
        "xxwwkktt",
        "znnnnfqknaz",
        "qqquuhii",
        "dvvvwz"
    )
    val a2 = arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww") // 13

    val a11 = arrayOf("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh")
    val a22 = arrayOf("bbbaaayddqbbrrrv") // 10

//    mxdiflg2(a1, a2)
//    mxdiflg2(a11, a22)

}

private fun mxdiflgMy(a1: Array<String>, a2: Array<String>): Int {
    if (a1.isEmpty() or a2.isEmpty()) return -1
    val first = a1.map { it.length }
    val second = a2.map { it.length }
    val minFirst = Collections.min(first)
    val maxFirst = Collections.max(first)
    val minSecond = Collections.min(second)
    val maxSecond = Collections.max(second)

    return when {
        maxSecond - minFirst < maxFirst - minSecond -> maxFirst - minSecond
        maxSecond - minFirst > maxFirst - minSecond -> maxSecond - minFirst
        else -> maxFirst - minSecond
    }
}

private fun mxdiflg(a1: Array<String>, a2: Array<String>) =
    a1.flatMap { s1 -> a2.map { kotlin.math.abs(s1.length - it.length) } }.maxOrNull() ?: -1

private fun mxdiflg2(a1: Array<String>, a2: Array<String>): Int {
    var m = -1
    for (x in a1) {
        println("x $x")
        println("x ${x.length}")
        for (y in a2) {
            println("y $y")
            println("y ${y.length}")
            m = max(m, abs(x.length - y.length))
            println("x.length - y.length ${x.length - y.length}")
            println("abs x.length - y.length ${abs(x.length - y.length)}")
            println("max m = $m & x.length - y.length = ${abs(x.length - y.length)} is $m")
        }
    }

    return m
}

private fun mxdiflg3(a1: Array<String>, a2: Array<String>): Int {

    // Don't try to calculate anything for empty arrays.
    if (a1.isEmpty() || a2.isEmpty()) return -1

    // Sort both arrays by length.
    a1.sortBy { it.length }
    a2.sortBy { it.length }

    /**
     * Get length difference of two arrays.
     * Firstly measure the length difference between the longest word from a2 and shortest from a1.
     * Then measure the length difference between the longest word from a1 and shortest from a2.
     */
    val firstLengthDifference = a2.last().length - a1.first().length
    val secondLengthDifference = a1.last().length - a2.first().length

    // Get a bigger value of two length differences.
    return maxOf(firstLengthDifference, secondLengthDifference)
}

private fun mxdiflg4(a1: Array<String>, a2: Array<String>): Int =
    if (a1.isEmpty() || a2.isEmpty()) -1
    else {
        val maxA = a1.maxOfOrNull { it.length } ?: 0
        val minA = a1.minOfOrNull { it.length } ?: 0
        val maxB = a2.maxOfOrNull { it.length } ?: 0
        val minB = a2.minOfOrNull { it.length } ?: 0

        val difference1 = Math.abs(maxA - minB)
        val difference2 = Math.abs(minA - maxB)
        if (difference1 > difference2) difference1 else difference2
    }


fun mxdiflg5 (a1:Array<String>, a2:Array<String>):Int {
    if (a1.size < 1 || a2.size < 1) return -1

    val statisticsA1 = a1.toList().stream().mapToInt {it.length}.summaryStatistics()
    val statisticsA2 = a2.toList().stream().mapToInt {it.length}.summaryStatistics()

    return Math.max(Math.abs(statisticsA1.max - statisticsA2.min), Math.abs(statisticsA2.max - statisticsA1.min))

}