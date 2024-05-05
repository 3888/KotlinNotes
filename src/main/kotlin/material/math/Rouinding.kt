package material.math

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ceil
import kotlin.math.floor

/*
https://developer.android.com/reference/kotlin/java/math/RoundingMode
 */
fun main() {
    decimalFormat()
    ceilExample()
    florExample()
}

private fun decimalFormat() {
    val number = BigDecimal("10.5532355")
    val decimal = BigDecimal(3.14159265359)

    println("number $number")
    println("decimal $decimal")

    val decimalFormat = DecimalFormat(".##").apply { roundingMode = RoundingMode.HALF_UP }

    println("decimalFormat ${decimalFormat.format(decimal)}")
    println("Rounded HALF_EVEN: ${decimal.setScale(2, RoundingMode.HALF_EVEN)}")

    println("Rounded UP: ${number.setScale(2, RoundingMode.UP)}")
    println("Rounded DOWN: ${number.setScale(2, RoundingMode.DOWN)}")

}


private fun ceilExample() {
    val value = (100.00 / 33)
    println(value)

    val ceilValue = ceil(100.00 / 33)
    val ceilValue2 = ceil(100.00 / 33)
    println("ceil $ceilValue")
    println("ceil2 $ceilValue2")
}

private fun florExample() {
    val value = (100.00 / 33)
    println("value $value")

    val floorValue = floor(100.00 / 33)
    val floorValue2 = floor(100.00 / 33)
    println("floorValue $floorValue")
    println("floorValue2 $floorValue2")
}