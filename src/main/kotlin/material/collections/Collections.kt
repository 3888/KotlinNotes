package material.collections


fun main() {

//    mutableListAdd()
//    mutableListAdd2()
//    mutableListAddByIndex()
//    mutableListAddAll()
//    mutableListRemove()
//    mutableListRemove2()
//    mutableListSublist()
//    mutableListRemoveIf()


//    listContains()
    listContainsAll()

//    listOf()
//    map()
//    set()

//    sort()

//    flatten()
//    reduce()
//    groupBy()

//    nullableCollectionsGetOrElse()
//    nullableCollectionsGetOrNull()
}

private fun mutableListAdd() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    println("mutableListOfValues add dolphin ")
    mutableListOfValues.add("dolphin")
    println("mutableListOfValues = $mutableListOfValues")
}

private fun mutableListAdd2() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    println("mutableListOfValues += dolphin ")
    mutableListOfValues += ("dolphin")
    println("mutableListOfValues = $mutableListOfValues")
}

private fun mutableListAddByIndex() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    println("mutableListOfValues add dolphin ")
    mutableListOfValues.add(0, "dolphin")
    println("mutableListOfValues = $mutableListOfValues")
}

private fun mutableListAddAll() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    val testValue = listOf("Fish", "Big fish")
    println("mutableListOfValues addAll $testValue")
    mutableListOfValues.addAll(testValue)
    println("mutableListOfValues = $mutableListOfValues")
}

private fun mutableListRemove() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")

    println("mutableListOfValues remove shark")
    mutableListOfValues.remove("shark")
    println("mutableListOfValues = $mutableListOfValues")
}


private fun mutableListRemove2() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")

    println("mutableListOfValues -= shark")
    mutableListOfValues -= ("shark")
    println("mutableListOfValues = $mutableListOfValues")
}


private fun mutableListSublist() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    println("mutableListOfValues subList")
    println("mutableListOfValues = ${mutableListOfValues.subList(2, mutableListOfValues.size)}")

}

private fun mutableListRemoveIf() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    val testValue = "tuna"
    println("list removeIf ")
    mutableListOfValues.removeIf {
        it == testValue
    }

    println("mutableListOfValues = $mutableListOfValues")
}

private fun listContains() {
    val list = listOf("tuna", "salmon", "shark")
    val testValue = "tuna"
    println("list contains $testValue = ${list.contains(testValue)}")
}

private fun listContainsAll() {
    val list = listOf("tuna", "salmon", "shark")
    val testValue = listOf("tuna", "salmon")

    println("list contains $testValue = ${list.containsAll(testValue)}")
    println("testValue contains $list = ${testValue.containsAll(list)}")
}

private fun listOf() {
    println(listOf(1, 5, 3).sum()) //  1 + 5 +3 = 9
    println(listOf("a", "b", "cd").sumBy { it.length })//chars length of "a b cd" = 4
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

private fun nullableCollectionsGetOrElse() {
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

private fun nullableCollectionsGetOrNull() {
    val nullableList: List<String>? = null

    println(nullableList?.getOrNull(1) ?: "List is null")
}