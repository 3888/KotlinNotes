package channel.demultiplexer

import channel.Item
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
fun main() {
    data class Fruit(
        override val name: String, override val
        color: String
    ) : Item

    data class Vegetable(
        override val name: String, override val
        color: String
    ) : Item

    // ------------ Helper Methods ------------
    fun isFruit(item: Item) = item is Fruit
    fun isVegetable(item: Item) = item is Vegetable

    // 1
    fun produceItems(): ArrayList<Item> {
        val itemsArray = ArrayList<Item>()
        itemsArray.add(Fruit("Apple", "Red"))
        itemsArray.add(Vegetable("Zucchini", "Green"))
        itemsArray.add(Fruit("Grapes", "Green"))
        itemsArray.add(Vegetable("Radishes", "Red"))
        itemsArray.add(Fruit("Banana", "Yellow"))
        itemsArray.add(Fruit("Cherries", "Red"))
        itemsArray.add(Vegetable("Broccoli", "Green"))
        itemsArray.add(Fruit("Strawberry", "Red"))
        itemsArray.add(Vegetable("Red bell pepper", "Red"))
        return itemsArray
    }
    runBlocking {
// 2
        val destinationChannel = Channel<Item>()
// 3
        val fruitsChannel = Channel<Item>()
        val vegetablesChannel = Channel<Item>()
// 4
        launch {
            produceItems().forEach {
                if (isFruit(it)) {
                    fruitsChannel.send(it)
                }
            }
        }
// 5
        launch {
            produceItems().forEach {
                if (isVegetable(it)) {
                    vegetablesChannel.send(it)
                }
            }
        }
// 6
        launch {
            for (item in fruitsChannel) {
                destinationChannel.send(item)
            }
        }
// 7
        launch {
            for (item in vegetablesChannel) {
                destinationChannel.send(item)
            }
        }
// 8
        destinationChannel.consumeEach {
            if (isFruit(it)) {
                println("${it.name} is a fruit")
            } else if (isVegetable(it)) {
                println("${it.name} is a vegetable")
            }
        }
// 9
        coroutineContext.cancelChildren()
    }
}
