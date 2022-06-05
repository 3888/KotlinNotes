package material.collections

import material.primitives.isPrime


fun main() {
//    generateSequence(100)
    generateSequencePrimes(10)
}

private fun generateSequence(count: Int) {
    var value = count

    val sequence = generateSequence {
        (value--).takeIf { it > 0 }
    }

    println(sequence.toList())
}

private fun generateSequencePrimes(count: Int) {
    val initialValue = 3
    val primes: Sequence<Int> = generateSequence(initialValue) { value ->
        value + 1
    }
        .filter {
            it.isPrime()
        }.take(count)

    println(primes.toList())
}
