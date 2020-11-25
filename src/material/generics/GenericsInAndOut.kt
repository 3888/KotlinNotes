package material.generics

//https://kotlinlang.ru/docs/reference/generics.html
//https://www.youtube.com/watch?v=znl2KXk-Qyk

abstract class Box<T> {
    abstract fun addIn(something: T)
    abstract fun getOut(): T
}

abstract class BoxIn<in T> {
    abstract fun addIn(something: T)
//    abstract fun getOut(): //T error
}

abstract class BoxOut<out T> {
    //    abstract fun addIn(something: T) //error
    abstract fun getOut(): T
}

open class LegoKit
open class TechnoLegoKit : LegoKit()
open class RoboticTechnoLegoKit : TechnoLegoKit()

class BoxWithInstructions<T>(var ob: T) : Box<T>() {
    override fun addIn(something: T) {}

    override fun getOut(): T {
        return ob
    }
}

fun main() {
    var a: Box<LegoKit>
    lateinit var b: Box<TechnoLegoKit>
//    a = b // error

    val a1: BoxOut<LegoKit>
    lateinit var b1: BoxOut<TechnoLegoKit>
    a1 = b1

    lateinit var a2: BoxIn<LegoKit>
    lateinit var b2: BoxIn<TechnoLegoKit>
    b2 = a2

}