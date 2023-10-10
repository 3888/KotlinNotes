package contest.codewars.level7kyu


fun main() {
    println(geometricSequenceElements(2, 3, 5)) // "2, 6, 18, 54, 162")


}

private fun geometricSequenceElementsMy(a: Int, r: Int, n: Int): String {
    var value = a
    val string = buildString {
        for (i in 1 until n) {
            if (i == 1) append(value)
            append(", ")
            append(value * r)
            value *= r
        }
    }
    return string
}

private fun geometricSequenceElementsMy2(a: Int, r: Int, n: Int): String =
    buildList {
        (0 until n).map {
            when (it) {
                0 -> add(a)
                else -> {
                    val value: Int = this[it - 1]
                    add(value * r)
                }
            }
        }
    }.toString()

fun geometricSequenceElements(a: Int, r: Int, n: Int): String =
    generateSequence(a) { it * r }
        .take(n)
        .joinToString(", ")

fun geometricSequenceElements2(a: Int, r: Int, n: Int): String {
    return arrayListOf(a, a * r).apply {
        while (n > size) {
            add(last() * r)
        }
    }.joinToString()
}

