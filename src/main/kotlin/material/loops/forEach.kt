package material.loops

fun main() {
    /*
  https://grokonez.com/kotlin/kotlin-foreach-foreachindexed-method-array-list-map-collection
  */

    forEach()
    forEach2()
    forEachList()
    forEachList2()
    forEachMap()
    forEachMap2()
}

private fun forEach() {
    val simpleArray = arrayOf(1, 2, 3, 4)
    simpleArray.forEach { println(it) }
}

private fun forEach2() {
    val customerArray = arrayOf(
        Customer("Craig", 45),
        Customer("Amos", 23),
        Customer("Jack", 20)
    )
    customerArray.forEach { println(it) }
}

private fun forEachList() {
    val simpleList = listOf(5, 6, 7, 8)
    simpleList.forEach { println(it) }
}

private fun forEachList2() {
    val customerList = listOf(
        Customer("Craig", 45),
        Customer("Amos", 23),
        Customer("Jack", 20)
    )
    customerList.forEach { println(it) }
}

private fun forEachMap() {
    val simpleHashMap = hashMapOf(1 to "one", 2 to "two", 3 to "three")
    simpleHashMap.forEach { println(it) }
}

private fun forEachMap2() {
    val customerHashMap = hashMapOf(
        "Smith" to Customer("Smith", 26),
        "Peter" to Customer("Peter", 43),
        "Mary" to Customer("Mary", 27)
    )
    customerHashMap.forEach { println(it) }
}

data class Customer(val name: String, val age: Int)