package material.functions.standard

import courses.bootcamp.aquarium.Fish

fun main() {
//    alsoExample()
    alsoString()
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

private fun alsoString() {
    val string = "value"

    string.also {
        it.substring(0,2)
    }

    println(string) // not work bcs Sting is immutable

    val result = StringBuilder(string).also {
        it.replace(0, 5, "Hi")
    }.toString()

    println(result) // Hi
}