package material.generics.ConvarianceAndContravariance


//https://www.youtube.com/watch?v=znl2KXk-Qyk

abstract class Box<T> {
    abstract fun addIn(something: T)
    abstract fun getOut(): T
}

abstract class BoxIn<in T> {
    abstract fun addIn(something: T)
//    abstract fun getOut(): T //T error
}

abstract class BoxOut<out T> {
    //    abstract fun addIn(something: T) //error
    abstract fun getOut(): T
}

open class LegoKit
open class TechnoLegoKit : LegoKit()
open class RoboticTechnoLegoKit : TechnoLegoKit()

class BoxWithInstructions<T>(var box: T) : Box<T>() {
    override fun addIn(something: T) {}

    override fun getOut(): T {
        return box
    }
}

fun main() {
    var boxOfLegoKit: Box<LegoKit>
    lateinit var boxOfTechnoLegoKit: Box<TechnoLegoKit>
//   boxOfLegoKit = boxOfTechnoLegoKit // error

    val boxOfLegoKit1: BoxOut<LegoKit>
    lateinit var boxOfTechnoLegoKit1: BoxOut<TechnoLegoKit>
    boxOfLegoKit1 = boxOfTechnoLegoKit1

    lateinit var boxOfLegoKit2: BoxIn<LegoKit>
    lateinit var boxOfTechnoLegoKit2: BoxIn<TechnoLegoKit>
    boxOfTechnoLegoKit2 = boxOfLegoKit2

}