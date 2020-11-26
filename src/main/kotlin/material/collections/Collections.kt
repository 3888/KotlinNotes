package material.collections

import java.lang.Exception

fun main() {
//    mutableList()
//    listOf()
//    map()
//    set()

//    sort()

//    flatten()
//    reduce()
//    groupBy()

    nullableCollections()
}

private fun mutableList() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    println("mutableListOfValues = $mutableListOfValues")

    println("mutableListOfValues contains salmon = ${mutableListOfValues.contains("salmon")}")

    println("mutableListOfValues remove shark")
    mutableListOfValues.remove("shark")
    println("mutableListOfValues = $mutableListOfValues")

    println("mutableListOfValues add dolphin = ${mutableListOfValues.add("dolphin")}")
    println("mutableListOfValues = $mutableListOfValues")

    println("mutableListOfValues subList")
    println("mutableListOfValues = ${mutableListOfValues.subList(2, mutableListOfValues.size)}")
}

private fun listOf() {
    println(listOf(1, 5, 3).sum()) //  1 + 5 +3 = 9
    println(listOf("a", "b", "cd").sumBy { it.length })//chars length of "a b cd" = 4
}

private fun map() {
    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(cures.get("white spots"))
    println(cures["white spots"])
    println(cures.getOrDefault("Bla-bla", "sorry I don't know it"))

    cures.getOrElse("Bla-bla") { println("There is no spoon ${3 + 4}") }

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory["tank scrubber"] = 3
    inventory.remove("fish net")

    val moreBooks = mutableMapOf("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)
}

private fun set() {
    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "Hamlet", "A Midsummer Night's Dream")
    println("allBooks = $allBooks")

    val library = mapOf("William Shakespeare " to allBooks)
    println(library.any { it.value.contains("Hamlet") })
}


private fun sort() {
    val mutableList = mutableListOf("C", "D", "W", "A", "S", "Y")

    val index = mutableList.indexOf("W")
    val value = mutableList[index]

    mutableList.removeAt(index)
    mutableList.sort()
    mutableList.add(0, value)

    println(mutableList)
}


private fun flatten() {
    val list = listOf(listOf("A", "B", "C"), listOf("E", "F", "G"))

    println(list)
    val flattenList = list.flatten()

    println(flattenList)
}

private fun reduce() {
    val list = listOf(listOf("A", "B", "C"), listOf("E", "F", "G"))

    println(list)
    val flattenList = list
            .flatten()
            .reduce { acc, s -> "$acc & $s" }

    println(flattenList)
}

private fun groupBy() {
    val words = listOf(listOf("A", "B", "C"), listOf("E1", "F"))
    val bySize = words.groupBy { it.size }

    val byLogic = words.groupBy { it.first().length > 1 }

    println(bySize)
    println(byLogic)
}

private fun nullableCollections() {
//    val nullableList: List<String>? = listOf("A", "B", "C")
    val nullableList: List<String>? = null

    nullableList?.forEach { i ->
        println(i.length)
    }

    nullableList.orEmpty().forEach { i ->
        println(i.length)
    }


    println(nullableList?.getOrElse(4) { "Else" })
}