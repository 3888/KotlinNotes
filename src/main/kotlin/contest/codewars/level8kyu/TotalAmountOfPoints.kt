package contest.codewars.level8kyu

fun main() {
//    pointsMy(listOf("1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3"))
}

private fun pointsMy(games: List<String>): Int {
    val list = games.map { it.split(":") }
    var points = 0

    list.forEach {
        val x = it[0]
        val y = it[1]
        if (x > y) points += 3
        if (x == y) points += 1
    }



        return points
}

fun points(games: List<String>) =
    games.sumBy {
        val (x, y) = it.split(":") // Destructurization
        when {
            x > y -> 3
            x == y -> 1
            else -> 0
        }
    }

fun points2(games: List<String>) =
    games.map { if (it.first() > it.last()) 3 else if (it.first() == it.last()) 1 else 0 }.sum()