package material.datatypes

fun main() {
    charToInt()
//    longToInt()
}

private fun charToInt() {
    val string = "1"
    val int = string.take(1).toInt()
    val int2 = string.toInt()


    println("Type is ${string::class.simpleName} value is $string. Now type is ${int::class.simpleName} and value is $int")
    println("Type is ${string::class.simpleName} value is $string. Now type is ${int2.toInt()::class.simpleName} and value is $int2")

    val array = "123".toCharArray()
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
