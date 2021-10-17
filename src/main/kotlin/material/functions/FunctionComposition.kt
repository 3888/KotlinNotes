package material.functions

fun main() {
    val squareOfTriple = compose(::square, ::triple)
    println(squareOfTriple(2))

    val text = compose2(::upperCase, ::revers)
    println(text("hello"))
}

private fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int =
//    { x -> f(g(x)) }
    { f(g(it)) }

private fun compose2(f: (String) -> String, g: (String) -> String): (String) -> String =
    {
        f(g(it))
    }

private fun square(n: Int) = n * n
private fun triple(n: Int) = n * 3

private fun upperCase(s: String) = s.toUpperCase()
private fun revers(s: String) = s.reversed()