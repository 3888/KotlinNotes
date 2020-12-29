package material.functional_programming

fun main() {
//    flipValues()
    playWithNumbers()
}

private fun flipValues() {
    val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)
    println(gradesByStudent)

    val list = mutableMapOf<Double, String>()
    gradesByStudent.map {
        list.put(it.value, it.key)
    }
    println(list)
}

private fun playWithNumbers() {
    /*
    https://forums.bignerdranch.com/t/my-solution-to-sliding-window-challenge/15895/2
    * */

//    println(valuesToAdd
//        .filter { it >= 5 }
//        .chunked(2)
//        .map { it[0] * it[1] }
//        .fold(0) { accumulator, number -> accumulator + number }
//        .sum()
//    )

    val valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)
    println(valuesToAdd)

    val valuesHigherFive =
        valuesToAdd.filter {
            it >= 5
        }
    println(valuesHigherFive)

    val chunkedValues = valuesHigherFive.chunked(2)
    println(chunkedValues)

    val resultFold = chunkedValues
        .map { it[0] * it[1] }
        .fold(0) { accumulator, number -> accumulator + number }
    println(resultFold)

    val resultSum = chunkedValues
        .map { it[0] * it[1] }
        .sum()

    println(resultSum)
}