package material.functions.standard

import kotlin_bootcamp.aquarium.Fish

fun main() {
    alsoExample()
}

private fun alsoExample() {
    val fish = Fish("Flumber")
        .also {
            it.name = "new"
            println(it.hashCode())
        }
        .also {
            it.name = "new2"
            println(it.hashCode())
        }

    println(fish.hashCode())
}