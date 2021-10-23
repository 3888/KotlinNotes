package bootcamp.aquarium.spices

import material.constants.adt.enum.EnumColors


abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
    abstract fun prepareSpice()
}

fun main(args: Array<String>) {
    delegate()

    val spiceCabinet = listOf(
        SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "medium")),
        SpiceContainer(Curry("Green Curry", "spicy"))
    )

    for (element in spiceCabinet) println(element.label)

}

class Curry(
    name: String, spiciness: String,
    color: SpiceColor = YellowSpiceColor
) : Spice(name, spiciness, color), Grinder {
    override fun grind() {
    }

    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val colorString: String
    val colorEnum: EnumColors

}

object YellowSpiceColor : SpiceColor {
    override val colorString = "Yellow"
    override val colorEnum = EnumColors.ORANGE

}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has has color ${pleco.color}")
    pleco.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Plecostomus(fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("eat a lot of algae"),
    FishColor by fishColor

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
}