package material.functional_programming

import material.inheritance.Person

fun main() {
//    asSequenceVsCollectionMeasureTimeMillis()
//    asSequenceVsCollectionMeasureNanoTime()

    asSequenceExample()
}

private fun asSequenceVsCollectionMeasureNanoTime() {
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

private fun asSequenceVsCollectionMeasureTimeMillis() {
    val endValue = 1000000
    val listOfNumbers = (0 until endValue)

    val listInMillis = kotlin.system.measureTimeMillis {
        listOfNumbers.map { it + 1 }.filter { it % 2 == 0 } // Цепочка функций для обработки списка
    }

    println("список обработан за $listInMillis милисекунд ")

    val sequenceInMillis = kotlin.system.measureTimeMillis {
        listOfNumbers.asSequence().map { it + 1 }
            .filter { it % 2 == 0 } // Цепочка функций для обработки последовательности
    }
    println("последовательность обработана за $sequenceInMillis милисекунд")
}

private fun asSequenceExample() {
    val decorations = listOf("paper", "puppy", "cat", "board", "player")

    val lazyMap = decorations.asSequence().map {
        it.toUpperCase()
    }

    println("first: ${lazyMap.first()}")
    println("toList: ${lazyMap.toList()}")
    println("find: ${lazyMap.find { it.length == 3 }}")

    val people = listOf(
        Person("Alice", 29),
        Person("Bob", 31),
        Person("Charles", 31),
        Person("Dan", 21)
    )
    //Сначала map, затем filter
    val mapFilterTime = kotlin.system.measureTimeMillis {
        people.asSequence().map(Person::name).filter { it.length < 4 }.toList()
    }

    println("mapFilterTime $mapFilterTime")
    //Сначала filter, затем map
    val filterMapTime = kotlin.system.measureTimeMillis {
        people.asSequence().filter { it.name.length < 4 }.map(Person::name).toList()
    }

    println("filterMapTime $filterMapTime")
}