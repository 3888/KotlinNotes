package material.strings


/*
* https://www.baeldung.com/kotlin-string-comparison
* */
fun main() {

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
