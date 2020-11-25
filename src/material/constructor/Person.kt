package material.constructor
//
//class Person {
//    var children: MutableList<Person> = mutableListOf<Person>();
//    constructor(parent: Person) {
//        parent.children.add(this)
//    }
//}

class Person(val name: String) {
    var children: MutableList<Person> = mutableListOf<Person>()

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}