package contest.codewars.level7kyu

import kotlin.math.min

fun main() {
    createBox2(8, 7)
}


fun createBox(width: Int, length: Int) = Array(length) { r ->
    IntArray(width) { c ->
        println("ROW = $r")
        println("COLUMN = $c")
        val row = min(r + 1, length - r)
        println("r + 1 = ${r + 1} length - r ${length - r}")
        val col = min(c + 1, width - c)
        println("c + 1 = ${c + 1} width - c ${width - c}")
        min(row, col)

    }
}

fun createBox2(width: Int, length: Int): Array<IntArray> = // 8 7
    Array(length) { i ->
        IntArray(width) { j ->
            intArrayOf(
                i + 1, // 0->1 1->1 2->2 ...
                j + 1, // 0->1 1->1 2->2 ...
                width - j, // 0->8 1->7 2->6 ...
                length - i //0->7 1->6 2->4 ...
            ).minOrNull() ?: 0 // 0->1 1->1 2->2 ...
        }
    }

fun createBox3(width: Int, length: Int) =
    Array(length) { i ->
        IntArray(width) { j ->
            listOf(i, j, length - 1 - i, width - 1 - j).minOrNull()!! + 1
        }
    }