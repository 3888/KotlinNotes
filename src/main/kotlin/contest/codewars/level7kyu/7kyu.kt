package contest.codewars.level7kyu


fun main() {


}

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
    when{it % 15 == 0 -> "FizzBuzz"
        it % 5 == 0 -> "Buzz"
        it % 3 == 0 -> "Fizz"
        else -> "$it"
    }
}.toTypedArray()
