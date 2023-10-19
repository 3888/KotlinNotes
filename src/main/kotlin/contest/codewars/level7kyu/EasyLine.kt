package contest.codewars.level7kyu


fun main() {
    println(pascalTriangleGPT(4))
}

fun pascalTriangleGPT(rows: Int): List<List<Int>> =
    List(rows) { row ->
        List(row + 1) { col ->
            if (col == 0 || col == row) 1
            else pascalTriangleGPT(rows - 1)[row - 1][col - 1] +
                    pascalTriangleGPT(rows - 1)[row - 1][col]
        }
    }