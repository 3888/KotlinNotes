package contest.codewars.level7kyu

fun main() {
    println(validParentheses3("(((())()))"))
}

private fun validParenthesesMy(str: String): Boolean = when {
    str.length % 2 != 0 -> false
    str == ")(" -> false
    str == "))" -> false
    str == "((" -> false
    str == "()" -> true
    str.isEmpty() -> true
    (str.replace("()", "").isEmpty()) -> true
    (str.replace("()", "").isNotEmpty()) -> validParenthesesMy(str.replace("()", ""))
    else -> false
}

private fun validParentheses(str: String): Boolean =
    try {
        Regex(str); true
    } catch (error: Exception) {
        println(error) // !!! PatternSyntaxException: Unclosed group near index
        false
    }

private fun validParentheses2(str: String): Boolean {
    var s = str
    while ("()" in s) s = s.replace("()", "")
    return s == ""
}

fun validParentheses3(str: String) = str.fold(0) { acc, c ->
    if (acc < 0) return@fold -1
    if (c == '(') acc + 1 else acc - 1
} == 0