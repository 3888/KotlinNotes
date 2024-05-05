package contest.codewars.level7kyu

fun main() {
    var x = doubleArrayOf(
//        0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.6 //   gps(20, x) // 41
        0.0, 0.11, 0.22, 0.33, 0.44, 0.65, 1.08, 1.26, 1.68, 1.89, 2.1, 2.31, 2.52, 3.25 // (gps(12, x), 219)
    )
    println(

    )

    println(
        gpsMy(12, x)
    )

}

private fun gpsMy(s: Int, x: DoubleArray) =
    x.map { it }.zipWithNext { a, b -> b - a }
        .map { 3600 * it / s }.maxOrNull()?.toInt() ?: 0