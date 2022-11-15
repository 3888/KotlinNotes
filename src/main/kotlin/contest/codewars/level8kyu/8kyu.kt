package contest.codewars.level8kyu

fun main() {

//    println(countPositivesSumNegatives().contentToString())

//    println(getAscii("A".first()))
//    println(getAscii2("A".first()))
//    println(getAscii3("A".first()))

    println(grow())

}

fun growMy(arr: IntArray = intArrayOf(1, 2, 3, 4)): Int {
    var result = 1

    arr.forEach { i ->
        result *= i
    }
    return result
}

fun grow(arr: IntArray = intArrayOf(1, 2, 3, 4)): Int = arr.reduce { acc, i -> acc * i }
fun grow1(arr: IntArray = intArrayOf(1, 2, 3, 4)): Int = arr.reduce (Int::times)

fun getAgeMy(yearsOld: String = "4 years old"): Int = yearsOld.substring(0, 1).toInt() // digitToInt()?
fun getAge(yearsOld: String = "4 years old"): Int = yearsOld.take(1).toInt()
fun getAge1(yearsOld: String = "4 years old"): Int = yearsOld.first().toInt()
fun getAge2(yearsOld: String = "4 years old"): Int = yearsOld.substring(0, 1).toInt()

private fun contains(arr: IntArray, item: Int): Boolean = arr.contains(item)
private fun contains2(arr: IntArray, item: Int) = item in arr
val contains = IntArray::contains

private fun getAscii(char: Char): Int = char.toInt()
private fun getAscii2(char: Char): Int = char.hashCode()
fun getAscii3(c: Char): Int = c.toByte().toInt()

private fun sumOfAllPositive() {
    println(arrayOf(1, 2, 3, 5, -1, -2).filter { it > 0 }.sum())
}

private fun countPositivesSumNegatives(
    input: Array<Int>? =
        arrayOf(
//                1, 2, 3, 5, -1, -2
//                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15
            0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14
        ),
): Array<Int> {
    val positive: Int
    val negative: Int
    return if (input != null && input.isNotEmpty()) {

        positive = input.count { it > 0 }
        negative = input.filter { it < 0 }.sum()
        arrayOf(positive, negative)
    } else arrayOf()
}

private fun countPositivesSumNegatives2(
    input: Array<Int>? =
        arrayOf(0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14),
): Array<Int> = if (input != null && input.isNotEmpty()) arrayOf (input.count { it > 0 }, input.filter { it < 0 }.sum())
else arrayOf()


private fun greet() {
    println("hello world!".toByteArray().contentToString())
    println(arrayOf(104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33).map { it.toChar() }.joinToString(""))

    val hello = "hello world!"
        .toByteArray()
        .map { Integer.toBinaryString(it.toInt()) }
        .reduce { acc, s -> "$acc $s" }
        .split(" ")
        .map {
            Integer.parseInt(it, 2).toChar()
        }
        .joinToString("")

    println(hello)
}

fun maps(x: IntArray): IntArray = x.map { it * 2 }.toIntArray()
fun maps2(x: IntArray): IntArray =  IntArray( x.size) { x[it] * 2 }
