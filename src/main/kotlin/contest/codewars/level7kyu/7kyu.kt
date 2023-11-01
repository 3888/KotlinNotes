package contest.codewars.level7kyu

import kotlin.math.sqrt


fun main() {
    println(
        hidePasswordFromConnectionMy("jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?password=12345&user=root")
    )


}

fun hidePasswordFromConnectionMy(urlString: String): String =
    "${urlString.split("?").first()}?${urlString.split("?").last().split("&").joinToString("&") {
        if (it.contains("password")) "password=${it.split("=").last().map { "*" }.joinToString("")}"
        else it
    }}"

fun hidePasswordFromConnectionRegex(url: String): String {
    return Regex("(?<=password=)[^&]*").replace(url) { "*".repeat(it.value.length) }
}


fun alphaSeqMy(str: String): String =
    str.map { it.lowercase() }.sorted().joinToString("").fold("") { acc: String, c: Char ->
        "$acc${(c.toString().repeat(c.code - 96)).capitalize()},"
    }.dropLast(1)

fun alphaSeq(str: String) =
    str.toLowerCase().toCharArray().sorted().joinToString(",") { it.toString().repeat(it.toInt() - 96).capitalize() }

fun capitalizeMy(text: String): List<String> = listOf(
    text.foldIndexed("") { index, acc, c ->
        "$acc${if (index % 2 == 0) c.uppercase() else c}"
    }, text.foldIndexed("") { index, acc, c ->
        "$acc${if (index % 2 != 0) c.uppercase() else c}"
    }
)

fun capitalize(text: String): List<String> =
    listOf(
        text.mapIndexed { index, c -> if (index % 2 == 0) c.uppercaseChar() else c }.joinToString(""),
        text.mapIndexed { index, c -> if (index % 2 == 1) c.uppercaseChar() else c }.joinToString("")
    )

fun alphaSeq2(str: String): String =
    str.lowercase().toList().sorted().joinToString(",") {
        it.toString().repeat(it.code - 96)
            .replaceFirstChar { char -> char.uppercase() }
    }

fun alphaSeq3(str: String) =
    str.toLowerCase().toList().sorted().joinToString(",") { "$it".repeat(it - '`').capitalize() }

fun leaderBoard(user: String, userScore: Int, yourScore: Int): String {
    val aim = userScore - yourScore
    return when {
        aim < 0 -> "Winning!"
        aim == 0 -> "Only need one!"
        aim / 3 + 1 > 1000 -> "To beat $user's score, I must complete ${aim / 3} Beta kata and ${aim % 3} 8kyu kata. Dammit!"
        else -> "To beat $user's score, I must complete ${aim / 3} Beta kata and ${aim % 3} 8kyu kata."
    }
}


private fun findScreenHeightMy(width: Int, ratio: String): String =
    "$width" + "x" + "${
        ((width.toDouble() / ratio.split(":").first().toInt()) * ratio.last().toString().toInt()).toInt()
    }"

fun findScreenHeight(width: Int, ratio: String): String {
    val (w, h) = ratio.split(":").map { it.toInt() }
    return "${width}x${width * h / w}"
}

fun findScreenHeight2(width: Int, ratio: String) =
    "${width}x${ratio.split(":").let { width * it[1].toInt() / it[0].toInt() }}"

private fun smallEnoughMy(a: IntArray, limit: Int): Boolean = a.sorted().last() <= limit
private fun smallEnoughMy2(a: IntArray, limit: Int): Boolean = a.maxOrNull()!! <= limit
private fun smallEnough(a: IntArray, limit: Int) = a.all { it <= limit }

private fun predictAge(vararg ages: Int): Int = sqrt(ages.map { it * it * 1.0 }.sum()).div(2).toInt()

private fun reverseLetter(str: String): String = str.replace(Regex("[^a-zA-Z]"), "").reversed()

private fun filterListMy(l: List<Any>): List<Int> =
    l.asSequence().filter { it is Int && it % 2 >= 0 }.mapNotNull { it as? Int }.toList()

fun filterList(l: List<Any>): List<Any> = l.mapNotNull { it as? Int }

fun fizzBuzzMy(n: Int): Array<String> = Array(n) {
    when {
        (it + 1) % 3 == 0 -> "Fizz"
        (it + 1) % 5 == 0 -> "Buzz"
        (it + 1) % 3 == 0 && (it + 1) % 5 == 0 -> "FizzBuzz"
        else -> "${it + 1}"
    }
}

fun fizzBuzz(n: Int) = (1..n).map {
    when {
        it % 15 == 0 -> "FizzBuzz"
        it % 5 == 0 -> "Buzz"
        it % 3 == 0 -> "Fizz"
        else -> "$it"
    }
}.toTypedArray()
