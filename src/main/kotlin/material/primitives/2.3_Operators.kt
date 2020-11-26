package material.primitives

import material.printInt

//https://www.callicoder.com/kotlin-operators/

fun main(args: Array<String>) {
    var fish = 2;

    println("times ${fish.times(6)}")
    printInt(fish.div(2))
    printInt(fish.plus(3))
    printInt(fish.minus(1))
    fish = 25
    println("dec ${fish.dec()}")
    println("inc ${fish.inc()}")

    println("% vs .rem ${1234 % 10}")
    println("% vs .rem ${1234.rem(10)}")


    var name: String = "3888"
    var first = 1
    var second = 2

    println("Hello " + name)
    println("Hello $name")
    println("Value = ${first + second}")

    var string: String = "String"
    var byte: Byte = 1
    var short: Short = 1
    var int: Int = 1
    var float: Float = 1F
    var double: Double = 1.0
    var long: Long = 1
    var char: Char = 'a'
    var booleanDefaultValueFalse: Boolean = false
    var booleanDefaultValueTrue: Boolean = true
    var itnToLong = int.toLong()

    1.toLong()
    val boxed: Number = 1
    println("${boxed::class.simpleName}")
    println("${boxed.toLong()::class.simpleName}")

    val valIsUnchangeableValue = 1
//     UnchangeableValue = 2 //error: val cannot be reassigned
    var varIsChangeableValue = 1
    varIsChangeableValue = 2
//    varIsChangeableValue = "no" //error: type mismatch: inferred type is String but Int was expected

    val byteValue: Byte = 1
//    val intValue: Int = byteValue // error: type mismatch: inferred type is Byte but Int was expected
    val intValue: Int = byteValue.toInt() // by casting

    val underScoreSyntax = 1_000_000
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

}