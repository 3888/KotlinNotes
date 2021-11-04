package contest.codewars.level8kyu

fun main() {

}

private fun sumMy(numbers: IntArray) = numbers.filter { it > 0 }.sum()

fun sum(numbers: IntArray)
        = numbers.sumBy { it.coerceAtLeast(0) }

