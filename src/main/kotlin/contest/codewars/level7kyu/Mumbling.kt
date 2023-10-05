package contest.codewars.level7kyu

fun main() {
    println(accumMy("ZpglnRxqenU"))
}

private fun accumMy(s: String): String {
    var result = ""
    s.forEachIndexed { index, c ->
        result += if (index == 0) s.first().plus("-").uppercase()
        else s[index].toString().repeat(index + 1).lowercase()
            .replaceFirstChar(Char::titlecase).plus("-")
        println(result)
    }

    return result.dropLast(1)
}

private fun accum(s: String): String =
    s.mapIndexed { index, char -> char.uppercase() + char.toString().lowercase().repeat(index) }.joinToString("-")

fun accum2(s:String) = s.lowercase().mapIndexed { i, c -> c.toString().repeat(i + 1).capitalize() }.joinToString("-")