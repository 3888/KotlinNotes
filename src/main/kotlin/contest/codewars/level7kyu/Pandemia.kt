package contest.codewars.level7kyu

fun main() {
/*
'0' : uninfected
'1' : infected
'X' : ocean

 start: map1 = "01000000X000X011X0X"
 end:   map1 = "11111111X000X111X0X"
 total = 15
 infected = 11
 percentage = 100*11/15 = 73.33333333333333
    * */

    println(
        infectedMy("000010X000000000001X0000000X00X000X11X0X0000X10000000110000X0000X000010")
    )
}

private fun infectedMy(s: String): Double {
    val infected = s.split("X")
        .sumOf {
            if (it == "1" || it == "11" || it.contains("01") || it.contains("10")) it.count() else 0
        }

    val population = s.replace("X", "").length
    return when {
        (population == infected && population > 0) -> 100.0
        infected > 0 -> 100.0 * infected / population
        else -> 0.0
    }
}

fun infected(s: String): Double {
    var infectedPerson = 0.0
    var total = 0.0
    s.split("X").forEach {
        if (it.contains("1")) infectedPerson += it.length
        total += it.length
    }
    return if (total == 0.0) 0.0 else 100 * infectedPerson / total
}

fun infected2(s: String) =
    s.split("X").filter { "1" in it }.sumOf { it.count() } * 100.0 / (s.replace("X", "").count().takeIf { it > 0 } ?: 1)

fun infected3(s: String): Double {
    val allPopulation = s.filter { it != 'X' }.length

    if (allPopulation == 0) {
        return 0.0
    }

    val infectedPopulation = s.split('X')
        .filter { it.contains('1') }.sumOf { it.length }

    return infectedPopulation / allPopulation.toDouble() * 100
}