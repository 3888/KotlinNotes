package coroutines

import kotlinx.coroutines.*
import java.util.*

fun main(): Unit = runBlocking {

//sequentialExamples(this)
//    parallelExamples(this)
//    joinExample(this)
}

private suspend fun getNameWithDelay(name: String): String {
    val millis = Random().nextInt(1000).toLong()
    delay(millis)
    return "delay $millis doWork $name"
}

private suspend fun doWork(scope: CoroutineScope) {
    println("Scope $scope")
    println("Thread ${Thread.currentThread().name}")
    repeat(5) {
        println(getNameWithDelay(it.toString()))
    }
}

private suspend fun sequentialExamples(scope: CoroutineScope) {
//    doWork(scope)

//    scope.launch {
//        doWork(scope)
//    }

//    scope.async {
//        doWork(scope)
//    }
}

private suspend fun parallelExamples(scope: CoroutineScope) {
    val deferredList: List<Deferred<String>> = List(10) {
        scope.async {
            getNameWithDelay(it.toString())
        }
    }
    deferredList.forEach { println(it.await()) }
}

private suspend fun joinExample(scope: CoroutineScope) {
    val job = scope.launch {
        repeat(3) {
            println("Coroutine count $it, it's still working  ${Thread.currentThread().name}")
            delay(1000L)
        }
    }
    println("job is join and waiting ")
    job.join()
    println("job is done  ${Thread.currentThread().name}")
}
