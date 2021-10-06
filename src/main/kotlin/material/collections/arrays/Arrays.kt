package material.collections.arrays

import java.util.*
import kotlin.math.pow

/*
https://stackoverflow.com/questions/46235579/how-to-add-an-item-to-an-arraylist-in-kotlin
 */

fun main() {
//    arrayToString()
//    arrayErrors()
    sortedArray()
}

fun sortedArray() {
    val array = intArrayOf(1, 3, 6, 4, 1, 2)
//    println(Arrays.sort(array)) // Unit
    println(array.sortedArray().contentToString())
    println(array.toSortedSet())
}

private fun arrayErrors() {
    val arrayOf = arrayOf("tuna", "salmon", "shark")
    val intArrayOf = intArrayOf(1, 2, 3)
//    println(Arrays.toString(intArrayOf(2, "foo"))) // Error
}

private fun arrayToString() {
    val arrayOfValues = arrayOf(1, "2")
    println(Arrays.toString(arrayOfValues))
    println(arrayOfValues.contentToString())

    val arrayExample = Array(7) { 1000.0.pow(it) }
    println(arrayExample.contentToString())

    val fish = 12
    val plants = 5

    val swarm = listOf(fish, plants)
    val bigSwarm = arrayOf(swarm, arrayOf("dolphin", "okra", "whale"))
    println(Arrays.toString(bigSwarm))
}