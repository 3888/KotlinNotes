package material.loops

import kotlin.random.Random

fun main() {
    breakExample()
}

private fun breakExample() {
    val isTavernOpen = true
    var time = Random.nextInt(0, 10)
    var isClosingTime = time < 2


    while (isTavernOpen) {
        println("time is $time")
        if (isClosingTime) {
            println("Time to close! $time")
            break
        }
        time = Random.nextInt(0, 10)
        isClosingTime = time < 2
        println("work in progress")
    }
}