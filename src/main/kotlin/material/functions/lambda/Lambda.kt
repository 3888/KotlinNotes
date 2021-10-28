package material.functions.lambda

fun main() {

    val hello = { println("Hello") } //expression as lambda


    { println("Hello Kotlin") }() // call lambda

    run { println("Hello Kotlin from run") } // call lambda

}

private fun lambdaParams() {
    { message: String -> println(message) }("Welcome to Kotlin") // call lambda with params

    val printer = { params: String -> println(params) } // lambda with params
    printer("Hello printer")
}

private fun lambdaAsFunctionParams() {
    val sum = { x: Int, y: Int -> x + y }
    doOperation(3, 4, sum)                          // 7
    doOperation(3, 4, { a: Int, b: Int -> a * b }) // 12

}

private fun trailing(){
    doOperation(3, 4, { a: Int, b: Int -> a * b }) // 12
    doOperation(3, 4) { a: Int, b: Int -> a * b } // 12
}

private fun doOperation(x: Int, y: Int, op: (Int, Int) -> Int) {
    val result = op(x, y)
    println(result)
}