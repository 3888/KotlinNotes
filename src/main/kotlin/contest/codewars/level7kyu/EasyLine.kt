package contest.codewars.level7kyu

import java.math.BigInteger


fun main() {
//    println(pascalTriangleGPT(4))
    easyLineGPT(5)

}

fun pascalTriangleGPT(rows: Int): List<List<Int>> =
    List(rows) { row ->
        List(row + 1) { col ->
            if (col == 0 || col == row) 1
            else pascalTriangleGPT(rows - 1)[row - 1][col - 1] +
                    pascalTriangleGPT(rows - 1)[row - 1][col]
        }
    }

fun pascalTriangleGPT2(n: Int) {
    val list = mutableListOf<Array<BigInteger>>()

    (1 until n).forEach { index ->
        when (index) {
            1 -> list.add(arrayOf(BigInteger.ONE))
            2 -> list.add(arrayOf(BigInteger.ONE, BigInteger.ONE))
            else -> {
                val row = Array(index) { BigInteger.ZERO }
                row[0] = BigInteger.ONE
                row[index - 1] = BigInteger.ONE

                for (i in 1 until index - 1) {
                    println(" i $i  until ${index - 1}")
                    row[i] = list[index - 2][i - 1].add(list[index - 2][i])
                }

                list.add(row)
            }
        }
    }
}

fun easyLineGPT(n: Int): BigInteger {
    val list = mutableListOf<Array<BigInteger>>()

    (1..n).forEach { index ->
        when (index) {
            1 -> list.add(arrayOf(BigInteger.ONE))
            2 -> list.add(arrayOf(BigInteger.ONE, BigInteger.ONE))
            else -> {
                val row = Array(index) { BigInteger.ZERO }
                row[0] = BigInteger.ONE
                row[index - 1] = BigInteger.ONE

                for (i in 1 until index - 1) {
                    // Binomial coefficient: C(index-1, i) = C(index-2, i-1) + C(index-2, i)
                    row[i] = list[index - 2][i - 1].add(list[index - 2][i])
                }

                list.add(row)
            }
        }
    }

    // Calculate the sum of squares of the binomial coefficients in the last row
    val lastRow = list.last()
    val sumOfSquares = lastRow.map { it.pow(2) }.reduce { acc, value -> acc + value }

    return sumOfSquares
}
