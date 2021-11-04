package contest.codewars.level8kyu

fun main() {

    println(isDivisible(4, 2, 8))

}

private fun isDivisible(n: Int, x: Int, y: Int): Boolean = n % x + n % y < 1
private fun isDivisible2(n: Int, x: Int, y: Int): Boolean = n % x == 0 && n % y == 0