package bignerdranch.simvillage

import java.io.File
import kotlin.random.Random

const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatronsMutableSet = mutableSetOf<String>()
val uniquePatronsSet = getPatronListAsSequence()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")


val getPatronGold = mapOf(Pair("Eli", 10.75), Pair("Mordoc", 8.00), Pair("Sophie", 5.50))
val patronGold = mutableMapOf<String, Double>()

fun main() {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards. ")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    fillPatronList()

    uniquePatronsMutableSet.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(
            uniquePatronsMutableSet.shuffled().first(),
            menuList.shuffled().first()
        )
        orderCount++
    }

    displayPatronBalances()
}

private fun fillPatronList() {
    (0..9).forEach {
        val first = patronList.random()
        val last = Character.toChars(Random.nextInt(1, 10))
        val name = "$first $last"
        uniquePatronsMutableSet += name
    }
}

private fun getPatronListAsSequence() = generateSequence {
    val first = patronList.random()
    val last = lastName.random()
    "$first $last"
}.take(10).toSet()

private fun displayPatronBalances() {
    patronGold.forEach { (patron, balance) ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)
    performPurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name"
    }
    println(phrase)
}

private fun <T> Iterable<T>.random(): T = this.shuffled().first()