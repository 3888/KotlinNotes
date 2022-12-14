package contest.codewars.level8kyu

import kotlin.random.Random

fun main() {
//
//    for (i in 1..100) {
//        val left = Random.nextInt(0, 2)
//        val right = Random.nextInt(0, 2)
//        val call = Random.nextInt(0, 2)
//
//        println("left $left")
//        println("right $right")
//        println("call $call")
//        println(elevator(left, right, call))
//    }


    println(elevator(0, 2, 1))
}

private fun elevator(left: Int, right: Int, call: Int): String = when {
    left == right && left == call -> "right"
    left == call -> "left"
    left != right && right == call -> "right"
    left < right && left < call -> "right"
    left > right && left > call -> "left"
    else -> "right"
}


