package contest.codewars.level8kyu

import java.util.Collections.max

fun main() {
    println(expressionsMatterMy(1, 3, 1))
}

private fun expressionsMatterMy(a: Int, b: Int, c: Int): Int {
    val case1 = a * (b + c)
    val case2 = a * b * c
    val case3 = a + b * c
    val case4 = (a + b) * c
    val case5 = a + b + c

    val array = arrayOf(case1, case2, case3, case4, case5).sortedArray()

    return array[4]
}

private fun expressionsMatter(a: Int, b: Int, c: Int) =
    max(listOf(a * b * c, a * (b + c), a + b * c, (a + b) * c, a + b + c))

fun expressionsMatter2(a: Int, b: Int, c: Int): Int {
    return maxOf(a + b + c, a * (b + c), (a + b) * c, a * b * c)
}

fun expressionsMatter3(a: Int, b: Int, c: Int): Int =
    listOf(a + b + c, a + b * c, (a + b) * c, a * b + c, a * (b + c), a * b * c).maxOf { it }