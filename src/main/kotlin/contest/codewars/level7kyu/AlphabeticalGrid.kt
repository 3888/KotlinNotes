package contest.codewars.level7kyu

fun main() {

}


private fun gridMyn(n: Int): String? {
    if (n < 0) return null
    if (n == 0) return ""
    if (n == 1) return "a"

    return buildString {
        for (i in 0 until n) {
            for (j in 0 until n) {
                append(moveLetter("${'a' + i}", j))
            }
        }
    }.chunked(n) { sequence ->
        sequence.map { "$it " }.joinToString("").dropLast(1)
    }.joinToString("\n")
}

fun moveLetter(s: String, index: Int) = s.map { 'a' + (((it - 'a') + index) % 26) }.joinToString("")
