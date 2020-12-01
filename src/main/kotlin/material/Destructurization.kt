package material

import material.loops.Customer

/*
* https://proandroiddev.com/kotlin-destructuring-declarations-46aad0ee5261
* */
fun main() {
    val customer = Customer("Smb", 34)
    val (name, age) = customer // destructuring declaration

}