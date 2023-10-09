package contest.codewars.level7kyu

import java.time.LocalDate
import kotlin.math.ceil
import kotlin.math.ln


fun main() {

    println(dateNbDays2(100.0, 150.0, 2.00))

}

fun dateNbDays(a0: Double, a: Double, p: Double): String {
    return LocalDate.of(2016, 1, 1).plusDays(
        ceil(ln(a / a0) / ln(1 + p / 36000)).toLong()
    ).toString()
}

fun dateNbDays2(a0: Double, a: Double, p: Double) =
    "${
        LocalDate.of(2016, 1, 1).plusDays(
            generateSequence(a0) {
                it + it * p / 36000
            }.takeWhile { it < a }.count().toLong()
        )
    }"


fun dateNbDays3(a0: Double, a: Double, p: Double): String {
    val startDate = LocalDate.of(2016, 1, 1)
    var startMoney = a0
    var days: Long = 0
    while (startMoney <= a) {
        startMoney += startMoney * p / 100 / 360
        days++
    }
    return startDate.plusDays(days).toString()
}