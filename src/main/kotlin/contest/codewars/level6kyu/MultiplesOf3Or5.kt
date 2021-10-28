package contest.codewars.level6kyu

/*
https://www.codewars.com/kata/514b92a657cdc65150000006/train/kotlin
https://www.codewars.com/kata/514b92a657cdc65150000006/solutions/kotlin
*/

fun main() {
    multiplesOf3Or5My(15)
    println(multiplesOf3Or5(15))
}

private fun multiplesOf3Or5My(number: Int) {
    val range = 1 until number

    val values = mutableSetOf<Int>()
    range.filter {
        it % 3 == 0
    }
        .also { list ->
            list.forEach {
                values.add(it)
            }
        }

    range.filter {
        it % 5 == 0
    }
        .also { list ->
            list.forEach {
                values.add(it)

            }
        }

    println(values)
    println(values.sum())
}

fun multiplesOf3Or5(number: Int) = (1 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()