package material.functional_programming

import java.util.*
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis


fun main() {
//    transformationMap()
//    transformationFlatMap()

    transformationSumOf()

//    filter()

//    combiningZip()
//    combiningFold(0)

//    generateSequencePrimes(10)

//    nano()
//    milli(1000000)
}

fun transformationSumOf() {
    val data = listOf(
        TransactionsItem(
            "1",
            1000.44,
            2000.04
        ),
        TransactionsItem(
            "2",
            0020.24,
            7000.04
        ),
        TransactionsItem(
            "3",
            10770.45,
            2540.34
        )
    )

    print(
        "${
            data.sumOf {
                it.depositDollar
            }
        }"
    )
}

private fun transformationMap() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal" }
        .map { baby -> "$baby, with the cutest little tail ever!" }
    println(babies)
}

private fun transformationFlatMap() {
    val value = listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatMap {
        it
    }
    println(value)

}

private fun filter() {
    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number ->
        (2 until number)
            .map {
                println("number $number % it $it ${number % it}")
                number % it
            }
            .none {
                println("it $it == 0 ${it == 0}")
                it == 0
            }
    }
    print(primes)

}

private fun combiningZip() {
    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    println(employeeShirtSizes["Denny"])

}

private fun combiningFold(initialValue: Int) {
    println("initialValue value: $initialValue")
    val foldedValue = listOf(1, 2, 3, 4).fold(initialValue) { accumulator, number ->
        println("Accumulated value: $accumulator")

        println("accumulator $accumulator + (number $number * 3) ${accumulator + (number * 3)}")
        accumulator + (number * 3)
    }
    println("Final value: $foldedValue")
}


private fun generateSequence(count: Int) {
    var value = count

    val sequence = generateSequence {
        (value--).takeIf { it > 0 }
    }

    println(sequence.toList())
}

private fun generateSequencePrimes(count: Int) {
    val primes: Sequence<Int> = generateSequence(3) { value ->
        value + 1
    }
        .filter {
            it.isPrime()
        }.take(count)

    println(primes.toList())
}

private fun Int.isPrime(): Boolean {
    (2 until this).map {
        if (this % it == 0) {
            return false // Не простое!
        }
    }
    return true
}

private fun nano() {
    val listInNanos = measureNanoTime {
// Цепочка функций для обработки списка
        val employees = listOf("Denny", "Claudette", "Peter")
        val shirtSizes = listOf("large", "x-large", "medium")
        val employeeShirtSizes: MutableMap<String, String> = HashMap()
        for (i in employees.indices) {
            employeeShirtSizes[employees[i]] = shirtSizes[i]
        }
        println(employeeShirtSizes["Denny"])
    }

    println("список обработан за $listInNanos наносекунд ")

    val sequenceInNanos = measureNanoTime {
// Цепочка функций для обработки последовательности
        val employees = listOf("Denny", "Claudette", "Peter")
        val shirtSize = listOf("large", "x-large", "medium")
        val employeeShirtSizes = employees.zip(shirtSize).toMap()
        println(employeeShirtSizes["Denny"])
    }
    println("последовательность обработана за $sequenceInNanos наносекунд")//
}

private fun milli(count: Long) {
    val listInNanos = measureTimeMillis {
// Цепочка функций для обработки списка
        (0 until count).toList()
    }

    println("список обработан за $listInNanos милисекунд ")

    val sequenceInNanos = measureTimeMillis {
// Цепочка функций для обработки последовательности
        var value = count

        val sequence = generateSequence {
            (value++).takeIf { it <= value }
        }
    }
    println("последовательность обработана за $sequenceInNanos милисекунд")//
}

private data class TransactionsItem(
    val date: String,
    val depositEuro: Double,
    val depositDollar: Double
)
