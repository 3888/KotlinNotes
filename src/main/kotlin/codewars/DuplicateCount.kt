package codewars

/*
https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/kotlin

https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/solutions/kotlin
 */
fun main() {

}

fun duplicateCountWorkbook() {
    val charArray =
//        "abcde".toCharArray()
//        "abcdea".toCharArray()
        "abcdeaB".toLowerCase().toCharArray()
    println("array  ${String(charArray)}")
    val keyArray = charArray.distinct()
    println("keyArray  $keyArray")

    val duplicateCount = mutableListOf<String>()

    keyArray.forEachIndexed { index, char ->
        val count = charArray.filter {
            it == char
        }.count()
        duplicateCount.add(index, "$count")
    }

    println("duplicateCount $duplicateCount")

    val occursDuplicateCountList = duplicateCount.map { it.toInt() }.filter { it > 1 }


    println("result ${occursDuplicateCountList.size}")

}

fun duplicateCount(text: String): Int {
    val charArray = text
        .toLowerCase()
        .toCharArray()
    val keyArray = charArray.distinct()

    val duplicateCount = mutableListOf<String>()

    keyArray.forEachIndexed { index, char ->
        val count = charArray.filter {
            it == char
        }.count()
        duplicateCount.add(index, "$count")
    }

    val occursDuplicateCountList = duplicateCount.map { it.toInt() }.filter { it > 1 }

    return occursDuplicateCountList.size
}

