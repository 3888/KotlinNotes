package contest.codewars.level8kyu

fun main() {
    println(oddCount(200000))
    println(oddCountMy(200000))


}

private fun oddCountMy(n: Int): Int = n.downTo(1).filter {
//    println(" it = $it")
    it % 2 != 0
}.size

private fun oddCountMy2(n: Int): Int {
    var count = 0
    for (i in 1..n) {
        if (i % 2 != 0) count++
    }
    return count - 1
}

private fun oddCount(n: Int) = n / 2

private fun oddCount2(n: Int) = n shr 1