package contest.codewars.level7kyu

fun main() {
    println(
        crapMy(
            arrayOf(
                charArrayOf('_', '_'),
                charArrayOf('_', '@'),
                charArrayOf('D', '_')
            ),
            2,
            7
        )
    )

}


private fun crapMy(x: Array<CharArray>, bags: Int, cap: Int): String = when {
    x.map { it.contentToString() }.toString().contains("D") -> "Dog!!"
    x.map { it.contentToString() }.toString().count { it == '@' } <= bags * cap -> "Clean"
    else -> "Cr@p"
}

fun crap(x: Array<CharArray>, bags: Int, cap: Int) =
    if (x.any { chars -> chars.any { it == 'D' } }) "Dog!!"
    else if (x.sumOf { chars -> chars.count { it == '@' } } <= bags * cap) "Clean"
    else "Cr@p"

