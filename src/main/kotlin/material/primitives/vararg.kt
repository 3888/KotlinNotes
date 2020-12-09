package material.primitives

fun main() {
    val numbers = arrayOf(1, 2, 3)
    println(numbers)
    println(numbers.size)
    val numbersList = listOf(*numbers)
    println(numbersList)
    println(numbersList.size)
    val numberList = listOf(numbers)
    println(numberList)
    println(numberList.size)

}