package contest.codewars.level7kyu

fun main() {



}

private fun solve(s: String): String =
    if (s.filter { it.isUpperCase() }.count() > s.length / 2) s.toUpperCase() else s.toLowerCase()


private fun hasMoreUppercaseThanLowercase(inputString: String): Boolean {
    val (upperCases, lowerCases) = inputString.toCharArray().partition { char -> char.isUpperCase() }
    return upperCases.size > lowerCases.size
}