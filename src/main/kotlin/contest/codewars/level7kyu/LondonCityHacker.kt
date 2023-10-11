package contest.codewars.level7kyu

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {

//    println(londonCityHacker(arrayOf(12, "Central", "Circle", 21))) //  "£7.80"
//    println(londonCityHacker(arrayOf("Piccidilly", 56))) // "£3.90"
//    println(londonCityHacker(arrayOf("Northern", "Central", "Circle"))) // "£7.20"
//    println(londonCityHacker(arrayOf("Piccidilly", 56, 93, 243))) // "£5.40"
//    println(londonCityHacker(arrayOf(386, 56, 1, 876))) //"£3.00"
//    println(londonCityHacker(arrayOf())) //  "£0.00"

//    println(londonCityHacker(arrayOf("Piccidilly", 56, 56))) // "£5.40"
//    println(londonCityHacker(arrayOf(56, 56))) // "£1.50"
//    println(londonCityHacker(arrayOf(56))) // "£1.50"
//    println(londonCityHacker(arrayOf(16, "Circle", "Victoria", "Hammersmith", "Bakerloo" ))) // £11.1

//    println(londonCityHacker(arrayOf(55, 196, 54, 115, "Metropolitan", 94, 186))) // expected:< £[6.9]0> but was:<£[8.4]
//    println(londonCityHacker(arrayOf(196, 83, 134, 41, 175, 136, 59))) //  expected:<£[6.0]0> but was:<£[4.5]0>
//    println(londonCityHacker(arrayOf(95, "Victoria", 78, "Northern", 167))) // expected:<£[9.3]0> but was:<£[7.8]0>
//    println(londonCityHacker(arrayOf("Victoria", "District", "Piccadilly", "Circle", "Hammersmith & City", 132, 168))) // expected:<£1[3.5]0> but was:<£1[5.0]0>
//    println(londonCityHacker(arrayOf("Jubilee", "Central", 164, 0, 51))) // expected:<£[7.8]0> but was:<£[6.3]0>
//    println(londonCityHacker(arrayOf(151,162, "Waterloo & City",138, 190, "Metropolitan", 65))) // expected:<£[9.3]0> but was:<£[10.8]0> STOOOOOOPPPP!!!!!

}


private fun londonCityHackerMyFuckUp(journey: Array<Any>): String {
    println("journey ${journey.contentToString()}")
    return "£${
        BigDecimal(
            when {
                journey.all { it is Int } -> (if (journey.size % 2 > 0) journey.size / 2 * 1.5 + 1.5 else journey.size / 2 * 1.5)
                journey.all { it is String } -> journey.size * 2.4
                else -> {
                    val chunked = journey.map { if (it is String) 2.40 else 1.50 }.chunked(2)
                    println(chunked)
                    chunked
                        .foldIndexed(0.0) { index, acc, list ->
                            when {
                                chunked[index].last() == 1.5 && chunked[index + 1].first() == 1.5 -> acc + 2.4
                                index == chunked.size - 1 && list.sum() == 1.5 && chunked[index - 1].sum() == 3.0 -> acc + 1.5
                                index == chunked.size - 1 && list.sum() == 1.5 && chunked[index - 1].last() == 1.5 -> acc
                                index == chunked.size - 1 && list.sum() == 1.5 -> acc + 1.5
                                acc > 0 && list.sum() == 1.5 -> acc
                                list.sum() == 1.5 -> acc + 1.5
                                list.size == 1 && list.sum() == 1.5 -> 1.5
                                list.sum() == 3.0 -> acc + 1.5
                                else -> acc + list.sum()
                            }
                        }

                }
            }
        ).setScale(2, RoundingMode.HALF_EVEN)
    }"
}

fun londonCityHacker(journey: Array<Any>): String =
    journey.joinToString("") { if (it is Int) "B" else "T" }
        .replace("BB", "B")
        .sumOf { if (it == 'B') 1.5 else 2.4 }
        .let { "£%.2f".format(it) }





