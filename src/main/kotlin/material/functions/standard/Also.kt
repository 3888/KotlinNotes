package material.functions.standard

import bootcamp.aquarium.Fish

fun main() {
    alsoExample()
}

private fun alsoExample() {
    val fish = Fish("Flumber")
    println(fish.hashCode())

    fish.also {
        it.name = "new"
        println("${it.name} ${it.hashCode()}")
    }
        .also {
            it.name = "new2"
            println("${it.name} ${it.hashCode()}")
        }

    println(fish.hashCode())
}