package contest.codewars.level8kyu

import kotlin.math.abs


fun main() {
    println(twiceAsOldAbs(55, 30))
}

private fun twiceAsOldMy(dadYearsOld: Int, sonYearsOld: Int): Int {
    var years = 0

    if (dadYearsOld - sonYearsOld * 2 > 0) years = dadYearsOld - sonYearsOld * 2
    if (dadYearsOld - sonYearsOld * 2 < 0) years = sonYearsOld * 2 - dadYearsOld

    return years
}

fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int): Int {
    val gapAge = dadYearsOld - sonYearsOld

    return if (gapAge < sonYearsOld)
        sonYearsOld - gapAge
    else
        gapAge - sonYearsOld
}

fun twiceAsOldAbs(dadYearsOld: Int, sonYearsOld: Int): Int = abs(dadYearsOld - (sonYearsOld * 2))