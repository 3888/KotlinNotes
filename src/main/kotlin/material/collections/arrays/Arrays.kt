package material.collections.arrays

import java.util.*
import kotlin.math.pow

/*
https://stackoverflow.com/questions/46235579/how-to-add-an-item-to-an-arraylist-in-kotlin
 */

fun main() {
//    arrayToString()
//    arrayErrors()
//    sortedArray()
//    sortedSet()
//    arrayExample()
    arrayRemoveDuplicates()
}

fun arrayRemoveDuplicates() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 4, 5, 6, 21, 1, 2, 34, 2, 2)
    println(array.toSet()) // set
    println(array.distinct()) // List
}


private fun sortedArray() {
    val array = intArrayOf(1, 3, 6, 4, 1, 2)
//    println(Arrays.sort(array)) // Unit
    println(array.sortedArray().contentToString())
}

private fun sortedSet() {
    val array = intArrayOf(1, 3, 6, 4, 1, 2)
    println(array.toSortedSet())
}

private fun arrayErrors() {
    val arrayOf = arrayOf("tuna", "salmon", "shark")
    val intArrayOf = intArrayOf(1, 2, 3)
//    println(Arrays.toString(intArrayOf(2, "foo"))) // Error
}

private fun arrayToString() {
    val arrayOfValues = arrayOf(1, "2")
    println(arrayOfValues.contentToString())
    println(arrayOfValues.contentToString())

    val arrayExample = Array(7) { 1000.0.pow(it) }
    println(arrayExample.contentToString())

    val fish = 12
    val plants = 5

    val swarm = listOf(fish, plants)
    val bigSwarm = arrayOf(swarm, arrayOf("dolphin", "okra", "whale"))
    println(bigSwarm.contentToString())
}

fun arrayExample() {
    val array = intArrayOf(1, 2, 3, 5)
    val valueList: List<Int> = array.map { it * 2 }
    val valueArray: IntArray = array.map { it * 2 }.toIntArray()
    val valueArray2: IntArray = IntArray(array.size) { array[it] * 2 }
}
