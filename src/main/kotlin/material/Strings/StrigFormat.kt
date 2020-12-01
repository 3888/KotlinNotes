package material.Strings

fun main() {
    numbersAfterZero("3f", 1.23523F)
}

private fun numbersAfterZero(specifier: String, value: Float) {
    println("Remaining balance: ${"%.$specifier".format(value)}")
}