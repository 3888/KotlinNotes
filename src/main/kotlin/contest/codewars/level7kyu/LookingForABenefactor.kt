package contest.codewars.level7kyu

import kotlin.math.ceil
import kotlin.math.roundToLong

fun main() {
    val array = doubleArrayOf(
//        14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.00 // 7 92 newAvg(a, 90.0), 628)
//        14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 15.0 // 7 91 newAvg(a, 92.0), 645
        14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 15.0 // newAvg(a, 2.0)
    )
    val x = 0

    println(
        newAvg(array, 2.00)
    )
}

private fun newAvgMy(a: DoubleArray, navg: Double): Long {
    val value = (navg * (a.size + 1) - a.sum()).toLong()
    if (value <= 0) throw IllegalArgumentException("--- Exception 1 ---")
    return value
}

fun newAvg(a: DoubleArray, navg: Double): Long {
    val x = navg * (a.size + 1) - a.sum()
    require(x >= 0)
    return ceil(x).roundToLong()
}
