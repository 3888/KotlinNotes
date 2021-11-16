package material.collections

import material.Helper
import java.util.*


/*
http://developer.alexanderklimov.ru/android/kotlin/collection.php
* */

fun main() {

//    buildList()

//    collectionsJava()
//    collectionsKotlin()
//    listContains()
//    listContainsAll()
//    reversedExample()
//    sort()
//    sortList()
//    chunked()
//    flatten()
    reduce()
//    reduceRight()
//    fold(6)

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


@OptIn(ExperimentalStdlibApi::class)
fun buildList() {
    val list = listOf('a', 'b')

    val list1 = buildList {
        add('a')
        add('b')
    }

    println(list)
    println(list1)
    println(list == list1)

    val phones = buildList {
        repeat(1) {
            add(
                "+9 " +
                        "${Helper.random.nextInt(100, 1000)} " +
                        "${Helper.random.nextInt(100, 1000)} " +
                        "${Helper.random.nextInt(0, 100)} " +
                        (Helper.random.nextInt(0, 100))
            )
        }
    }

    println(phones)

}


private fun collectionsJava() {
    println(Collections.max(listOf(12, 3, 4, 5)))
    println(Collections.min(listOf(12, 3, 4, 5)))
}

private fun collectionsKotlin() {
//    println("minOrNull " + listOf(1, 2, 3, 4).minOrNull())
//    println("maxOrNull " + listOf(1, 2, 3, 4).maxOrNull())
//    println("maxOf " + listOf(1, 2, 3, 4).maxOf { it })
//    println("minOf " + listOf(1, 2, 3, 4).minOf { it })

//    println("first " + listOf(1, 2, 3, 4).first())
//    println("last " + listOf(1, 2, 3, 4).last())
    println("last " + listOf(1, 2, 3, 4).takeLast(3))

//    println("sum " + (1..4).sum())
//    println(listOf("a", "b", "cd").sumBy { it.length }) //chars length of "a b cd" = 4
//    println((listOf("1:0", "2:0", "3:0", "4:0")).sumBy {
//        val (x, y) = it.split(":")
//        when {
//            x > y -> 3
//            x < y -> 0
//            else -> 1
//        }
//    })
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
    println(list.chunked(5))
//    println(list.chunked(0)) // Error size 0 must be greater than zero
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
/*
https://www.baeldung.com/kotlin/fold-vs-reduce
https://metanit.com/kotlin/tutorial/9.8.php
* */
    val list = listOf(listOf("A", "B", "C"), listOf("E", "F", "G"))

    println("list = $list")
    val flattenListReduce = list
        .flatten()
        .reduce { accumulator, string -> "$accumulator & $string" }
    println("flatten+reduce = $flattenListReduce")

    println("array is ${intArrayOf(1, 2, 3, 4, 5).contentToString()}")
    println("1 * 2 * 3 * 4 * 5 = ${intArrayOf(1, 2, 3, 4, 5).reduce(Int::times)}")

    println("reduce ${
        listOf("1", "2", "3", "4", "5").reduce { acc, it ->
            "$acc $it" // 1 2 3 4 5 

            /*
acc - 1-й элемент, аккумулятор
it  - 2-1 следующая строка из листа
(acc = 1) (it = 2)
(acc = 1 2) (it = 3)
(acc = 1 2 3) (it = 4)
(acc = 1 2 3 4) (it = 5)
*/
//                "$it $acc" // 5 4 3 2 1
/*
it  - 1-й элемент следующая строка из листа
acc - 2-й элемент, аккумулятор
(it = 2) (acc = 1)
(it = 3) (acc = 2 1)
(it = 4) (acc = 3 2 1)
(it = 5) (acc = 4 3 2 1)
(it = 6) (acc = 5 4 3 2 1)
(it = 6) (acc = 5 4 3 2 1)
 */
        }
    }")
}

private fun reduceRight() {
    val reduceRight = listOf("1", "2", "3", "4", "5")
        .reduceRight { acc, it -> "$acc $it" }

    println("reduceRight = $reduceRight")
/*
acc - 1-й элемент, аккумулятор
string  - следующая строка из листа
(string = 2) (acc = 1)
(string = 3) (acc = 2 1)
(string = 4) (acc = 3 2 1)
(string = 5) (acc = 4 3 2 1)
(string = 6) (acc = 5 4 3 2 1)
(string = 6) (acc = 5 4 3 2 1)
 */

//                "$acc $string"
/*
acc - 1-й элемент, аккумулятор
string  - следующая строка из листа
(acc = 1) (string = 2)
(acc = 1 2) (string = 3)
(acc = 1 2 3) (string = 4)
(acc = 1 2 3 4) (string = 5)
 */

}

fun fold(n: Int) {
    println((1 until n).fold(4) { acc, i ->
        println("acc $acc + i $i = ${acc + i}")
        acc + i
    })

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