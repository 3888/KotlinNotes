package coroutines

import kotlinx.coroutines.*
import java.util.*

fun main(): Unit = runBlocking {

//sequentialExamples(this)
    parallelExamples(this)
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

//    val deferredList: List<Deferred<String>> = List(10) {
//        scope.async(start = CoroutineStart.LAZY) {
//            getNameWithDelay(it.toString())
//        }
//    }
//    deferredList.forEach { println(it.await()) }
}

private suspend fun parallelExamples(scope: CoroutineScope) {
//    val deferredList: List<Deferred<String>> = List(10) {
//        scope.async {
//            getNameWithDelay(it.toString())
//        }
//    }
//    deferredList.forEach { println(it.await()) }

    val documentsList = listOf(
        Document("1", "111"),
        Document("2", "222"),
        Document("3", "333"),
        Document("4", "444"),
        Document("5", "555")
    )

    val documentIds = getDocumentsIds()
    val documents: List<Deferred<Document>> = documentIds.map { id ->
        scope.async {
            getDocumentById(id, documentsList)
        }
    }

    println(documents.awaitAll())

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

private fun getDocumentById(id: String, list: List<Document>): Document = list.filter { it.id == id }[0]

private fun getDocumentsIds() = listOf("3", "5")

private data class Document(val id: String, val data: String)