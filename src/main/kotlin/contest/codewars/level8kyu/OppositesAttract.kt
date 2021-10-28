package contest.codewars.level8kyu

fun main() {

//    println(loveFun(0, 0))
    println(loveFunMy(1, 4)) // true
    println(loveFunMy(2, 2)) // false
    println(loveFunMy(0, 1)) // true
    println(loveFunMy(0, 0)) // false
}

private fun loveFunMy(flowerA: Int, flowerB: Int): Boolean {

    if (flowerA == flowerB) return false

    return (flowerA + flowerB) % 2 != 0
}

private fun loveFun(flowerA: Int, flowerB: Int): Boolean = (flowerA + flowerB) % 2 == 1

private fun loveFun2(flowerA: Int, flowerB: Int): Boolean = (flowerA + flowerB) % 2 != 0

private fun loveFun3(flowerA: Int, flowerB: Int): Boolean = (flowerA % 2 == 0) != (flowerA % 2 == 0)

