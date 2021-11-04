package material.collections

import java.util.*
import kotlin.collections.ArrayList


fun main() {
//    collectionsJava()
//    collectionsKotlin()
//    listContains()
//    listContainsAll()
//    reversedExample()
//    sort()
//    sortList()
//    chunked()
//    flatten()
//    reduce()

//    mutableListAdd()
//    mutableListAddByIndex()
//    mutableListAddAll()
//    mutableListRemove()
//    mutableListSublist()
//    mutableListRemoveIf()

//    listOf()
//    map()
//    set()
//    setMutable()

//    nullableCollectionsGetOrElse()
//    nullableCollectionsGetOrNull()


}

private fun collectionsJava() {
    println(Collections.max(listOf(12, 3, 4, 5)))
    println(Collections.min(listOf(12, 3, 4, 5)))
}

private fun collectionsKotlin() {
    println("minOrNull " + listOf(1, 2, 3, 4).minOrNull())
    println("first " + listOf(1, 2, 3, 4).first())
    println("last " + listOf(1, 2, 3, 4).last())
    println("sum " + (1..4).sum())
    println(listOf("a", "b", "cd").sumBy { it.length }) //chars length of "a b cd" = 4

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

private fun reversedExample() {
    val arrayList: ArrayList<Int> = arrayListOf(1, 2, 3)
    val list: List<Int> = listOf(1, 2, 3)
    arrayList.reverse()
    list.reversed()

    println(arrayList)
    println(list)

    val original = mutableListOf('a', 'b', 'c', 'd', 'e')
    val originalReadOnly = original as List<Char>
    val reversed = originalReadOnly.asReversed()

    println(originalReadOnly)
    println(reversed)
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

private fun chunked() {
    val list = listOf("A", "B", "C", "D", "E", "F")
    println(list.chunked(1))
    println(list.chunked(2))
    println(list.chunked(3))
    println(list.chunked(10))
//    println(list.chunked(0)) // size 0 must be greater than zero
}

private fun sortList() {
    val list: List<IdList> = kotlin.collections.listOf(
        IdList(id = 4),
        IdList(id = 1),
        IdList(id = 3),
        IdList(id = 2),
        IdList(id = 0)
    )

    println(list.filter {
        it.id != 0
    }
        .sortedBy {
            it.id
        })

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
    val flattenListReduce = list
        .flatten()
        .reduce { acc, s -> "$acc & $s" }

    println(flattenListReduce)
}

private fun mutableListAdd() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    println("mutableListOfValues add dolphin ")
    mutableListOfValues.add("dolphin")
    println("mutableListOfValues = $mutableListOfValues")

    println("mutableListOfValues += golden fish")
    mutableListOfValues += ("golden fish")
    println("mutableListOfValues = $mutableListOfValues")

}

private fun mutableListAddByIndex() {
    val index = 0
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    println("mutableListOfValues add dolphin to index $index")
    mutableListOfValues.add(index, "dolphin")
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

    println("mutableListOfValues -= salmon")
    mutableListOfValues -= ("salmon")
    println("mutableListOfValues = $mutableListOfValues")
}

private fun mutableListSublist() {
    val mutableListOfValues = mutableListOf("tuna", "salmon", "shark")
    println("mutableListOfValues subList $mutableListOfValues")
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

private fun setMutable() {
    val allBooks = mutableSetOf("Macbeth", "Romeo and Juliet", "Hamlet")

    allBooks.add("Hamlet")
    println("allBooks = $allBooks")
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

private fun mutableListVsArrayList() {
//TODO
    /*
    https://proandroiddev.com/the-mystery-of-mutable-kotlin-collections-e82cbf5d781
    https://stackoverflow.com/questions/43114367/difference-between-arrayliststring-and-mutablelistofstring-in-kotlin
    * */
}

data class IdList(
    val id: Int? = null,
)