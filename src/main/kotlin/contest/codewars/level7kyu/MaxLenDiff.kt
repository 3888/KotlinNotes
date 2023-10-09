package contest.codewars.level7kyu

import java.util.Collections

fun main() {
    val a1 = arrayOf("hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz")
    val a2 = arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww") // 13

    val a11 = arrayOf("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh")
    val a22 = arrayOf("bbbaaayddqbbrrrv") // 10

    mxdiflgMy(a1, a2)
    mxdiflgMy(a11, a22)

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

fun mxdiflg(a1:Array<String>, a2:Array<String>)
        = a1.flatMap { s1 -> a2.map { kotlin.math.abs(s1.length - it.length) } }.maxOrNull() ?: -1

