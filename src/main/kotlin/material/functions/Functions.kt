package material.functions

fun main() {
//    transformationMap()
//    transformationFlatMap()
//    filter()
//    combiningZip()
//    combiningFold()

    generateSequence()
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

private fun combiningFold() {
    val foldedValue = listOf(1, 2, 3, 4).fold(0) { accumulator, number ->
        println("Accumulated value: $accumulator")

        println("accumulator $accumulator + (number $number * 3) ${accumulator + (number * 3)}")
        accumulator + (number * 3)
    }
    println("Final value: $foldedValue")
}


private fun generateSequence() {

    val tenPrimes: Sequence<Int> = generateSequence(3) { value ->
        value + 1
    }
        .filter {
            it.isPrime()
        }.take(10)


    println(tenPrimes.toList())

    var count = 3

    val sequence = generateSequence {
        (count--).takeIf { it > 0 }
    }

    println(sequence.toList())

}

private fun Int.isPrime(): Boolean {
    (2 until this).map {
        if (this % it == 0) {
            return false // Не простое!
        }
    }
    return true
}
