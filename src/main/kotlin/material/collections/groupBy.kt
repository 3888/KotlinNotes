package material.collections

import contest.codewars.level6kyu.duplicateCountSolutionsExample
import contest.codewars.level6kyu.duplicateEachCount

fun main() {
//    groupBy()
//    groupByDuplicateCount()
//    groupByDuplicateEachCount()


}

private fun groupBy() {
    val words = listOf(listOf("Apple", "Boy", "Cartoon"), listOf("Elephant", "Frog"))
    val bySize = words.groupBy { it.size }
    val byCondition = words.groupBy { it.first().length > 7 }

    println("groupBy it size $bySize")
    println("groupBy condition $byCondition")
}

private fun groupByDuplicateCount() {
    println("Count of duplicated chars = ${duplicateCountSolutionsExample("ZZZZabcdefghijklmnopqrstuvwxyzaaAb")}")
}

private fun groupByDuplicateEachCount() {
    println("Count of duplicated chars = ${duplicateEachCount("ZZZZabcdefghijklmnopqrstuvwxyzaaAb")}")
}

