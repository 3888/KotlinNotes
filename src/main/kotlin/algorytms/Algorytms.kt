package algorytms

fun main() {
//    fibonacciFor(10)
    println(factorial(7))
}

/*
https://www.programiz.com/kotlin-programming/examples/fibonacci-series
 */

private fun fibonacciFor(n: Int) {
    var t1 = 0
    var t2 = 1

    print("First $n terms: ")

    for (i in 1..n) {
        if (i == 1) print("$t1 ") else print("+ $t1 ")

        val sum = t1 + t2
        t1 = t2
        t2 = sum
    }
}


private fun factorial(n: Int): Int {
    var factorial = 1
    for (i in 1..n + 1) factorial *= i
    return factorial
}