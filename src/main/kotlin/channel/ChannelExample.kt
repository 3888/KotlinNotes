@file:OptIn(ExperimentalCoroutinesApi::class)

package channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

fun main() {
    val fruitArray = arrayOf("Apple", "Banana", "Pear", "Grapes", "Strawberry")
    runBlocking {
//            channelConsumerTillClose(fruitArray)
//            printChannelClosedValues(fruitArray)

//        offer(fruitArray)
        poll(fruitArray)
    }

//    produceFruits(fruitArray)

}

private suspend fun printChannelClosedValues(fruitArray: Array<String>) {
    val kotlinChannel = Channel<String>()
    GlobalScope.launch {
        putDataToChannel(fruitArray, kotlinChannel, fruitArray[3], true)
        putDataToChannel(fruitArray, kotlinChannel, "", false)
    }
// Another way to iterate over the channel values
// You use channel.receive() to
// get the messages one by one

    repeat(2) {
        delay(150)
        val fruit = kotlinChannel.receive()
        println("repeat i = $it $fruit")
    }

    try {
        while (!kotlinChannel.isClosedForReceive) {
            val value = kotlinChannel.receive()
            println("value received $value")
        }
    } catch (e: Exception) {
        println("ERROR $e")
        println("isClosedForSend  ${kotlinChannel.isClosedForSend}")
        println("isClosedForReceive  ${kotlinChannel.isClosedForReceive}")
    }
}

private suspend fun channelConsumerTillClose(fruitArray: Array<String>) {
    val kotlinChannel = Channel<String>()
    GlobalScope.launch {
        putDataToChannel(fruitArray, kotlinChannel, fruitArray[4], true)
    }

    for (fruit in kotlinChannel) {
        delay(50)
        println("consumer $fruit")
        println("$fruit isClosedForSend  ${kotlinChannel.isClosedForSend}")
        println("$fruit isClosedForReceive  ${kotlinChannel.isClosedForReceive}")
    }
}

private suspend fun putDataToChannel(
    fruitArray: Array<String>, kotlinChannel: Channel<String>, breakPoint: String, isClose: Boolean
) {
    for (fruit in fruitArray) {
        kotlinChannel.send(fruit)
        println("send $fruit")
        if (isClose) {
            delay(100)
            stopChannel(fruit, breakPoint, kotlinChannel)
        }
    }
}

private fun stopChannel(
    fruit: String, breakPoint: String, kotlinChannel: Channel<String>
) {
    if (fruit == breakPoint) {
        println("Channel stopped at $breakPoint")
        kotlinChannel.close()
        println("Channel stopped $fruit isClosedForSend ${kotlinChannel.isClosedForSend}")
        println("Channel stopped $fruit isClosedForReceive ${kotlinChannel.isClosedForReceive}")
    }
}

private fun produceFruits(fruitArray: Array<String>) {
    val fruits = GlobalScope.produce {
        for (fruit in fruitArray) {
            send(fruit)
// Conditional close
            if (fruit == "Pear") {
// Signal that closure of channel. Than we'll receive ClosedSendChannelException
                close()
            }
        }
    }

    runBlocking {
        fruits.consumeEach { println(it) }
        println("Done!")
    }

}

private fun offer(fruitArray: Array<String>) {
    val kotlinChannel = Channel<String>()
    runBlocking {
        launch {
            for (fruit in fruitArray) {
                val wasSent = kotlinChannel.trySend(fruit).isSuccess //  .offer(fruit) is deprecated

                if (wasSent) {
                    println("Sent: $fruit")
                } else {
                    println("$fruit wasn’t sent")
                }
            }
            kotlinChannel.close()
        }

        for (fruit in kotlinChannel) {
            println("Received: $fruit")
        }
        println("Done!")
    }
}

private fun poll(fruitArray: Array<String>) {
    val kotlinChannel = Channel<String>()
    runBlocking {
        launch {
            for (fruit in fruitArray) {
                if (fruit == "Pear") {
                    break
                }
                println("Sent: $fruit")
                kotlinChannel.send(fruit)
            }
        }

        launch {
            repeat(fruitArray.size) {
                val fruit = kotlinChannel
                    .tryReceive()
                // .poll() is deprecated
//                if (fruit != null) {
                if (fruit.isSuccess) {
                    println("Received: $fruit")
                } else {
                    println("Channel is empty")
                }
                delay(500)
            }
            println("Done!")
        }
    }
}

