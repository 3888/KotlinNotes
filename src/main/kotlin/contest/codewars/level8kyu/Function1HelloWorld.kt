package contest.codewars.level8kyu

fun main() {
//    println("hello world!".toByteArray().contentToString())
//    println(arrayOf(104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33).map { it.toChar() }.joinToString(""))

    println(greet())

}


fun greet() = "hello world!"
    .toByteArray()
    .map { Integer.toBinaryString(it.toInt()) }
    .reduce { acc, s -> "$acc $s" }
    .split(" ")
    .map {
        Integer.parseInt(it, 2).toChar()
    }
    .joinToString("")
