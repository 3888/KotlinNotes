package contest.codewars.level8kyu

fun main() {
    println(replace("ABCDE"))
}

private fun replaceMy(string: String): String {
    var result = string
    "aeiouAEIOU".forEach {
        result = result.replace("$it", "!")
    }

    return result
}

private fun replace(s: String) = s.replace(Regex("[aeiouAEIOU]"), "!")
private fun replace2(s: String): String = "[aeiou]".toRegex(RegexOption.IGNORE_CASE).replace(s, "!")
private fun replace3(s: String): String = Regex("[aeiouAEIOU]").replace(s, "!")
private fun replace4(s: String) = s.map { if (it in "aeiouAEIOU") '!' else it }.joinToString("")
