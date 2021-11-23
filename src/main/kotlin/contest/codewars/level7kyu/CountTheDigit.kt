package contest.codewars.level7kyu

fun main() {
    println(nbDig6(10, 1))

}


fun nbDigMy(n: Int, d: Int) =
    d.toString()
        .toRegex().findAll((1..n).map { it * it }.toString())
        .count()

fun nbDig(n: Int, d: Int): Int =
    (0..n)
        .map { (it * it) }
        .sumBy {
            it.toString()
                .count { it == d.toString()[0] }
        }

fun nbDig2(n: Int, d: Int) =
    (0..n)
        .map { it * it }
        .joinToString("")
        .count {
            it.toString()
                .equals(d.toString(), true)
        }

fun nbDig3(n: Int, d: Int): Int =
    (0..n)
        .joinToString { "${it * it}" }
        .count { "$it" == "$d" }

fun nbDig4(n: Int, d: Int) =
    (0..n).joinToString("") { x -> "${x * x}" }
        .filter { c -> "$c" == "$d" }
        .count()

fun nbDig5(n: Int, d: Int) =
    (0..n)
        .map { it * it }
        .joinToString("")
        .groupBy { it.toString() }[d.toString()]!!.size


fun nbDig6(n: Int, d: Int): Int =
    0.rangeTo(n)
        .map {
            it * it
        }
        .sumBy {
            it.toString().replace(Regex("[^$d]"), "").length
        }
