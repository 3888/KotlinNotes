package material.dataclass

fun main() {

//    toString()
//    equals()
//    hashCode()
    copy()
}
/*
http://developer.alexanderklimov.ru/android/kotlin/data.php
*/

private fun toString(){
    val cat = WhiteCat("Murzik", 7)
    println(cat) // Cat(name=Murzik, age=7)
}

private fun equals(){
    val whiteCat = WhiteCat("Murzik", 7)
    val whiteCatClone = WhiteCat("Murzik", 7)
    val whiteCat2 = WhiteCat("Boris", 1)
    val blackCat = BlackCat("Shadow", 5)
    val cat1 = Cat("Cat",1)
    val cat2 = Cat("Cat",1)

    println("whiteCat $whiteCat")
    println("whiteCatClone $whiteCatClone")
    println("whiteCat2 $whiteCat2")
    println("blackCat $blackCat")
    println("cat1 $cat1")
    println("cat2 $cat2")
    println("")

    println("whiteCat equals whiteCatClone  ${whiteCat.equals(whiteCatClone)}") // true
    println("whiteCat == whiteCatClone  ${whiteCat == whiteCatClone}") // true
    println("cat1 equals cat2 ${cat1.equals(cat2)}") // true
    println("cat1 == cat2  ${cat1 == cat2}") // true
    println("")

    println("whiteCat equals whiteCat2  ${whiteCat.equals(whiteCat2)}") // false
    println("whiteCat == whiteCat2 == ${whiteCat == whiteCat2}") // false
    println("")

    println("whiteCat equals blackCat ${whiteCat.equals(blackCat)}") // false
//    println("binary operator == ${whiteCat == blackCat}") // Operator '==' cannot be applied to
}

private fun hashCode(){
    val whiteCat = WhiteCat("Murzik", 7)
    val whiteCatClone = WhiteCat("Murzik", 7)
    val whiteCat2 = WhiteCat("Boris", 1)
    val cat1 = Cat("Cat",1)
    val cat2 = Cat("Cat",1)

    println("whiteCat ${whiteCat.hashCode()}")
    println("whiteCatClone ${whiteCatClone.hashCode()}")
    println("whiteCat2 ${whiteCat2.hashCode()}")
    println("cat1 ${cat1.hashCode()}")
    println("cat2 ${cat2.hashCode()}")
}

private fun copy(){
    val whiteCat = WhiteCat("Murzik", 7)
//    val whiteCatClone = whiteCat.copy("Clone")
//    or
    val whiteCatClone = whiteCat.copy(name = "Clone")

    println(whiteCat)
    println(whiteCatClone)
}

