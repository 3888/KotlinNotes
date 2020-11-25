package material.lambdas

import kotlin_bootcamp.aquarium.Fish

fun main() {
    val fish = Fish("splashy")

//   Let returns a copy of the changed object
    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 10 })

    println(fish)
}