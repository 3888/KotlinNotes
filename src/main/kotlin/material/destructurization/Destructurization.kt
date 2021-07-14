package material.destructurization

import material.loops.Customer

/*
https://proandroiddev.com/kotlin-destructuring-declarations-46aad0ee5261
*/
fun main() {

//    example()
//    listExample()
    oneListElementExample()
//    pairExample()
//dataClassExample()

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

private fun oneListElementExample() {
    val list = listOf(
        "11", "22", "33", "44", "55", "66"
    )

    val (first, _, third, _, fifth) = list // first five elements only

    println("$first  $third  $fifth")
}

private fun pairExample() {
    val apiParam = ApiParams.PARAM.queryParam
    val (key, value) = apiParam

    println(key)
    println(value)
}

/*
http://developer.alexanderklimov.ru/android/kotlin/data.php
*/
private fun dataClassExample() {
    val music = Music("Smoke on the water", "Deep Purple")
    val title = music.component1()
    val author = music.component2()
    println("$title $author")

    val (title1, author1) = music
    println("$title1 $author1")
}

private data class Menu(val type: String, val name: String)

private data class Music(val title: String, val author: String)

private enum class ApiParams(val queryParam: Pair<String, String>) {
    PARAM("Key123" to "Value456")
}