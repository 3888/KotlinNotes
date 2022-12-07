package channel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


@ExperimentalCoroutinesApi
fun main() {
    runBlocking {

        val fruitsChannel = produceFruits( produceItems())
        iterateItems(fruitsChannel, "iterate fruitsChannel", true)
        println()

        delay(200)
        val redFruitsChannel = produceRedFruits( produceItems())
        iterateItems(redFruitsChannel, "iterate redFruitsChannel", true)

        redFruitsChannel.cancel()
        fruitsChannel.cancel()
    }
}

private fun produceItems() = GlobalScope.produce {
    val itemsArray = ArrayList<Item2>()
    itemsArray.add(Fruit2("Apple", true))
    itemsArray.add(Fruit2("Strawberry", true))
    itemsArray.add(Fruit2("Cherries", true))
    itemsArray.add(Fruit2("Banana", false))
    itemsArray.add(Fruit2("Grapes", false))

    itemsArray.add(Vegetable2("Broccoli ", false))
    itemsArray.add(Vegetable2("Zucchini", false))
    itemsArray.add(Vegetable2("Radishes", true))

    itemsArray.forEach {
        println("send ${it.name} is Vegetable ${it is Vegetable2}")
        delay(10)
        send(it)

    }
}

private fun produceFruits(items: ReceiveChannel<Item2>) = GlobalScope.produce {
    for (item in items) {
// Send each item in the channel only if it is a fruit
        if (isFruit(item)) send(item)
    }
}

private fun produceRedFruits(items: ReceiveChannel<Item2>) = GlobalScope.produce {
    for (item in items) {
// Send each item in the channel only if it is red in color
        if (item.isRed) send(item)
    }
}

private suspend fun iterateItems(channel: ReceiveChannel<Item2>, message: String, isLogActive: Boolean) {
    if (isLogActive) {
        println("$message ")

        for (item in channel) {
            delay(10)
            println("ReceiveChannel item ${item.name}  isRed ${item.isRed}")
        }
    }
}

private fun isFruit(item: Item2): Boolean = item is Fruit2

private data class Fruit2(
    override val name: String, override val isRed:
    Boolean
) : Item2

private data class Vegetable2(
    override val name: String, override val
    isRed: Boolean
) : Item2

private interface Item2 {
    val name: String
    val isRed: Boolean
}

