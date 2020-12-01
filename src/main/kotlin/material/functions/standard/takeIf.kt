package material.functions.standard

fun main() {
    takeIf()
}

private fun takeIf() {
    val length = "value".takeIf { it.length > 3 }?.length
    println(length)
}