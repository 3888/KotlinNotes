package material.strings

fun main() {
    val string = buildString {
        for(i in 1..10) {
            append(1)
        }
    }
    println(string)
}
