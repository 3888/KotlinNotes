package material.destructurization

import material.loops.Customer

/*
* https://proandroiddev.com/kotlin-destructuring-declarations-46aad0ee5261
* */
fun main() {

//    example()
//    listExample()
    pairExample()

}


private fun example() {
    val customer = Customer("Smb", 34)
    val (name, age) = customer // destructuring declaration

    println("$name is $age years old")

    val name2 = customer.component1()

    val age2 = customer.component2()
}

private fun listExample() {
    val list = listOf(
        "11", "22", "33", "44", "55", "66"
    )
    val menu = listOf(
        Menu("type1", "name1"), Menu("type2", "name2"),
        Menu("type3", "name3")
    )

    val (first, second, third, fourth, fifth) = list // first five elements only

    val (menu1, menu2) = menu

    println("$first $second $third $fourth $fifth")

    println("$menu1 $menu2")
}

private fun pairExample() {
    val apiParam = ApiParams.PARAM.queryParam
    val (key, value) = apiParam

    println(key)
    println(value)
}


private data class Menu(val type: String, val name: String)


private enum class ApiParams(val queryParam: Pair<String, String>) {
    PARAM("Key123" to "Value456")
}