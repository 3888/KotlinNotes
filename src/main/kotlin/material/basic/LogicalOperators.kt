package material.basic

fun main() {
    val bool = true
    val x = 9
    val y = 3
    val z = 9

    val hardExpression = !(x != z) && bool || z > (x + y) && (!bool || y < z)
    println("!(x != z) && bool ${!(x != z) && bool}")
    println("z > (x + y) && (!bool || y < z) ${z > (x + y) && (!bool || y < z)}")
    println(hardExpression)


    val a = 10
    val b = 5
    val hardExpression2 = a != b == (b >= a) && (b <= b) || a == b
    println(hardExpression2 && true != false)
}