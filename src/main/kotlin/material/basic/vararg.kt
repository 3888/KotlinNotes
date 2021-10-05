package material.basic

fun main() {


}

private fun varargParams() {
    getCountArgList(listOf(1, 2, 3))
    getCountArgVararg(1, 2, 3)

}

private fun getCountArgList(list: List<Int>) {
    println(list.size)
}

private fun getCountArgVararg(vararg arrayItems: Int) {
    println("vararg " + arrayItems.size)
}

private fun asteriskInVaragrsParams() {
    val numbers = arrayOf(1, 2, 3)
    println("numbers added arrayOf(1, 2, 3) $numbers")
    println("numbers.size ${numbers.size}")

    val asteriskInVaragrs = listOf(*numbers)
    println("numbersList added *numbers $asteriskInVaragrs")
    println("numbersList.size ${asteriskInVaragrs.size}")

    val numberList = listOf(numbers)
    println("numberList added numbers  $numberList")
    println("numberList.size ${numberList.size}")
}

private fun asteriskInVaragrsParams2() {
    val array = intArrayOf(1, 2, 3)
    val asteriskInVaragrs = getCountArgVararg(1, *array, 2, 3)

}

/*
Since the second parameter is of the same type as the varargs, the function can’t recognize which value belongs to which parameter.
When we want to call the function and don’t use named parameters, it doesn’t know when the vararg parameters end.
*/
fun varargErrorFunction(vararg numbers: Int, numberToFind: Int): Boolean {
    for (number in numbers) {
        if (number == numberToFind) {
            return true
        }
    }
    return false
}