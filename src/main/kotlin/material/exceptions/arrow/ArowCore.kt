package material.exceptions.arrow

import arrow.core.Either
import arrow.core.Failure
import arrow.core.Success
import arrow.core.Try
import kotlin.system.measureNanoTime


/*
https://habr.com/ru/post/435254/
https://habr.com/ru/company/maxilect/blog/447380/
* */

fun main() {
//    either()
    eitherVsTryCatch()

    tryExample()
}

private fun either() {
    val x = parse("123")
    val y = parse("123dfgh")
    println(x)
    println(y)

    val valueX = when (x) {
        is Either.Left -> when (x.a) {
            is NumberFormatException -> "Not a number!"
            else -> "Unknown error"
        }
        is Either.Right -> "Number that was parsed: ${x.b}"
    }

    println(valueX)

    val valueY = when (y) {
        is Either.Left -> when (y.a) {
            is NumberFormatException -> "Not a number!"
            else -> "Unknown error"
        }
        is Either.Right -> "Number that was parsed: ${y.b}"
    }

    println(valueY)
}

private fun parse(value: String): Either<NumberFormatException, Int> =
    if (value.matches(Regex("-?[0-9]+"))) {
        Either.Right(value.toInt())
    } else {
        Either.Left(NumberFormatException("$value is not a valid integer."))
    }

private fun eitherVsTryCatch() {
    val value = "123ss"

    val sequenceInNanosEither = measureNanoTime {
        println(parse(value))
    }
    println("sequenceInNanosEither обработана за $sequenceInNanosEither наносекунд")

    val sequenceInNanosTryCatch = measureNanoTime {
        try {
            if (value.matches(Regex("-?[0-9]+"))) {
                println(value.toInt())
            } else {
                println(value.toInt())
            }
        } catch (e: Exception) {
            println(e)
        }
    }
    println("sequenceInNanosTryCatch обработана за $sequenceInNanosTryCatch наносекунд")
}

private fun tryExample() {
    val result =
        Try { Integer.parseInt("Bang!") }

    when (result) {
        is Success -> println(result)
        is Failure -> println(result)
    }
}