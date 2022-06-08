package contest.codewars.level8kyu


fun main() {

    println(
//       reverseSeqMy(3)
//   reverseSeq(3)
        reverseSeq2(3)
    )
}


private fun reverseSeqMy(n: Int): List<Int> {
    /*
    https://www.codewars.com/kata/5a00e05cc374cb34d100000d/train/kotlin
     */
    val list = mutableListOf<Int>()

    (1..n).map {
        list.add(it)
    }

    return list.reversed()
}

private fun reverseSeq(n: Int) = (n downTo 1).toList()

private fun reverseSeq2(n: Int) = List(n) {
    println("n = $n it = $it n - it = ${n - it}")
    n - it
}

fun reverseSeq3(n: Int): List<Int> = IntRange(1, n).reversed().toList()

