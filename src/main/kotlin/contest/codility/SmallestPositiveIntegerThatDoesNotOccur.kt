package contest.codility

import java.lang.reflect.Array
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
        solutionCollections(
            intArrayOf(1, 2, 3)
//            intArrayOf(1, 3, 6, 4, 1, 2)
            //            intArrayOf(-1, -3)
        )
    )

//    println(solution(intArrayOf(-1, 3, 6)))
}

fun solution(arr: IntArray): Int {
    val newArray = arr.sortedArray().filterNot { it < 1 }

    if (newArray.size == 0) return 1

    for (i in 0 until newArray.size) {
        val current = newArray[i]
        val previous = if (i - 1 > 0) newArray[i - 1] else null
//        println("${curren     t} and ${previous}")

        if (previous != null && current - previous > 1) {
//            println("Heelloo ${previous + 1}")
            return@solution (previous + 1)
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
