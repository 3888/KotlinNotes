package material

fun main() {
//    measureNanoTime()
//    measureTimeMillis()
}

private fun measureNanoTime() {
    val endValue = 1000000
    val listOfNumbers = (0 until endValue)

    val listInNanos = kotlin.system.measureNanoTime {
// Цепочка функций для обработки списка
        listOfNumbers.map { it + 1 }.filter { it % 2 == 0 }
    }

    println("список обработан за $listInNanos наносекунд ")

    val sequenceInNanos = kotlin.system.measureNanoTime {
// Цепочка функций для обработки последовательности
        listOfNumbers.asSequence().map { it + 1 }.filter { it % 2 == 0 }

    }
    println("последовательность обработана за $sequenceInNanos наносекунд")

}

private fun measureTimeMillis() {
    val endValue = 1000000
    val listOfNumbers = (0 until endValue)

    val listInNanos = kotlin.system.measureTimeMillis {
// Цепочка функций для обработки списка
        listOfNumbers.map { it + 1 }.filter { it % 2 == 0 }
    }

    println("список обработан за $listInNanos милисекунд ")

    val sequenceInNanos = kotlin.system.measureTimeMillis {
// Цепочка функций для обработки последовательности
        listOfNumbers.asSequence().map { it + 1 }.filter { it % 2 == 0 }

    }
    println("последовательность обработана за $sequenceInNanos милисекунд")
}
