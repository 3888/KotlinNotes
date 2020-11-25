package material.interfaces

class B : IKotlinExample {
    override fun method() {
        println("B")
    }


    override val notInitializedString: String
        get() = "notInitializedString B"
}