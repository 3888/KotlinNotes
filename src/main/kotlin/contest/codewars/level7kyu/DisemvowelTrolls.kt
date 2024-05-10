package contest.codewars.level7kyu

fun main() {
    println(disemvowel("This website is for losers LOL!"))
}

fun disemvowelMy(str: String): String = str.filterNot { it.lowercase() in "aeiou"}

fun disemvowel(str: String): String { return str.replace(Regex("[AaEeIiOoUu]"), "") }

fun disemvowel2(str: String) = str.filter{ it.lowercaseChar() !in "aeiou"}
