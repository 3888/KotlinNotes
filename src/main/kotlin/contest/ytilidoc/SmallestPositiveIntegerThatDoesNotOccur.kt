package contest.ytilidoc

import java.util.*
import kotlin.collections.ArrayList


fun main() {
//    println(
//        solutionArrays(
////        intArrayOf(1, 2, 3)
//            intArrayOf(1, 3, 6, 4, 1, 2)
//        )
//    )

    println(
//        solution(
            solutionCollections(
//            intArrayOf(1, 2, 3)
//            intArrayOf(1, 3, 6, 4, 1, 2)
            intArrayOf(1, 3, 6, 4, 1, 5, 2, 7, 9, 11, 8)
//            intArrayOf(-1, -3)
        )
    )

//    println(solution(intArrayOf(-1, 3, 6)))
}

private fun solution(arr: IntArray): Int {
    val newArray = arr.sortedArray().filterNot { it < 1 }
//    println(newArray)
    if (newArray.isEmpty()) return 1

//    println(newArray.indices)
    for (i in newArray.indices) {
//        println(i)
        val current = newArray[i]
//        println("current $current")
        val previous = if (i - 1 > 0) newArray[i - 1] else null
//        println("previous $previous")

        if (previous != null && current - previous > 1) {
            println("current - previous = ${current - previous}")
            return (previous + 1)
        }

    }
    return newArray[newArray.size - 1] + 1
}

private fun solutionArrays(array: IntArray): Int { // TODO wrong
    Arrays.sort(array)

    val minArrayValue = array[0]
    val maxArrayValue = array[array.size - 1]

    val allValues = mutableListOf<Int>()

    for (i in minArrayValue..maxArrayValue) {
        allValues.add(i)
    }


    val test: ArrayList<Int> = array.toCollection(ArrayList())
    allValues.removeAll(test)

    var answer = 0
    for (i in allValues) {
        if (answer <= 0) answer = i
        if (answer > i) {
            answer = i
        }
    }

    return answer
}

private fun solutionCollections(array: IntArray): Int {
    Arrays.sort(array)
    val minArrayValue = array[0]
    val maxArrayValue = array[array.size - 1]

    val positiveValues = mutableListOf<Int>()

    for (i in minArrayValue..maxArrayValue) {
        positiveValues.add(i)
    }

    val test: ArrayList<Int> = array.toCollection(ArrayList())

    positiveValues.removeAll(test)

    if (positiveValues.size == 0) return array[array.size - 1] + 1

    if (Collections.min(positiveValues) < 0) return 1

    return Collections.min(positiveValues)
}
