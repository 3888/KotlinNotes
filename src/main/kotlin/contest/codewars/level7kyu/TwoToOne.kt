package contest.codewars.level7kyu

fun main() {
    val a = "xyaabbbccccdefww"
    val b = "xxxxyyyyabklmopq"
    println(longest4(a, b))
}

private fun longestMy(s1: String, s2: String): String = s1.plus(s2)
    .toSortedSet().toString()
    .replace(Regex("[ ,\\[\\]]"), "")


private fun longest(s1: String, s2: String): String = (s1.plus(s2)).toSortedSet().joinToString("")

private fun longest2(s1: String, s2: String): String = "$s1$s2".toSortedSet().joinToString("")

private fun longest3(s1: String, s2: String): String =
    "abcdefghijklmnopqrstuvwxyz".filter {
        it in s1 || it in s2
    }

fun longest4(s1: String, s2: String): String = (s1 + s2).asSequence().sorted().distinct().joinToString("")