package material.extensions

fun main() {
    extensionsExample()
    staticExample()
    propertyExample()
    nullableExample()
}

fun String.hasSpacesBoilerplate(): Boolean {
    val found: Char? = this.find { it == ' ' }
    return found != null
}

fun String.hasSpacesRefactored() = find { it == ' ' } != null

fun extensionsExample() {
    println("Does it have spaces?".hasSpacesBoilerplate())
    println("Does it have spaces?".hasSpacesRefactored())
}

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("Green", size)

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun propertyExample() {
    val plant = AquariumPlant("Green", 50)
    println(plant.isGreen) // true
}

fun AquariumPlant.isRed() = color == "Red"

//fun AquariumPlant. isBig() = size > 50 // Error "Cannot access 'size': it is private in 'AquariumPlant'

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print()  // GreenLeafyPlant
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // AquariumPlant
}

fun AquariumPlant?.pull() {
    this?.apply {
        ("removing $this")
    }
}

fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull() // ok
}
