package material.math

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
//    pow()

}

private fun maxOf(a: Int, b: Int) {
    println("max of $a and $b is ${kotlin.comparisons.maxOf(a, b)}")
}

private fun max_(a: Int, b: Int) {
    println("max of $a and $b is ${kotlin.math.max(a, b)}")
}

private fun sqrt() {
    println(sqrt(144.0)) // √ 144 = 12
}

private fun pow() {
    println(10.0.pow(3)) // 10 * 10 * 10 = 1000
}