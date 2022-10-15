package material.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
//    joinExample()
childrenJobExample()
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