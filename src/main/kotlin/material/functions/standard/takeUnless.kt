package material.functions.standard

fun main() {
    takeUnless()
}

private fun takeUnless() {
    val length = "value".takeUnless { it.isEmpty() }?.length
    println(length)
}