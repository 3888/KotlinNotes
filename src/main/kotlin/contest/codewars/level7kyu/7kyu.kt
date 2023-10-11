package contest.codewars.level7kyu


fun main() {
    println(
        "krishan".uppercase()
    )
}

private fun reverseLetter(str: String): String = str.replace(Regex("[^a-zA-Z]"), "").reversed()



