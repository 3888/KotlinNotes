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
        val isItemsChannelLogged = false
        val itemsChannel = produceItems(isItemsChannelLogged)
        iterateItems(itemsChannel, "itemsChannel", isItemsChannelLogged)
        println()

        val isFruitsChannelLogged = false
        val fruitsChannel = produceFruitsAndClose(produceItems(isFruitsChannelLogged))
        iterateItems(fruitsChannel, "fruitsChannel", isFruitsChannelLogged)
        println()

        val isRedFruitsChannelLogged = true
        val redFruitsChannel = produceRedFruits(produceFruitsAndClose(produceItems(isRedFruitsChannelLogged)))
        iterateItems(redFruitsChannel, "redFruitsChannel", isRedFruitsChannelLogged)

        itemsChannel.cancel()
        redFruitsChannel.cancel()
        fruitsChannel.cancel()
    }
}

private fun produceItems(isLogActive: Boolean) = GlobalScope.produce {
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
        delay(10)
        if (isLogActive) {
            val type = if (it is Vegetable2) "Vegetable" else "Fruit"
            println("send ${it.name} type $type isRed ${it.isRed}")
        }
        send(it)
    }
}

private fun produceFruitsAndClose(items: ReceiveChannel<Item2>) = GlobalScope.produce {
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
        for (item in channel) {
            delay(10)
            println("$message ReceiveChannel item ${item.name}  isRed ${item.isRed}")
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

