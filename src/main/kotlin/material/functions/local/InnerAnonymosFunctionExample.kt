package material.functions.local

fun main() {
    val innerAnonymousFunMultiplyByTwo = outerFunCreateMultiplier(2)
    val innerAnonymousFunMultiplyByThree = outerFunCreateMultiplier(3)

    println(innerAnonymousFunMultiplyByTwo(4)) // Output: 8
    println(innerAnonymousFunMultiplyByThree(4)) // Output: 12
}

fun outerFunCreateMultiplier(factor: Int): (Int) -> Int {
//    return fun(number: Int): Int {
//        return number * factor
//    }
    return { number -> number * factor } //  or we can use it as lambda
}