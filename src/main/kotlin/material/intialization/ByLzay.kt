package material.intialization

import kotlin.random.Random

fun main() {
    println(lazyValue)
    println(lazyValue)
}

val lazyValue: String by lazy {
    println("Result of lambda = ${Random.nextInt(0, 10)}")
    "Hello"
}