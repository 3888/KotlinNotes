package contest.codewars.level7kyu

fun main() {


}

private fun moveTenMy(s: String): String = s.map {
    when {
        ('a'..'z').toList().indexOf(it) > 15 -> ('a'..'z').toList()[10 - (26 - ('a'..'z').toList().indexOf(it))]
        else -> ('a'..'z').toList()[('a'..'z').toList().indexOf(it) + 10]
    }
}.joinToString {
    it + ""
}.replace(", ", "")

private fun moveTen(s: String) = s.map { 'a' + (((it - 'a') + 10) % 26) }.joinToString("")