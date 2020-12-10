package material.intialization


fun main() {
    val human = Human()

    try {
        human.error()
    } catch (e: Exception) {
        println(e.message)
    }

    human.sayHello()

    human.setName()
    human.sayHello()
}

private class Human {
    private lateinit var name: String
    fun setName() {
        name = "Vasya"
    }

    fun sayHello() {
        if (::name.isInitialized) println("Hello $name") else println("Please set name")
    }

    fun error() {
        println("Hello $name")
    }
}