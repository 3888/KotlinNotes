package contest.codewars.level7kyu

fun main() {

}

private fun catMouseMy(s: String) = if (s.count { it == '.' } > 3) "Escaped!" else "Caught!"

fun catMouse(s: String) = if (s.length <= 5) "Caught!" else "Escaped!"

fun catMouse2(s: String): String {
    return if ("...." in s) "Escaped!" else "Caught!"
}