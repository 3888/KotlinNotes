package kotlin_bootcamp.L6

fun main() {
    quiz5()
}

private fun quiz5() {
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
//    Should return
//    > [3, 6, 9, 0]

    println(numbers.filter {
        it % 3 == 0
    })

    println(numbers.filter {
        it.rem(3) == 0
    })

    println(numbers.divisibleBy {
        it.rem(3)
    })
}

private fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}