package material.functions.composition

fun main() {
//    val squareOfTriple = composeExampleInt(
//        ::square, ::triple
//         ::triple, ::square
//    )
//    println(squareOfTriple(2))
//
//    val text = composeExampleString(::upperCase, ::revers)
//    println(text("hello"))

    val test = composeExampleGeneric(
//        ::triple, ::square // OK
        ::upperCase, ::revers  // OK
//        ::upperCase, ::square // Error
    )
    println(test(
//        2
        "hello"
    ))
}

/*
С помощью параметров типов можно не только определить функцию compose, способную работать
 с любыми типами (при условии их совпадения)
* */
private fun <T, U, V> composeExampleGeneric(
    function1: (U) -> V,
    function2: (T) -> U
): (T) -> V = { function1(function2(it)) }

private fun composeExampleInt(
    function1: (Int) -> Int,
    function2: (Int) -> Int
): (Int) -> Int =
//    { namedArg -> function1(function2(namedArg)) }
    { function1(function2(it)) }

private fun composeExampleString(f: (String) -> String, g: (String) -> String): (String) -> String =
    {
        f(g(it))
    }

private fun square(n: Int) = run {
    println("n = $n n*n = ${n * n}")
    n * n
}

private fun triple(n: Int) = run {
    println("n = $n n*3 = ${n * 3}")
    n * 3
}

private fun upperCase(s: String) = s.toUpperCase()
private fun revers(s: String) = s.reversed()