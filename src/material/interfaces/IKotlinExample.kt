package material.interfaces

interface IKotlinExample {

    val initializedString: String
        get() = "String"

    val notInitializedString: String

    fun method()

    fun methodWithDefaultRealization() {
        println("Default realization")
    }
}