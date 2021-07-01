package material.basic

fun main() {
    val numbers = arrayOf(1, 2, 3)
    println("numbers added arrayOf(1, 2, 3) $numbers")
    println("numbers.size ${numbers.size}")

    val numbersList = listOf(*numbers)
    println("numbersList added *numbers $numbersList")
    println("numbersList.size ${numbersList.size}")

    val numberList = listOf(numbers)
    println("numberList added numbers  $numberList")
    println("numberList.size ${numberList.size}")
}