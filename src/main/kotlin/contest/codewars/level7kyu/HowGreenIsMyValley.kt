package contest.codewars.level7kyu

import java.util.*

fun main() {
   println(
       makeValley(intArrayOf(
//        79, 35, 54, 19, 35, 25
//        67, 93, 100, -16, 65, 97, 92
           66, 55, 100, 68, 46, -82, 12, 72, 12, 38
       )).contentToString()
   )

}


private fun makeValleyMyError(arr: IntArray): IntArray {
    val minValue = arr.apply { sort() }.first()

    val sorted: IntArray = arr.sortedArray()
    val sortedReversed: IntArray = sorted.reversedArray()

    val result = LinkedList<Int>()
    result.add(minValue)


    sortedReversed.forEachIndexed { index, i ->
        when {
            i == minValue -> {
                return result.toIntArray()

//                println("sortedReversed ${sortedReversed.contentToString()}")
//                println(result)
//                println("***[79, 35, 25, 19, 35, 54]***")
//                println("***[100, 93, 67, *-16*, 65, 92, 97]***")
//                println("***[100, 68, 55, 38, 12, *-82*, 12, 46, 66, 72]***")
            }

            index % 2 == 0 -> {
//                println("i = $i index = $index % 2 == 0 ${index % 2 == 0} even push")
                when {
                    result.size >= 3 -> {
                        val beforeMinValue = mutableListOf<Int>()

                        for (value in 0 until result.indexOf(minValue)) {
                            beforeMinValue.add(result[value])
                        }

//                        println("beforeMinValue $beforeMinValue")

                        while (result[0] != minValue) {
                            result.removeFirst()
                        }

//                        println("result after removeFirst $result")
                        result.push(i)

//                        println("beforeMinValue.reversed() ${beforeMinValue.reversed()}")

                        beforeMinValue.reversed().forEach {
                            result.push(it)
                        }
                    }
                    else -> {
                        result.push(i)
                    }
                }
            }

            index % 2 != 0 -> {
//                println("i = $i  index = $index % 2 != 0 ${index % 2 == 0} odd add")
                if (result.size >= 3) {
                    val afterMinValue = mutableListOf<Int>()

                    for (value in result.indexOf(minValue) + 1 until result.size) {
                        afterMinValue.add(result[value])
                    }
                    //                        println("afterMinValue $afterMinValue")

                    while (result[result.indexOf(result.last)] != minValue) {
                        result.removeLast()
                    }
//                    println("result after removeLast  $result")
                    result.add(i)

                    afterMinValue.forEach {
                        result.add(it)
                    }
                } else {
                    result.add(i)
                }
            }
        }

        println(result)
    }

    return IntArray(0)
}

fun makeValley(arr: IntArray) = arr.sortedDescending().withIndex().partition {
    it.index % 2 == 0
}.let {
    println("first ${it.first}")
    println("second ${it.second}")

    it.first.map {
        it.value
    } + it.second.map {
        it.value
    }.reversed()
}.toIntArray()


fun makeValley2(arr:IntArray):IntArray {
    var L = mutableListOf<Int>()
    var R = mutableListOf<Int>()
    var side = false
    arr.sortedDescending().forEach {
        if (side) R.add(it) else L.add(it)
        side = !side
    }
    val valley = L + R.reversed()
    return valley.toIntArray()
}