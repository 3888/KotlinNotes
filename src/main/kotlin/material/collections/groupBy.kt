package material.collections

import codewars.duplicateCount

fun main() {
    groupBy()
    groupByDuplicateCount()
}

private fun groupBy() {
    val words = listOf(listOf("Apple", "Boy", "Cartoon"), listOf("Elephant", "Frog"))
    val bySize = words.groupBy { it.size }
    val byCondition = words.groupBy { it.first().length > 7 }

    println("groupBy it size $bySize")
    println("groupBy condition $byCondition")
}

private fun groupByDuplicateCount() {
    println("Count of duplicated chars = ${duplicateCount("ZZZZabcdefghijklmnopqrstuvwxyzaaAb")}")
}

