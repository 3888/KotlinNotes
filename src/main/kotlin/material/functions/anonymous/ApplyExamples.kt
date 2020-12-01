package material.lambdas

import kotlin_bootcamp.aquarium.Fish

fun main() {
//    Apply returns the object is applied to

    applySettingToFish()

}

private fun applySettingToFish() {
    val fish = Fish("splashy")
        .apply {
            name = "new name"
        }

//    Apply returns the object after the lambda has been applied
    println(fish.name)
}