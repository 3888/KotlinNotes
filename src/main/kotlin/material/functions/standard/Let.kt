package material.functions.standard

import courses.bootcamp.aquarium.Fish

fun main() {
/*
  Let returns a copy of the changed object
  */

//    letExample()
//    firstItemSquared()

    println(letAndElvisFormatGreeting(null))
    println(letAndElvisFormatGreeting("Bob"))

}


private fun letExample() {
    val fish = Fish("splashy")
    println(fish.hashCode())

    val newFish = fish
        .let {
            println(it.hashCode())
            it.name.capitalize()
        }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 10 }


    println(newFish)
}

private fun firstItemSquared() {
    val firstItemSquared = listOf(2, 4, 6)
        .first()
        .let {
            it * it
        }

    println(firstItemSquared)
}

private fun letAndElvisFormatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "Welcome, $it. Please, go straight back - your table is ready."
    } ?: "Welcome to the tavern. You'll be seated soon."
}