package contest.codewars.level8kyu

fun main() {

    digitize(1234567890123456789)
//    reversedLongToArrayMy(1234567890123456789)
        .forEach {
            println(it)
        }
}

fun digitize(n: Long): IntArray = n.toString().map(Character::getNumericValue).toIntArray().reversedArray()

private fun reversedLongToArrayMy(n: Long): IntArray {
    /*
     https://www.codewars.com/kata/5583090cbe83f4fd8c000051/train/kotlin
     https://www.codewars.com/kata/5583090cbe83f4fd8c000051/solutions/kotlin
     */

    val reversed = n.toString().reversed()
    println("reversed $reversed")

    val arrayWrongSize = reversed.toCharArray().distinct()
    println("arrayWrongSize $arrayWrongSize")

    val list = mutableListOf<Char>()
    reversed.map {
        list.add(it)
    }
    println("list $list")

    val result = list.map {
        Character.getNumericValue(it)
    }
    println("result: $result")
    println("to arrayWrongSize: ${result.toIntArray().distinct()}")

    val array = IntArray(reversed.length)

    reversed.mapIndexed { index, c ->
        println("index $index c $c")
        array[index] = Character.getNumericValue(c)
    }
    println("arrayOfNulls ${array.size}")
    println(array)

    return array
}

private fun reversedIntNumberToArray(n: Int) {
    var num = n
    var reversed = 0

    val list = mutableListOf<Int>()
    while (num != 0) {
        val digit = num % 10
        reversed = reversed * 10 + digit
        list.add(reversed)
        num /= 10
    }

    println("Reversed Number: $reversed")

    val result = reversed.toString().map {
        "$it".toIntOrNull()
    }.filterNotNull()

    println("to array: $result")

}
