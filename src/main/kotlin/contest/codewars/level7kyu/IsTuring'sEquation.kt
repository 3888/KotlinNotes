package contest.codewars.level7kyu

fun main() {
    println(isTuringEquationMy("73+42=16"))
}

private fun isTuringEquationMy(s: String): Boolean {
    val equation = s.split("=")
    val numbers = equation.first().split("+").sumOf {
        it.reversed().toInt()
    }

    val result = equation.last().reversed().toInt()

    return numbers == result
}

fun isTuringEquation(s: String): Boolean =
    s.split('+', '=').map { it.reversed().toInt() }.let { it[0] + it[1] == it[2] }

fun isTuringEquation2(s: String) = s.reversed().split(Regex("[+=]")).map { it.toInt() }.let { it[0] == it.drop(1).sum() }