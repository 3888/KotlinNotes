package material.abstracts

fun main(args: Array<String>) {

    example()
    exampleWithState()
}

private fun example(){
    val v1 = ATemplate()

    v1.showMessagePlus()
    v1.showMessagePlus()
    v1.showMessagePlus()
    v1.showMessageMinus()
}

private fun exampleWithState(){
    val dog = Dog()
    dog.setName("Buddy")
    dog.setAge(3)
    dog.showInfo() // Вывод: Name: Buddy, Age: 3
    dog.makeSound() // Вывод: Dog barks
}
