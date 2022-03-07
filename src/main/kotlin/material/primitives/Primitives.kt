package material.primitives

fun main() {

//    for (i in -2..2) println(i.unaryMinus())
//    remainderOfDivision()

println(feast("great blue heron", "garlic naan"))
}


fun feast(beast: String, dish: String): Boolean {

   return "${beast.first()}${beast.last()}" == "${dish.first()}${dish.last()}"
}

fun isEven(num: Int): Boolean {
    return num % 2 == 0
}

private fun remainderOfDivision() {
    for (i in 1..5) {
        println("$i is ${evenOrOdd(i)} ${i * i.rem(2)}")
    }
}

private fun evenOrOdd(number: Int) =
//    if (number and 1 == 0) "Even" else "Odd"
    if (number.and(1) == 1) "Odd" else "Even"