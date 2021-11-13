package material.strings

fun main() {

    partitionExample()
}

private fun partitionExample() {

    println(charArrayOf('A', 'B', 'c', 'd').partition { char ->
        char.isUpperCase()
    })
}