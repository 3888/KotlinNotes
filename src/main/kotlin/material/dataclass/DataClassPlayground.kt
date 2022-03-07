package material.dataclass
/*
http://developer.alexanderklimov.ru/android/kotlin/data.php
*/

fun main() {

//    toString()
//    equals()

//    hashCode()
//    hashCodeStandardClass()
//    hashCodeOverridedClass()
//    hashCodeDataClass()

//    copy()
}



private fun toString() {
    val cat = WhiteCat("Murzik", 7)
    println(cat) // Cat(name=Murzik, age=7)
}

private fun equals() {
    val whiteCat = WhiteCat("Murzik", 7)
    val whiteCatClone = WhiteCat("Murzik", 7)
    val whiteCat2 = WhiteCat("Boris", 1)
    val blackCat = BlackCat("Shadow", 5)
    val cat1 = Cat("Cat", 1)
    val cat2 = Cat("Cat", 1)

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

private fun hashCode() {
    val whiteCat = WhiteCat("Murzik", 7)
    val whiteCatClone = WhiteCat("Murzik", 7)
    val whiteCat2 = WhiteCat("Boris", 1)
    val cat1 = Cat("Cat", 1)
    val cat2 = Cat("Cat", 1)

    println("whiteCat ${whiteCat.hashCode()}")
    println("whiteCatClone ${whiteCatClone.hashCode()}")
    println("whiteCat2 ${whiteCat2.hashCode()}")
    println("cat1 ${cat1.hashCode()}")
    println("cat2 ${cat2.hashCode()}")
}

fun hashCodeStandardClass() {
    val person = Person("Adam", 25)
    println("person hashCode is ${person.hashCode()}")
    val hashSet = hashSetOf(person.also { println("put person in hashSet with hashCode  ${it.hashCode()}") })
    println(hashSet.contains(person.also { println("Is hashSet contains person with hashCode ${it.hashCode()}?") })) // true

    val hashSet1 = hashSetOf(Person("Adam", 25).also {
        println("Put anonymous person in hashSet1 with hashCode ${it.hashCode()}")
    })
    println(hashSet1.contains(Person("Adam", 25).also {
        println("Is hashSet1 contains anonymous person with hashCode ${it.hashCode()}")
    })) // false bcs it's anonymous
}

fun hashCodeOverridedClass() {
    val personOverrided = PersonOverrided("Adam", 25)
    println("personOverrided hashCode is  ${personOverrided.hashCode()}")

    val hashSet2 = hashSetOf(personOverrided
        .also { println("Put personOverrided to hashSet2 with hashCode ${it.hashCode()}") })

    println(hashSet2.contains(personOverrided)
        .also { println("Is hashSet2 contains personOverrided with hashCode  ${it.hashCode()}") }) // true

    val hashSet3 = hashSetOf(PersonOverrided("Adam", 25)
        .also { println("hashSet3 anonymous personOverrided with hashCode  ${it.hashCode()}") })

    println(
        hashSet3.contains(PersonOverrided("Adam", 25)
            .also { println("Is hashSet3 contains anonymous personOverrided  with hashCode ${it.hashCode()}") })
    ) // true
}

fun hashCodeDataClass() {
    val personDataClass = PersonDataClass("Adam", 27)
    println("personDataClass ${personDataClass.hashCode()}")
    val hashSet4 = hashSetOf(personDataClass
        .also { println("hashSet4 personDataClass ${it.hashCode()}") })
    println(hashSet4.contains(personDataClass)) // true
    val hashSet5 = hashSetOf(PersonDataClass("Adam", 27).also {
        println("hashSet4 personDataClass ${it.hashCode()}")
    })
    println(hashSet5.contains(PersonDataClass("Adam", 27).also {
        println("hashSet4 contains personDataClass ${it.hashCode()}")
    })) // true
}

private fun copy() {
    val whiteCat = WhiteCat("Murzik", 7)
//    val whiteCatClone = whiteCat.copy("Clone")
//    or
    val whiteCatClone = whiteCat.copy(name = "Clone")

    println(whiteCat)
    println(whiteCatClone)
}

private data class PersonDataClass(val name: String, val age: Int)

private class Person(val name: String, val age: Int)

private class PersonOverrided(val name: String, val age: Int) {
    override fun toString() = "Person(name = $name , age = $age )"

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is PersonOverrided)
            return false
        return name == other.name && age == other.age
    }

    override fun hashCode(): Int = name.hashCode() * 31 + age
}





