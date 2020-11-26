package material.loops

fun main() {
    /*
    https://grokonez.com/kotlin/kotlin-foreach-foreachindexed-method-array-list-map-collection
    */
    forEachIndexed()
    forEachIndexed2()
    forEachIndexedList()
    forEachIndexedList2()

}

private fun forEachIndexed() {
    val simpleArray = arrayOf(1, 2, 3, 4)
    simpleArray.forEachIndexed{index, element -> println("index = $index, element = $element")}
}

private fun forEachIndexed2() {
    val customerList = arrayOf(
        Customer("Craig", 45),
        Customer("Amos", 23),
        Customer("Jack", 20)
    )
    customerList.forEachIndexed{ index, customer -> println("index = $index, customer = $customer")}
}

private fun forEachIndexedList() {
    val simpleList = listOf(5, 6, 7, 8)
    simpleList.forEachIndexed{index, element -> println("index = $index, element = $element")}
}

private fun forEachIndexedList2() {
    val customerList  = listOf(
        Customer("Craig", 45),
        Customer("Amos", 23),
        Customer("Jack", 20)
    )
    customerList.forEachIndexed{index, customer -> println("index = $index, customer = $customer")}
}


