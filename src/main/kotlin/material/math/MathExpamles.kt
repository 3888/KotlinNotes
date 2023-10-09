package material.math

import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    logarithm()
}

private fun algebraic(){
    var fish = 2;

    println("times ${fish.times(6)}")
    println(fish.div(2))
    println(fish.plus(3))
    println(fish.minus(1))
    fish = 25
    println("dec ${fish.dec()}")
    println("inc ${fish.inc()}")

    println("% vs .rem ${1234 % 10}")
    println("% vs .rem ${1234.rem(10)}")
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

private fun logarithm() {
    println( ln(100.0))
}