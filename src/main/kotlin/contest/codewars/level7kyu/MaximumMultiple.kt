package contest.codewars.level7kyu

fun main() {
    println(
        maxMultiple2(2, 7)
    )
}

private fun maxMultipleMy(divisor: Int, bound: Int): Int {
    if (bound % divisor == 0) return bound

    var result = bound
    while (result % divisor > 0) result -= 1

    return result
}

private fun maxMultiple(d: Int, b: Int): Int = (b downTo d).first { it % d == 0 }
private fun maxMultiple2(d: Int, b: Int) = b - (b % d) // 7 - (7%2) = 6