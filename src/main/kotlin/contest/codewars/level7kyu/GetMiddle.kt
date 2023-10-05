package contest.codewars.level7kyu

fun main() {
    println(getMiddle("testing"))
}


fun getMiddle(word: String): String = if (word.length % 2 == 0) {
    word.substring(word.length / 2 - 1, word.length / 2 + 1)
} else {
    word.substring(word.length / 2, word.length / 2 + 1)
}