package kotlin_bootcamp.aquarium

import kotlin_bootcamp.aquarium.spices.SimpleSpice
import kotlin.math.PI

open class Aquarium(var lengthBasic: Int = 100, var widthBasic: Int = 20, var heightBasic: Int = 40) {
//    class Aquarium() {

//    val lengthBasic: Int = 100
//    val widthBasic: Int = 20
//    val heightBasic: Int = 40


    var lengthUpdated: Int = lengthBasic
    var widthUpdated: Int = widthBasic
    var heightUpdated: Int = heightBasic

    open var volumeBasic: Int
        get() = widthBasic * heightBasic * lengthBasic / 1000
        set(value) {
            heightUpdated = value * 1000 / (widthUpdated * lengthUpdated)
        }

    open var water = volumeBasic * 0.9
    var numberOfFish: Int = 0

    constructor (numberOfFish: Int) : this() {
        val water = numberOfFish * 2000 //cm3
        val tank: Double = water + water * 0.1
        heightBasic = (tank / (lengthBasic * widthBasic)).toInt()
        this.numberOfFish = numberOfFish
    }


    fun volumeBasic(): Int {
        return widthBasic * heightBasic * lengthBasic / 1000
    }

    fun volumeUpdated(): Int = widthUpdated * heightUpdated * lengthUpdated / 1000

    fun showSpice() {
        val simpleSpice = SimpleSpice()
        println("${simpleSpice.name} ${simpleSpice.heat}")
    }
}

class TowerTank() : Aquarium() {
    override var water = volumeBasic * 0.8

    override var volumeBasic: Int
        get() = (widthBasic * heightBasic * lengthBasic / 1000 * PI).toInt()
        set(value) {
            heightUpdated = value * 1000 / (widthUpdated * lengthUpdated)
        }
}