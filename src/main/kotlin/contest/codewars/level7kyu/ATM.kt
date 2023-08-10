package contest.codewars.level7kyu

import kotlin.random.Random


fun main() {
    repeat(1000) {
        val value = Random.nextInt(1, 1500)
        atmCount(value)
    }
}

fun atmCount(number: Int): Int = if (number % 10 == 0) {
    val array = arrayOf(500, 200, 100, 50, 20, 10)
    var count = 0
    var value = number
    array.forEach {
        count += value / it
        value %= it
    }
    count
} else -1

fun atmCount2(number: Int): Int {
    if (number % 10 != 0) return -1
    val bill_500 = number / 500
    val bill_200 = number % 500 / 200
    val bill_100 = number % 500 % 200 / 100
    val bill_50 = number % 500 % 200 % 100 / 50
    val bill_20 = number % 500 % 200 % 100 % 50 / 20
    val bill_10 = number % 500 % 200 % 100 % 50 % 20 / 10
    val result = bill_500 + bill_200 + bill_100 + bill_50 + bill_20 + bill_10

    return result
}