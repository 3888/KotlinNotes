package coroutines

import kotlinx.coroutines.*
import java.util.*

fun main() {
//    joinExample()
//childrenJobExample()

    runBlocking {
        //sequentialExamples(this)
        parallelExamples(this)
        //    joinExample(this)
    }
}

private fun joinExample() {
    val job1 = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(200)
        println("Pong")
        delay(200)
    }

    GlobalScope.launch {
        delay(200)
        println("Ping")
        job1.join()
        println("Ping")
        delay(200)
    }
    Thread.sleep(1000)
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

private fun childrenJobExample() {
    with(GlobalScope) {
        val parentJob1 = launch {
            println("I’m the parent1")
            delay(200)
        }

        val parentJob2 = launch {
            println("I’m the parent2")
            delay(200)
        }

        launch(context = parentJob1) {
            println("I’m a child of parentJob1")
            delay(200)
        }

        if (parentJob1.children.iterator().hasNext()) {
            println("The $parentJob1 has children ${parentJob1.children}")
        } else {
            println("The Job has NO children")
        }
        Thread.sleep(1000)

        println("$parentJob1")

        if (parentJob2.children.iterator().hasNext()) {
            println("The $parentJob2 has children ${parentJob2.children}")
        } else {
            println("The $parentJob2 has NO children")
        }
        Thread.sleep(1000)
        println("$parentJob2")
    }
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

private fun getDocumentById(id: String, list: List<Document>): Document = list.filter { it.id == id }[0]

private fun getDocumentsIds() = listOf("3", "5")

private data class Document(val id: String, val data: String)