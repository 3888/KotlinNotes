package material.lambdas

import kotlin_bootcamp.aquarium.Fish

fun main() {

    val fish = Fish("splashy")

    fish.apply {
        println("name $name it length ${name.length}")
    }

//    Apply returns the object is applied to
    println(fish.apply { })

//    Apply returns the object after the lambda has been applied
    val fish2 = Fish(name = "splashy").apply { name = "NewName" }
    println(fish2.name)
}