package channel.demultiplexer

import channel.Item
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
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
        val kotlinChannel = Channel<Item>()
// 3
        val fruitsChannel = Channel<Item>()
        val vegetablesChannel = Channel<Item>()
// 4
        launch {
            produceItems().forEach {
                kotlinChannel.send(it)
            }
// 5
            kotlinChannel.close()
        }

        // 6
        val typeDemultiplexer = Demultiplexer(fruitsChannel to { item: Item -> isFruit(item) },
            vegetablesChannel to { item: Item -> isVegetable(item) }
        )
// 7
        launch {
            typeDemultiplexer.consume(kotlinChannel)
        }
// 8
        launch {
            for (item in fruitsChannel) {
// Consume fruitsChannel
                println("${item.name} is a fruit")
            }
        }
// 9
        launch {
            for (item in vegetablesChannel) {
// Consume vegetablesChannel
                println("${item.name} is a vegetable")
            }
        }
    }
}