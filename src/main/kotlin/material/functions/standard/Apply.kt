package material.functions.standard

import kotlin_bootcamp.aquarium.Fish

fun main() {
/*
 Apply returns the object is applied to
 */

    applySettingToFish()

}

private fun applySettingToFish() {
    val fish = Fish("splashy")
        .apply {
            name = "new name"
            println(hashCode())
        }

//    Apply returns the object after the lambda has been applied
    println(fish.name)
    println(fish.hashCode())
}