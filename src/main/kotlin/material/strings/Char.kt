package material.strings

fun main() {

    partitionExample()
}

private fun partitionExample() {
    println(charArrayOf('A', 'c', 'd', 'B').partition { char ->
        char.isUpperCase()
    })
}