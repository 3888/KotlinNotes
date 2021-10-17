package contest.ytilidoc

fun main() {
    println(solution(1123212))
}

private fun solution(value: Int): Int {
    val binaryRep =
//        "10000010001" // 5
//        "1111" // 0
//        "100000" // 0
        Integer.toBinaryString(value)
    println(binaryRep)

    if (binaryRep.filter {
            it.toString() == "1"
        }.count() == 1) return 0

    var count = 0
    var maxCount = 0
    binaryRep.forEach {

        when (it.toString()) {
            "1" -> count = 0
            "0" -> {
                count++
                if (count > maxCount) maxCount = count
            }
        }
    }

    return maxCount
}