package contest.codewars.level7kyu

fun main() {
    println(
        repeats(
            intArrayOf(
                4, 5, 7, 5, 4, 8 // 15
//    9, 10, 19, 13, 19, 13 // 19
//    16, 0, 11, 4, 8, 16, 0, 11 // 12
            )
        )
    )
}

fun repeatsMy(arr: IntArray) = arr.sumOf { i -> if (arr.count { it == i } == 2) 0 else i }

fun repeats(arr: IntArray) = arr.groupBy { it }.filterValues { it.size < 2 }.keys.sum()

fun repeats2(arr: IntArray) = arr.filter { arr.count { i -> i == it } == 1 }.sum()

fun repeats3(arr: IntArray): Int {
    return arr.fold(0) { acc, n -> if (arr.count { it == n } == 1) acc + n else acc }
}





