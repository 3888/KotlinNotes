package contest.codewars.level7kyu

import material.strings.regexCount

fun main() {
    println(printerError3("aaaxbbbbyyhwawiwjjjwwm"))

}

private fun printerErrorMy(s: String): String {
    val incorrectRegex = "[n-z]"
    val incorrectCount = regexCount(s, incorrectRegex)
    return "$incorrectCount/${s.length}"
}

private fun printerError(s: String) = "${s.count { it !in 'a'..'m' }}/${s.length}"

private fun printerError2(s: String): String {
    val wrong = s.count { it.toInt() > 'm'.toInt() }
    return "$wrong/${s.length}"
}

private fun printerError3(s: String): String {
    return "${s.filter { it > 'm' }
        .length
        //        .count()
    }/${s.length}"
}