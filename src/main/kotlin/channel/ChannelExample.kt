@file:OptIn(ExperimentalCoroutinesApi::class)

package channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() {
    runBlocking {
        val fruitArray = arrayOf("Apple", "Banana", "Pear", "Grapes", "Strawberry")

        runBlocking {
//            channelConsumerTillClose(fruitArray)

            printChannelClosedValues(fruitArray)

        }
    }
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
    fruitArray: Array<String>,
    kotlinChannel: Channel<String>,
    breakPoint: String,
    isClose: Boolean
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
    fruit: String,
    breakPoint: String,
    kotlinChannel: Channel<String>
) {
    if (fruit == breakPoint) {
        println("Channel stopped at $breakPoint")
        kotlinChannel.close()
        println("Channel stopped $fruit isClosedForSend ${kotlinChannel.isClosedForSend}")
        println("Channel stopped $fruit isClosedForReceive ${kotlinChannel.isClosedForReceive}")
    }
}