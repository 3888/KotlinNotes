package contest.codewars.level7kyu

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


fun main() {

//    overTheRoad(1, 3) // 6
//    overTheRoad(3,3) // 4
//    overTheRoad(2, 3) // 5
//    overTheRoad(3,5) //
//    overTheRoad(7,11) // 16
//    overTheRoad(20, 1000000) //1999981

    val formatter = DateTimeFormatter.ofPattern("ss.SSS")
    val localDateTime = LocalDateTime.now()

//    println("hashset ${localDateTime.format(formatter)} " + overTheRoadHashSet(20, 1000000)) // no
//    println("list ${localDateTime.format(formatter)} " + overTheRoadList(20, 1000000)) // no
    println("array ${localDateTime.format(formatter)} " + overTheRoadArray(20, 1000000)) // no
}

private fun overTheRoadList(address: Int, n: Int): Int {
    val street = 1..n * 2
    val evens = street.filter { it % 2 == 0 }.reversed()
    val odds = street.filter { it % 2 > 0 }

    return if (address % 2 == 0) odds[evens.indexOf(address)] else evens[odds.indexOf(address)]
}

private fun overTheRoadHashSet(address: Int, n: Int): Int {
    val street: HashSet<Int> = (1..n * 2).toHashSet()
    val evens: List<Int> = street.filter { it % 2 == 0 }.reversed()
    val odds: List<Int> = street.filter { it % 2 > 0 }


    return if (address % 2 == 0) odds[evens.indexOf(address)] else evens[odds.indexOf(address)]
}

private fun overTheRoadArray(address: Int, n: Int): Int =
    IntArray(n) { (n * 2) - it }[address - 1]
//    LongArray(n) { (n * 2L) - it }[address - 1].toInt()


private fun overTheRoad(address: Int, n: Int): Int = n * 2 + 1 - address // !!!




