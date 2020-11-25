package material.loops

import java.util.*

class WhenExample
/*
https://kotlinlang.ru/docs/reference/control-flow.html
http://developer.alexanderklimov.ru/android/kotlin/when.php
*/

fun main() {

    printAsList()
}

private fun printAsList() {
    //    Initialize with a dynamic code
    val array1 = Array(5) { it * 3 - 2 * 2 }
    println(array1.asList())

    val array2 = Array(5) { it * (3 - 2) * 2 }
    println(array2.asList())
}
