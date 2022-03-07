package contest.codewars.level7kyu

import kotlin.math.ceil

private val wallpapers = listOf(
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen",
    "twenty"
)
fun main() {
    println(
        wallpaperWrong
//        (4.0, 3.5, 3.0)
        (6.3, 4.5, 3.29)
    )
}

private fun wallpaperWrong(l: Double, w: Double, h: Double): String {
    val rollLength = 10
    val rollWidth = 0.52

    val roomWallsSquare = 2 * (l * h) + 2 * (w * h)
    println(
        "roomWallsSquare $roomWallsSquare"
    )

    val division =
        (roomWallsSquare / (rollLength * rollWidth) * 100)

    println(
        "division $division"
    )

    var result = division.toInt()

    if (result % 100 > 0) result = result / 100 + 1 else result /= 100

    println(
        result

    )

    return wallpapers[(result * 1.15).toInt()]
}

fun wallpaper(l:Double, w:Double, h:Double):String {
    if (h * w * l == 0.0) return "zero"
    val rolls = ceil(
        (
                (
                 (l + w) * 2.0 * h / 0.52 / 10.0
                        ) * 1.15
                )
    ).toInt()
    return wallpapers[rolls]
}