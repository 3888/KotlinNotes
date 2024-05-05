package material.functions.standard

import kotlin.random.Random

fun main() {
    takeIf()
}

private fun takeIf() {
    val value = "value".takeIf { it.length > 3 }?.reversed()
    val value2 = Random.nextInt(10).takeIf { it > 0 } ?: -1
    println(value)
    println(value2)
}