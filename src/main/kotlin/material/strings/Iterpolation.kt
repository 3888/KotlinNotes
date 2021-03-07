package material.strings

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {
    bigDecimalCutPlus()
}

private fun bigDecimalCutPlus(){
    val number = 123.235235
    val decimalFormat =
        DecimalFormat("#.#").apply { roundingMode = RoundingMode.HALF_UP }
    println("+$number")
    println("-$number")
    println("${decimalFormat.format(BigDecimal("+$number"))}")
    println("${decimalFormat.format(BigDecimal("-$number"))}")

}