package material.functions.standard

import courses.bootcamp.aquarium.Fish

fun main() {
    fishExamplesWith()
//    fishExamplesMyWith()
}

private fun weNeedObjectReceiverAsAFirstArg() {
    val nameTooLong = with("Polarcubis, Supreme Master of NyetHack") {
        length >= 20
    }
    println(nameTooLong)
}

private fun fishExamplesWith() {
    val fish = Fish("splashy")

    with(fish.name) {
        println("the name was $this")
        println(capitalize())
        println(hashCode())
    }

    println(fish.hashCode())
    println(fish.name)
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

