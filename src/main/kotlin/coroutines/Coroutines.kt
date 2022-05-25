package coroutines

import kotlinx.coroutines.*
import java.util.*

fun main(): Unit = runBlocking {

    /*
    sequential examples
    * */
//    doWork(this)

//    launch {
//        doWork(this)
//    }

//    async {
//        doWork(this)
//    }

    /*
      parallel examples
      * */

    val deferredList: List<Deferred<String>> = List(10) {
        async {
            getNameWithDelay(it.toString())
        }
    }
    deferredList.forEach { println(it.await()) }
}

private suspend fun getNameWithDelay(name: String): String {
    val millis = Random().nextInt(1000).toLong()
    delay(millis)
    return "delay $millis doWork $name"
}


private suspend fun doWork(scope: CoroutineScope) {
    println("Scope $scope")
    repeat(10) {
        println(getNameWithDelay(it.toString()))
    }
}
