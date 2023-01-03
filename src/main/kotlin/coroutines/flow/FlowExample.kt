package coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
//    simpleFlow()
//    backpressureFlow()

//    concurrentErrorFlow()
//    concurrentFlow()
//    switchContextFlow()
    errorHandling()
}

private fun simpleFlow() {
    val flowOfStrings = flow {
        for (number in 0..100) {
            emit("Emitting: $number")
        }
    }

    GlobalScope.launch {
        flowOfStrings.collect { value ->
            println(value)
        }
    }
    Thread.sleep(1000)
}

private fun backpressureFlow() {
    val flowOfStrings = flow {
        for (number in 0..100) {
            emit("Emitting: $number")
        }
    }

    GlobalScope.launch {
        flowOfStrings
            .map { "${it.last()} map" }
            .onEach { delay(100) }
            .collect { value ->
                println(value)
            }
    }
    Thread.sleep(1000)
}

private fun concurrentErrorFlow() {
    val flowOfStrings = flow {
        GlobalScope.launch {
            emit("Hello")
        }
    }

    GlobalScope.launch {
        flowOfStrings.collect {
            println("collect: $it")
        }
    }

    Thread.sleep(1000)
}

private fun concurrentFlow() {
    val flowOfStrings = channelFlow {
        withContext(Dispatchers.IO) {
            trySend("Hello")
        }
    }

    GlobalScope.launch {
        flowOfStrings.collect {
            println("collect: $it")
        }
    }
    Thread.sleep(1000)
}

private fun switchContextFlow() {
    val flowOfStrings = flow {
        for (number in 0..100) {
            emit("Emitting: $number")
        }
    }

    GlobalScope.launch {
        flowOfStrings
            .map { it.last() }
            .flowOn(Dispatchers.IO)
            .onEach { delay(100) }
            .flowOn(Dispatchers.Default)
            .collect { value ->
                println(value)
            }
    }
    Thread.sleep(1000)
}

private fun errorHandling() {
    val flowOfStrings = flow {
        emit("")
        for (number in 0..100) {
            emit("Emitting: $number")
        }
    }

    GlobalScope.launch {
        flowOfStrings
            .map { it.split(" ") }
            .map { it[1] }
            .catch {
                println("Error")
                it.printStackTrace()
                emit("Fallback")
            }
            .flowOn(Dispatchers.Default)
            .collect { println(it) }

    }
    Thread.sleep(100)
    println("The code still works!")
}