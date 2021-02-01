package material.collections.associative_arrays.map

fun main() {
    map()
//    mutableMapOf()

//    initMutableMapOfForEach()
//    initMutableMapOfPutAll()
}

private fun map() {
    val mapExample = mapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(mapExample.get("white spots"))
    println(mapExample["white spots"])
    println(mapExample.getOrDefault("Bla-bla", "sorry I don't know it"))
    mapExample.getOrElse("Bla-bla") { println("There is no spoon ${3 + 4}") }
    println(mapExample.keys)
    println(mapExample.values)
}

private fun mutableMapOf() {
    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory["tank scrubber"] = 3
    inventory.remove("fish net")

    val moreBooks = mutableMapOf("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)
}

private fun initMutableMapOfForEach() {
    val uniquePatrons = mutableSetOf("Eli", "Mordoc", "Sophie")
    val patronGold = mutableMapOf<String, Double>()

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    println(uniquePatrons)
    println(patronGold)
}


private fun initMutableMapOfPutAll() {
    val patronGold = mutableMapOf("Mordoc" to 6.0)
    patronGold.putAll(
        listOf(
            "Jebediah" to 5.0,
            "Sahara" to 6.0
        )
    )

    println(patronGold)
}



