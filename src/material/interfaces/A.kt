package material.interfaces

class A : IKotlinExample {
    override fun method() {
        println("A")
    }

    override val notInitializedString: String
        get() = "notInitializedString A"
}