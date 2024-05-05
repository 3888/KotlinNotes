package contest.codewars.level7kyu

import kotlin.math.min


fun babyCount(x: String): Int? {
    val a = minOf(
        x.toLowerCase().count { it == 'b' } / 2,
        x.toLowerCase().count { it == 'a' },
        x.toLowerCase().count { it == 'y' },
    )
    return if (a == 0) null else a
}

fun babyCount2(x: String): Int? {
    val count: Map<Char, Int> = x.toLowerCase().groupingBy { it }.eachCount()
    return listOf(count['a'] ?: 0, (count['b'] ?: 0) / 2, count['y'] ?: 0).minOrNull()?.takeIf { it > 0 }
}

fun babyCount3(x: String): Int? {
    val _x = x.toLowerCase().replace(Regex("[^aby]"), "");
    val b = Regex("b").findAll(_x).toList().size;
    val a = Regex("a").findAll(_x).toList().size;
    val y = Regex("y").findAll(_x).toList().size;
    val count =
        min(b / 2, min(a, y))
//    minOf(b / 2, a, y)
    return if (count > 0) count else null
}

fun babyCount4(x: String): Int? {
//    println(x)
    val count = Regex("baby|babi", RegexOption.IGNORE_CASE).findAll(x).count()
    return if (count > 0) count else null
}