package material.functions.standard

import kotlin_bootcamp.aquarium.Fish

fun main() {
    fishExamplesWith()
    fishExamplesMyWith()
}

private fun fishExamplesWith() {
    val fish = Fish("splashy")
    println(fish.hashCode())
    with(fish.name) {
        println(capitalize())
        println(hashCode())
    }
}

private fun fishExamplesMyWith() {
    val fish = Fish("splashy")
    myWithExample(fish.name) {
        println(capitalize())
    }
}


private fun fishExamplesMyWithLonghand() {
    val fish = Fish("splashy")
    myWithExample(fish.name, object : Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })
}

private fun myWithExample(
    name: String,
    block: String.() -> Unit
) {
    name.block()
}
