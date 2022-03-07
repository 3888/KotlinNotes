package material.math

import java.lang.Math.ceil
import java.lang.Math.floor
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

/*
https://developer.android.com/reference/kotlin/java/math/RoundingMode
 */
fun main() {
    decimalFormat()
    decimalFormat2()
    ceilExample()
    florExample()
}

private fun decimalFormat() {
    val decimalFormat = DecimalFormat(".##").apply { roundingMode = RoundingMode.HALF_UP }
    println(decimalFormat.format(BigDecimal("-1000.045")))
}

private fun decimalFormat2() {
    val decimal = BigDecimal(3.14159265359).setScale(2, RoundingMode.HALF_EVEN)
    println(decimal) // 3
}

private fun ceilExample() {
    val value = (100.00 / 33)
    println(value)

    val ceilValue = ceil(100.00 / 33)
    val ceilValue2 = kotlin.math.ceil(100.00 / 33)
    println(ceilValue)
    println(ceilValue2)
}

private fun florExample() {
    val value = (100.00 / 33)
    println(value)

    val floorValue = floor(100.00 / 33)
    val floorValue2 = kotlin.math.floor(100.00 / 33)
    println(floorValue)
    println(floorValue2)
}