package material.generics

fun main() {
    val animal = Animal()
    animal.feed()

    val cow = Cow()
    cow.feed()

}

private open class Animal {
    fun feed() = println("Feed ${javaClass.simpleName}")
}

private class Cow : Animal()

//private class Herd< T : Animal> {
private class Herd<out T : Animal> {
    val size: Int get() = 3
    operator fun get(i: Int): T {
        return i as T // we use T as a type of return value
    }
}

private class Cat : Animal() {
    fun cleanLitter() = Unit
}

private fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

private fun takeCareOfAnimals(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        feedAll(animals)
    }
}

private fun takeCareOfCows(cows: Herd<Cow>) {
    for (i in 0 until cows.size) {
//        feedAll(cows as Herd<Animal>)
        feedAll(cows)
    }
}

private fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
        feedAll(cats)
    }
}