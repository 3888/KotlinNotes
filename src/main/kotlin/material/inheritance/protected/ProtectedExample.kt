package material.inheritance.protected

fun main() {
    /*
    https://kotlinlang.ru/docs/reference/visibility-modifiers.html
    * */

    val outer = Outer()
//        outer.b // Cannot access 'b': it is protected in 'Outer
    outer.c
    outer.d


    val subclass = Subclass()
    subclass.c
    subclass.d
//    subclass.b //Cannot access 'b': it is protected in 'Subclass'
}

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // public по умолчанию

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
//     a не видно
    // b, c и d видно
    // класс Nested и e видно


    override val b = 5   // 'b' - protected


}


class Unrelated(o: Outer) {
    // o.a, o.b не видно
    // o.c и o.d видно (тот же модуль)
    // Outer.Nested не видно, и Nested::e также не видно
}