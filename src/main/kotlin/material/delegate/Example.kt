package material.delegate

import kotlin.random.Random


fun main() {
//    print(trimDelegate("        123     "))

    println(lazyValue)
    println(lazyValue)

}

val lazyValue: String by lazy {
    println("Result of lambda = ${Random.nextInt(0, 10)}")
    "Hello lazy String"
}

private fun trimDelegate(value: String): String {
    var param: String by TrimDelegate()
    param = value
    return param
}