package contest.codewars.level8kyu

import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    makeNegative(-1)

}

private fun makeNegative(x: Int): Int =
//    abs(x) * -1
//    -abs(x)
    -x.absoluteValue