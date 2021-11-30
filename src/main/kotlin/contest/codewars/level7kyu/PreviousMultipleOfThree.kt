package contest.codewars.level7kyu

fun main() {

    println(prevMultOfThree(1244))
}


private fun prevMultOfThreeMy(n: Int): Int? {
    var result = n
    while (result % 3 > 0) {
        result /= 10
        if (result == 0) return null
    }

    return result

}

private fun prevMultOfThree(n: Int): Int? = when {
    n == 0 -> null
    n % 3 == 0 -> n
    else -> prevMultOfThree(n / 10)
}

fun prevMultOfThree2(n: Int): Int? =
    generateSequence(n) { it / 10 }
        .find { it % 3 == 0 }
        .let { if (it == 0) null else it }
