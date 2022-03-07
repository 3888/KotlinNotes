package contest.codewars.level7kyu

fun main() {

    evenNumbers(
//        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3
        listOf(-22, 5, 3, 11, 26, -6, -7, -8, -9, -8, 26), 2
//    listOf(6, -25, 3, 7, 5, 5, 7, -3, 23), 1
    )

}

private fun evenNumbersMy(array: List<Int>, number: Int): List<Int> {
    val filtered = array.filter { it % 2 == 0 }
    return (filtered.subList(filtered.size - number, filtered.size))
}

private fun evenNumbers(array: List<Int>, number: Int) = array.filter { it % 2 == 0 }.takeLast(number)

private fun evenNumbers2(array: List<Int>, number: Int): List<Int> = array.reversed()
    .filter { it % 2 == 0 }
    .take(number)
    .asReversed()

