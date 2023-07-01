@file:OptIn(ExperimentalCoroutinesApi::class)

package coroutines.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlin.random.Random

fun main() {
    val fruitArray = arrayOf("Apple", "Banana", "Pear", "Grapes", "Strawberry")

    runBlocking {
//            channelConsumerTillClose(fruitArray)
//            printChannelClosedValues(fruitArray)

//        offer(fruitArray)
//        poll(fruitArray)
    }

//    produceFruitsAndClose(fruitArray)
    produceExampleWithSafeLogic()

//    raceConditionExample(fruitArray)
//    broadCastChannelExample(fruitArray)
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

private fun produceFruitsAndClose(fruitArray: Array<String>) {
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

private fun raceConditionExample(fruitArray: Array<String>) {
    val kotlinChannel = Channel<String>()
    val firstConsumer = mutableListOf<String>()
    val secondConsumer = mutableListOf<String>()

    runBlocking {
//  Producer
        GlobalScope.launch {
// Send data in channel
            fruitArray.forEach {
                kotlinChannel.send(it)
                delay(10)
            }
        }

//  Consumers
        GlobalScope.launch {
            kotlinChannel.consumeEach { value ->
                firstConsumer.add(value)
            }
        }
        GlobalScope.launch {
            kotlinChannel.consumeEach { value ->
                secondConsumer.add(value)
            }
        }

        delay(500)
        kotlinChannel.close()

        /*
         there are two consumers — i.e., two consumeEach calls on the channel being executed to consume the values being
         emitted by the channel. Now, which of these two consumers gets the value is not obvious
         */

        println("firstConsumer $firstConsumer")
        println("secondConsumer $secondConsumer")
    }
}

@ObsoleteCoroutinesApi
private fun broadCastChannelExample(fruitArray: Array<String>) {
    val kotlinChannel = BroadcastChannel<String>(
//       Channel.RENDEZVOUS // Error
//       Channel.UNLIMITED// Error
//       Channel.CONFLATED // all data send
        Channel.BUFFERED // without first?
    )

    val firstConsumer = mutableListOf<String>()
    val secondConsumer = mutableListOf<String>()

    runBlocking {

//  Producer
        GlobalScope.launch {
// Send data in channel
            fruitArray.forEach {
                kotlinChannel.send(it)
                delay(100)
            }
        }

//  Consumers
        GlobalScope.launch {
            kotlinChannel.consumeEach { value ->
                firstConsumer.add(value)
            }
        }
        GlobalScope.launch {
            kotlinChannel.consumeEach { value ->
                secondConsumer.add(value)
            }
        }



        delay(600)
        kotlinChannel.close()

        /*
         there are two consumers — i.e., two consumeEach calls on the channel being executed to consume the values being
         emitted by the channel. Now, which of these two consumers gets the value is not obvious
         */

        println("firstConsumer $firstConsumer")
        println("secondConsumer $secondConsumer")
    }
}

private fun produceExampleWithSafeLogic() {
    val producer = GlobalScope.produce(capacity = 10) {
        while (isActive) {
//            if (!isClosedForSend) {
//                val number = Random.nextInt(0, 20)
//                if (trySend(number).isSuccess) {
//                    println("$number sent")
//                } else {
//                    println("$number discarded")
//                }
//        }

            val number = Random.nextInt(0, 20)
            send(number)
            println("$number sent")

        }
    }
    Thread.sleep(30L)

    /*
  As you can see the previous code generates 10 elements — the capacity of the
    channel — and then it discards the following because the channel is full
    * */

}

