package contest.codewars.level8kyu


fun main() {
//    println(reverseWords2("The greatest victory is that which requires no battle"))

}

private fun reverseWordsMy(str: String): String {
    val list = mutableListOf<String>()

    str.split(" ").map {
        list.add(it)
    }

    return list.reversed().joinToString { it }.replace(",", "")
}

private fun reverseWords(str: String): String = str.split(" ").reversed().joinToString(" ")

private fun reverseWords2(str: String): String = str.split(" ").reduce { acc, string -> "$string $acc" }

