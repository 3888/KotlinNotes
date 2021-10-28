package material.functions.standard

import bootcamp.aquarium.Fish

fun main() {
/*
 Apply returns the object is applied to
 */

//    applySettingToFish()
    applyString()

}

private fun applyString() {
    val string = "value"

    println(string)

    string.apply {
        substring(0,2)
    }

    println(string)


    println("string".apply {
        substring(0,2)
    })
}

private fun applySettingToFish() {
    val fish = Fish("splashy")
        .apply {
            println("name is $name")
            name = "new name"
            println(hashCode())
            println("changed to $name")
        }

//    Apply returns the object after the lambda has been applied
    println(fish.name)
    println(fish.hashCode())
}