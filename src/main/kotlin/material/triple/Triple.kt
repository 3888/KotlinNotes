package material.triple

fun main() {
    val (a, b, c) = Triple(2, "x", listOf(null))
    println("a type is ${a::class.simpleName}") // 2
    println("b type is ${b::class.simpleName}") // x
    println("c type is $c") // [null]
}