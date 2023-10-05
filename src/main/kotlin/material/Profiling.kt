package material

fun main() {
//    measureNanoTime()
//    measureTimeMillis()

    measureBooleanToString()
}

private fun measureNanoTime() {
    val endValue = 1000000
    val listOfNumbers = (0 until endValue)

    val list = kotlin.system.measureNanoTime {
// Цепочка функций для обработки списка
        listOfNumbers.map { it + 1 }.filter { it % 2 == 0 }
    }

    println("список обработан за $list наносекунд ")

    val sequence = kotlin.system.measureNanoTime {
// Цепочка функций для обработки последовательности
        listOfNumbers.asSequence().map { it + 1 }.filter { it % 2 == 0 }

    }
    println("последовательность обработана за $sequence наносекунд")

}

private fun measureTimeMillis() {
    val endValue = 1000000
    val listOfNumbers = (0 until endValue)

    val list = kotlin.system.measureNanoTime {
// Цепочка функций для обработки списка
        listOfNumbers.map { it + 1 }.filter { it % 2 == 0 }
    }

    println("список обработан за $list милисекунд ")

    val sequence = kotlin.system.measureTimeMillis {
// Цепочка функций для обработки последовательности
        listOfNumbers.asSequence().map { it + 1 }.filter { it % 2 == 0 }

    }
    println("последовательность обработана за $sequence милисекунд")
}

private fun measureBooleanToString() {
    fun measureExecutionTime(block: () -> String): Long {
        val time = kotlin.system.measureNanoTime {
            block()
        }
        println("Execution time: $time")
        return time
    }


    measureExecutionTime { convertToString(true) }
    measureExecutionTime { convertToStringReturn(true) }
    measureExecutionTime { convertInterpolation(true) }
    measureExecutionTime { convertInterpolationReturn(true) }
    measureExecutionTime { convertIfElse(true) }
    measureExecutionTime { convertWhenFun(true) }

    println("*************Execution time high order fun vs fun ***************")
    measureExecutionTime { convertIfElse(true) }
    var result = ""
    val time = kotlin.system.measureNanoTime {
        result = if (true) "true" else "false"
    }
    println("Execution time of fun: $time")

}

fun convertInterpolation(b: Boolean) = "$b"

fun convertInterpolationReturn(b: Boolean): String {
    return "$b"
}

fun convertToString(b: Boolean) = b.toString()

fun convertToStringReturn(b: Boolean): String {
    return b.toString()
}

fun convertWhenFun(b: Boolean) = when (b) {
    true -> "true"
    false -> "false"
}

fun convertIfElse(b: Boolean) = if (b) "true" else "false"