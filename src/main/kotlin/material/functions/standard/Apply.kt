package material.functions.standard

import courses.bootcamp.aquarium.Fish

fun main() {
/*
 Apply returns the object is applied to
 */

//    applySettingToFish()
    applyString()

}

private fun applyString() {
    val string = "value"

    string.apply {
        substring(0,2)
    }

    println(string) // not work bcs Sting is immutable

    val result = StringBuilder(string).apply {
        this.replace(0, 5, "Hi")
    }.toString()

    println(result) // Hi
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