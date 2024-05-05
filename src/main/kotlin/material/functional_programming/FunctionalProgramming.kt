package material.functional_programming


fun main() {
//    transformationMap()
//    transformationMapIndexed()
//    transformationFlatMap()

//    transformationSumOf()

//    filter()

//    combiningZip()
//    combiningFold(0)

//    generateSequencePrimes(10)


        val primes: Sequence<Int> = generateSequence(0) { value ->
            value + 1
        }.take(10)

    println(primes.toList())

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

fun transformationMapIndexed() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal" }
        .mapIndexed { index, baby -> "index $index $baby, with the cutest little tail ever!" }
    println(babies)
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

private data class TransactionsItem(
    val date: String,
    val depositEuro: Double,
    val depositDollar: Double
)

