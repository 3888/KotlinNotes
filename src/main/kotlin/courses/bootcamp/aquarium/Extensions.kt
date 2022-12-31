package courses.bootcamp.aquarium

fun main() {
    extensionsExample()
    staticExample()
    propertyExample()
    nullableExample()
}

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

private fun String.hasSpacesBoilerplate(): Boolean {
    val found: Char? = this.find { it == ' ' }
    return found != null
}

private fun String.hasSpacesRefactored() = find { it == ' ' } != null

private fun extensionsExample() {
    println("Does it have spaces?".hasSpacesBoilerplate())
    println("Does it have spaces?".hasSpacesRefactored())
}

private fun propertyExample() {
    val plant = AquariumPlant("Green", 50)
    println(plant.isGreen) // true
}

private fun AquariumPlant.isRed() = color == "Red"

//fun AquariumPlant. isBig() = size > 50 // Error "Cannot access 'size': it is private in 'AquariumPlant'

private fun AquariumPlant.print() = println("AquariumPlant")
private fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

private fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print()  // GreenLeafyPlant
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // AquariumPlant
}

private fun AquariumPlant?.pull() {
    this?.apply {
        ("removing $this")
    }
}

private fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull() // ok
}

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("Green", size)