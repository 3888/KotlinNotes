package material.loops

import kotlin.random.Random

fun main() {
//    ifElse()
//    ternaryOperator("")
    returnIf(null)
}

private fun ifElse() {
    val age = Random.nextInt(20, 50)
    println("age is $age")
    if (age > 35) {
        println("You are older 35 years")
    } else {
        println("You are younger 35 years")
    }
}

private fun ternaryOperator(string: String) {
//    Тернарный оператор не нужен, вместо него возвращаемое значение выражения if присваивается результат
    val output = if (string.isEmpty()) "No value" else string
    println(output)
}

private fun returnIf(id: String?) {
    if (id == null) return
    print(id)
}

fun conditionalExpressions() {
//    TODO https://kotlinlang.org/docs/tutorials/kotlin-for-py/conditionals.html

}