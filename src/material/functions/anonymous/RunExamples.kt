package material.lambdas

import kotlin_bootcamp.aquarium.Fish

fun main() {
    val fish = Fish("splashy")
    fish.run {
        println(name)
    }

//    Run returns the result of executing the lambda
    println(fish.run {  })
}