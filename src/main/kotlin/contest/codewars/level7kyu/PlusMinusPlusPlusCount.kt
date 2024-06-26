package contest.codewars.level7kyu

fun main() {

}


fun catchSignChangeMy(arr: Array<Int>): Int = if (arr.isEmpty()) 0 else {
    var isChanged: Boolean = arr.first() >= 0
    var count = 0

    arr.forEach { value ->

        if (isChanged != value >= 0) {
            count++
            isChanged = value >= 0
        }
    }
    count
}

private fun catchSignChange(arr: Array<Int>): Int = arr.map { it > 0 }.zipWithNext { a, b -> a != b }.count { it }

private fun catchSignChange2(arr: Array<Int>): Int {
    if (arr.isEmpty()) return 0

    var count = 0
    var bool = isChanged(arr.first())
    for (a in arr) {
        if (bool != isChanged(a)) {
            count++
            bool = isChanged(a)
        }
    }
    return count
}

private fun isChanged(i: Int): Boolean = i >= 0

private fun catchSignChange3(arr: Array<Int>): Int =
    arr.asList().zipWithNext().count(::diffSign) // count with Predicates

private fun diffSign(pair: Pair<Int, Int>): Boolean =
    if (pair.first < 0) pair.second >= 0
    else pair.second < 0


private fun catchSignChange4(arr: Array<Int>): Int {
    var count = 0
    for (i in 0..arr.size - 2) {
        val s1 = arr[i] < 0
        val s2 = arr[i + 1] < 0
        if (s1 != s2) count++
    }
    return count
}