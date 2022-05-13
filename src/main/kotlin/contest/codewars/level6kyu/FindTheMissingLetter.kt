package contest.codewars.level6kyu


fun main() {
    println(
        findMissingLetter2(
            charArrayOf(
//                'a', 'b', 'c', 'd', 'f'
            'O', 'Q', 'R', 'S'
            )
        )
    )
}

private fun findMissingLetter(array: CharArray): Char {
    for (i in array.first()..array.last()) {
        if (array.contains(i).not()) return i
    }
    return ' '
}

private fun findMissingLetter2(array: CharArray): Char =
    (array.first()..array.last()).filterNot { array.contains(it) }.first()

fun findMissingLetter3(array: CharArray) = (array.first()..array.last()).first { it !in array }

fun findMissingLetter4(array: CharArray) = (array.first()..array.last()).find { !array.contains(it) }


