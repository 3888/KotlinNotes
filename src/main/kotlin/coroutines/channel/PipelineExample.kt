package coroutines.channel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

data class Fruit(override val name: String, override val color:
String) : Item
data class Vegetable(override val name: String, override val
color: String) : Item

@ExperimentalCoroutinesApi
fun main() {
    // ------------ Helper Methods ------------
    fun isFruit(item: Item): Boolean = item is Fruit
    fun isRed(item: Item): Boolean = (item.color == "Red")
    // ------------ Pipeline ------------
// 1
    fun produceItems() = GlobalScope.produce {
        val itemsArray = ArrayList<Item>()
        itemsArray.add(Fruit("Apple", "Red"))
        itemsArray.add(Vegetable("Zucchini", "Green"))
        itemsArray.add(Fruit("Grapes", "Green"))
        itemsArray.add(Vegetable("Radishes", "Red"))
        itemsArray.add(Fruit("Banana", "Yellow"))
        itemsArray.add(Fruit("Cherries", "Red"))
        itemsArray.add(Vegetable("Broccoli ", "Green"))

        itemsArray.add(Fruit("Strawberry", "Red"))
// Send each item in the channel
        itemsArray.forEach {
            send(it)
        }
    }
    // 2
    fun isFruit(items: ReceiveChannel<Item>) = GlobalScope.produce {
        for (item in items) {
// Send each item in the channel only if it is a fruit
            if (isFruit(item)) {
                send(item)
            }
        }
    }
    // 3
    fun isRed(items: ReceiveChannel<Item>) = GlobalScope.produce {
        for (item in items) {
// Send each item in the channel only if it is red in color
            if (isRed(item)) {
                send(item)
            }
        }
    }
    runBlocking {
// 4
        val itemsChannel = produceItems()
// 5
        val fruitsChannel = isFruit(itemsChannel)
// 6
        val redChannel = isRed(fruitsChannel)
// 7
        for (item in redChannel) {
            print("${item.name}, ")
        }
// 8
        redChannel.cancel()
        fruitsChannel.cancel()
        itemsChannel.cancel()
// 9
        println("Done!")
    }
}

interface Item {
    val name: String
    val color: String
}