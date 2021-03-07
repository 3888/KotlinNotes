package material.math

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat


/*
https://developer.android.com/reference/kotlin/java/math/RoundingMode
 */
fun main() {
example()
}

private fun example() {
    val decimalFormat = DecimalFormat("#.##").apply { roundingMode = RoundingMode.HALF_UP }
    println(decimalFormat.format(BigDecimal("-1000.045")))

}