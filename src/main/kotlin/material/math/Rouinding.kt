package material.math

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat


/*
https://developer.android.com/reference/kotlin/java/math/RoundingMode
 */
fun main() {
//    decimalFormat()
    decimalFormat2()

}

private fun decimalFormat() {
    val decimalFormat = DecimalFormat("#.##").apply { roundingMode = RoundingMode.HALF_UP }
    println(decimalFormat.format(BigDecimal("-1000.045")))

}

private fun decimalFormat2() {
    val decimal = BigDecimal(3.14159265359).setScale(0, RoundingMode.HALF_EVEN)
    println(decimal) // 3
}
