package material.datatypes

fun main() {
//    charToInt()
    longToInt()
}

private fun charToInt() {
    val array = "12345678".toCharArray()
    array.map {
        println(
            "value $it type ${it::class.simpleName} toInt ${it.toInt()}  getNumericValue ${
                Character.getNumericValue(
                    it
                )
            }"
        )
    }
}

private fun longToInt() {
    val long = 1234567890123



}
