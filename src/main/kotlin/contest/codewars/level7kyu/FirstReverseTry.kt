package contest.codewars.level7kyu

fun main() {
    println(firstReverseTry(intArrayOf()).contentToString())
}


fun firstReverseTryMy(arr: IntArray): IntArray {
    if (arr.isEmpty()) return arr
    val first = arr.first()
    arr[0] = arr.last()
    arr[arr.lastIndex] = first
    return arr
}

fun firstReverseTry(arr: IntArray) = if (arr.size < 2) arr
else arr.copyOf().apply { this[0] = arr[lastIndex]; this[lastIndex] = arr[0] }