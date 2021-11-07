package material.datatypes

fun main() {
//    charToInt()
//    longToInt()
//    stringToChar()
}

private fun stringToChar() {
    /*
    https://www.techiedelight.com/convert-string-to-char-kotlin/
    * */
    val string = "A"
    println(string::class.simpleName)
    println(string.single()::class.simpleName)
    println(string.first()::class.simpleName)
    println(string[0]::class.simpleName)
}

private fun getAscii() {
    /*
    https://www.techiedelight.com/convert-string-to-char-kotlin/
    * */
    val string = "A"
    println(string::class.simpleName)
    println(string.single()::class.simpleName)
    println(string.first()::class.simpleName)
    println(string[0]::class.simpleName)
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
    println("value is $long")
    println(long::class.simpleName)
    println(long.toInt()::class.simpleName)
    val longNotSafety = 999999999999999
    println("value is $longNotSafety type ${longNotSafety::class.simpleName}")
    println("value is ${longNotSafety.toInt()} type ${longNotSafety.toInt()::class.simpleName}")

    val intMax = Int.MAX_VALUE
    println("value is $intMax type ${intMax::class.simpleName}")
}
