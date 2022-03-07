package contest.codewars.level8kyu

fun main() {

}

private fun feast(beast: String, dish: String): Boolean =
    "${beast.first()}${beast.last()}" == "${dish.first()}${dish.last()}"