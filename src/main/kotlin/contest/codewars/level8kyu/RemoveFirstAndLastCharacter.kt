package contest.codewars.level8kyu

fun main() {

    println(
        removeChar("*12345*")
    )
}

private fun removeChar(str: String): String =
//    str.substring(1, str.lastIndex)
//    str.substring(1, str.length - 1)
//    str.substring(range = 1..str.length - 2)
    str.substring(range = 1 until str.length - 1)
