package contest.codewars.level8kyu

fun main() {
    println("hello world!".toByteArray().contentToString())
    println(arrayOf(104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33).map { it.toChar() }.joinToString(""))

    println(greet())

    println(arrayOf(1, 2, 3, 5, -1, -2).filter { it > 0 }.sum())

    println(
        countPositivesSumNegatives(
            arrayOf(
//                1, 2, 3, 5, -1, -2
//                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15
                0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14
            )
        ).contentToString()
    )

}




fun countPositivesSumNegatives(input: Array<Int>?): Array<Int> {
    val positive: Int
    val negative: Int
    return if (input != null && input.isNotEmpty()) {

        positive = input.filter { it > 0 }.count()
        negative = input.filter { it < 0 }.sum()
        arrayOf(positive, negative)
    } else arrayOf()
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
