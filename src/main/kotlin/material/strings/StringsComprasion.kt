package material.strings

fun main() {

//todo()
    compareExample()

}

private fun todo() {
/*
* https://www.baeldung.com/kotlin-string-comparison
* */
    val first = "kotlin"
    val second = "kotlin"
    val firstCapitalized = "KOTLIN"
    println("first == second ${first == second}")
    println("first == firstCapitalized ${first == firstCapitalized}")

    println("first.equals(second) ${first.equals(second)}")
    println("first.equals(firstCapitalized)  ${first.equals(firstCapitalized)}")

    println("first.compareTo(second) ${first.compareTo(second)}")
    println("first.compareTo(firstCapitalized) ${first.compareTo(firstCapitalized)}")

    println("first.compareTo(firstCapitalized, true) ${first.compareTo(firstCapitalized, true)}")

    val third = String("kotlin".toCharArray())
    println("first == third ${first == third}")
    println("first.equals(third) ${first.equals(third)}")
}

private fun compareExample() {
    val arrayNumbers = "0123456789".toByteArray()
    println(arrayNumbers.contentToString())
    val binaryNumbers = arrayNumbers.map { Integer.toBinaryString(it.toInt()) }
    println(binaryNumbers)

    val arrayChars = "ABCDabcd".toByteArray()
    println(arrayChars.contentToString())
    val binaryChars = arrayChars.map { Integer.toBinaryString(it.toInt()) }
    println(binaryChars)

}