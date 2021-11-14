package contest.codewars.level7kyu

import kotlin.math.pow

fun main() {

    /*
                 1                1 = 1
              3     5             2 = 8
           7     9    11          3 = 27
        13    15    17    19      4 = 64
    21    23    25    27    29    5 = 125
31    33    35    37    39    41  6 = 216
     */

}

private fun rowSumOddNumbersMy(rows: Int): Int {
    val list = mutableListOf<Int>()
    for (i in 1..rows) list.add(i)
    val oddNumbersCount =
//        list.reduce { acc, i -> acc + i }
        (1..rows).sum()

    list.clear()
    list.add(1)
    for (i in 0 until oddNumbersCount - 1) list.add(list[i] + 2)

    return list.takeLast(rows).sum()
}

private fun rowSumOddNumbers(n: Int) = n * n * n
private fun rowSumOddNumbers2(n: Int) = n.toDouble().pow(3).toInt()

