package material.collections.arrays

import kotlin.math.pow

/*
https://stackoverflow.com/questions/46235579/how-to-add-an-item-to-an-arraylist-in-kotlin
 */

fun main() {
//    arrayToString()
//    arrayErrors()
//    sortedArray()
//    spreadOperator()
//    sortedSet()
//    arrayExample()
//    arrayRemoveDuplicates()
//    all()
//    initArray()
    minMaxArrayValue()

//    withIndex()
//    sortedDescending()

}

private fun withIndex() {
    arrayOf(66, 55, 100, 68, 46, -82, 12, 72, 12, 38)
        .withIndex()
        .map {
            print("${it.index} ")
        }

}

private fun sortedDescending() {
    println(arrayOf(66, 55, 100, 68, 46, -82, 12, 72, 12, 38).sortedDescending())
}

private fun minMaxArrayValue() {
    /*
    https://www.techiedelight.com/find-minimum-maximum-element-array-kotlin/
    */
    val arr: Array<Int> = arrayOf(6, 3, 2, 5, 10)

    val max = arr.indices.map { i: Int -> arr[i] }.maxOrNull()
    val min = arr.indices.map { i: Int -> arr[i] }.minOrNull()

    println("Minimum: $min")
    println("Maximum: $max")

    arr.sort()

    println("Minimum: ${arr.first()}")
    println("Maximum: ${arr.last()}")
}

private fun initArray() {
    /*
https://discuss.kotlinlang.org/t/arrays-from-ranges/5216
 */
    val arraySize = 10
    println(IntArray(arraySize) { it }.contentToString())           // ascending
    println(IntArray(arraySize) { arraySize - 1 - it }.contentToString())      // descending
}

private fun all() {
    val array = intArrayOf(2, 4, 6, 8, 10, 12)
    println(array.all { it % 2 == 0 })
    println(array.all { it > 2 })
    println(array.all { it.toString().isNotEmpty() })
}

private fun arrayRemoveDuplicates() {
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

private fun spreadOperator() {
    val array = arrayOf(1, 2, 3, 4, 5)
    val list = listOf("Args", *array)
    println(list)
}

private fun arrayExample() {
    val array = intArrayOf(1, 2, 3, 5)
    val valueList: List<Int> = array.map { it * 2 }
    val valueArray: IntArray = array.map { it * 2 }.toIntArray()
    val valueArray2: IntArray = IntArray(array.size) { array[it] * 2 }
}
