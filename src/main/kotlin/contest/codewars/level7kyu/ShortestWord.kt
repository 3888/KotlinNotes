package contest.codewars.level7kyu

fun main() {

    println(findShort("bitcoin take over the world maybe who knows perhaps"))
}

private fun findShortMy(s: String): Int = s.split(" ")
    .map {
        it.length
    }
    .minOf { it }

private fun findShort(s: String): Int = s.split(" ").minOf { it.length }

fun findShort2(s: String): Int = s.splitToSequence(' ').minOf(CharSequence::length)

fun findShort3(s: String): Int = s.split(" ").minOf(String::length)

fun findShort4(s: String): Int = s.split(" ").asSequence().sortedBy { it.length }.first().length

