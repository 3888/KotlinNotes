package contest.codewars.level7kyu

import kotlin.math.sqrt


fun main() {

    partlist(
        arrayOf("cdIw", "tzIy", "xDu", "rThG")
    )
}

fun partlist(arr: Array<String>): Array<Array<String>> {

    val array: Array<Array<String>> = Array(arr.size - 1) {
        Array(2) { "" }
    }
    val pair = arrayOf("", "")

    arr.forEachIndexed { index, char ->
        if (index + 1 == arr.size) return@forEachIndexed


        pair[0] = "${pair[0]} $char".trim()
        pair[1] = arr.drop(index + 1).reduce { acc, s -> "$acc $s" }


        array[index] = pair
println("ADDED ${pair.contentToString()}")
    }
    println(array.map { it.contentToString() })
//    val a = "EBALA [[cdIw, tzIy xDu rThG], [cdIw tzIy, xDu rThG], [cdIw tzIy xDu, rThG]]"
//    println(a)

    return array
}

fun twoOldestAgesMy(ages: List<Int>): List<Int> = ages.sorted().drop(ages.size - 2)
fun twoOldestAges(ages: List<Int>): List<Int> = ages.sorted().takeLast(2)
fun reverseMy(a: List<String>): List<String> {
    var strReversed = a.fold("") { acc, s ->
        acc + s
    }.reversed()

    val list = mutableListOf<String>()

    a.indices.forEach {
        list.add(strReversed.take(a[it].length))
        strReversed = strReversed.drop(a[it].length)
    }
    return list
}

fun reverse(a: List<String>): List<String> {
    val str: CharIterator = a.joinToString("").reversed().iterator()
    return a.map { Array(it.length) { str.nextChar() }.joinToString("") }
}

fun reverse2(a: List<String>): List<String> {
    var str = a.joinToString("").reversed()
    return a.map {
        val s = str.take(it.length)
        str = str.drop(it.length)
        s
    }
}

fun nameValue(arr: Array<String>): IntArray = arr.mapIndexed { index, s ->
    s.split(" ").sumOf { str ->
        str.fold(0) { acc: Int, c: Char ->
            acc + c.code - 96
        }
    }.times(index + 1)
}.toIntArray()

fun hidePasswordFromConnectionMy(urlString: String): String = "${urlString.split("?").first()}?${
    urlString.split("?").last().split("&").joinToString("&") {
        if (it.contains("password")) "password=${it.split("=").last().map { "*" }.joinToString("")}"
        else it
    }
}"

fun hidePasswordFromConnectionRegex(url: String): String {
    return Regex("(?<=password=)[^&]*").replace(url) { "*".repeat(it.value.length) }
}


fun alphaSeqMy(str: String): String =
    str.map { it.lowercase() }.sorted().joinToString("").fold("") { acc: String, c: Char ->
        "$acc${(c.toString().repeat(c.code - 96)).capitalize()},"
    }.dropLast(1)

fun alphaSeq(str: String) =
    str.toLowerCase().toCharArray().sorted().joinToString(",") { it.toString().repeat(it.toInt() - 96).capitalize() }

fun capitalizeMy(text: String): List<String> = listOf(text.foldIndexed("") { index, acc, c ->
    "$acc${if (index % 2 == 0) c.uppercase() else c}"
}, text.foldIndexed("") { index, acc, c ->
    "$acc${if (index % 2 != 0) c.uppercase() else c}"
})

fun capitalize(text: String): List<String> =
    listOf(
        text.mapIndexed { index, c -> if (index % 2 == 0) c.uppercaseChar() else c }.joinToString(""),
        text.mapIndexed { index, c -> if (index % 2 == 1) c.uppercaseChar() else c }.joinToString("")
    )

fun alphaSeq2(str: String): String = str.lowercase().toList().sorted().joinToString(",") {
    it.toString().repeat(it.code - 96).replaceFirstChar { char -> char.uppercase() }
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


private fun findScreenHeightMy(width: Int, ratio: String): String = "$width" + "x" + "${
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
