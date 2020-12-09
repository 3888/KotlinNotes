package material.loops

import kotlin.random.Random

fun main() {
    whileExample(5)
    doExample(5)
    breakExample()

}

private fun whileExample(endValue: Int) {
    var startValue: Int = 0

    while (startValue < endValue) {
        println("i  = $startValue")
        startValue++
    }
}

private fun doExample(endValue: Int) {
    var number = 0
    do {
        print("$number ")
        number++
    } while (number < endValue)
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

