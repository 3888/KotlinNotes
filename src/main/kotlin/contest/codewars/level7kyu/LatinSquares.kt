package contest.codewars.level7kyu


fun main() {
    println(println(
        makeLatinSquare(4).map {
            it.contentToString()
        }

    ))
}

private fun makeLatinSquareMy(n: Int): Array<IntArray> {
    val matrix = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            matrix[i][j] = (i + j + 1) % n + 1
        }
    }
    return matrix
}

private fun makeLatinSquare(n: Int): Array<IntArray> =
    Array(n) { i -> IntArray(n) { j -> (i + j) % n + 1 } }

fun makeLatinSquare2(n: Int): Array<IntArray> =
    Array(n) { row -> IntArray(n) { column -> if (row >= column) row - column + 1 else row - column + 1 + n } }

fun makeLatinSquare3(n: Int): Array<IntArray> {
    val range = 1..n

    return Array(n) {
        (range.drop(it) + range.take(it)).toIntArray()
    }
}