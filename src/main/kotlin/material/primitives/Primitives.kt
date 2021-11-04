package material.primitives

fun main() {

//    for (i in -2..2) println(i.unaryMinus())

}

fun isEven(num: Int): Boolean {
    return num % 2 == 0
}

private fun evenOrOdd(number: Int) =
//    if (number and 1 == 0) "Even" else "Odd"
    if(number.and(1) == 1) "Odd" else "Even"