package contest.codility

import java.util.*
import kotlin.collections.ArrayList


fun main() {
    println(solutionArrays(intArrayOf(-1, 3, 6)))
    println(solutionCollections(intArrayOf(1, 3, 6, 4, 1, 2, 8)))
}

private fun solutionArrays(array: IntArray): Int {
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
    var maxArrayValue = 0
    var minArrayValue = 0
    for (i in array) {
        if (i > maxArrayValue) maxArrayValue = i
        if (minArrayValue == 0) minArrayValue = i
        if (i < minArrayValue) minArrayValue = i
    }

    val positiveValues = mutableListOf<Int>()

    for (i in minArrayValue..maxArrayValue) {
        positiveValues.add(i)
    }

    val test: ArrayList<Int> = array.toCollection(ArrayList())

    positiveValues.removeAll(test)

    return Collections.min(positiveValues)
}
