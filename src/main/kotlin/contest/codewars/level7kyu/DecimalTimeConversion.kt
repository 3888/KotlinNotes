package contest.codewars.level7kyu

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt


fun main() {
//   println(toIndustrial(10))
//   println(toIndustrial("3:47"))
//    println(toNormal(24.13))
//    println(toNormal(1.75))
}



fun toIndustrialMy(t: Int): Double = BigDecimal(t * 60.0 / 3600).setScale(2, RoundingMode.HALF_EVEN).toDouble()

fun toIndustrial(t: Int): Double = (t / 60.0 * 100.0).roundToInt() / 100.0

fun toIndustrialMy(t: String): Double = BigDecimal(t.split(":")
    .zipWithNext { a, b -> a.toInt() * 60 + b.toInt() }
    .first() * 60 / 3600.0)
    .setScale(2, RoundingMode.HALF_EVEN).toDouble()

fun toIndustrial(t: String): Double =
    toIndustrial(t.split(":")[0].toInt()*60 + t.split(":")[1].toInt())


fun toNormalMy(t: Double): String = "${(t * 100).toInt() * 36 / 3600}:${
    String.format(
        "%02d",
        BigDecimal(((t * 100) * 36 / 60) % 60).setScale(0, RoundingMode.HALF_EVEN).toInt()
    )
}"

fun toNormal(t: Double): String = "${(t * 60.0).roundToInt() / 60}:"+"%02d".format((t * 60.0).roundToInt() % 60)