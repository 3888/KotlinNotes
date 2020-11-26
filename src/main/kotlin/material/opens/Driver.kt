package material.opens

class Driver(var lastName: String) : Person("Bob") {
    override fun getPhoneOpen() {
        println("New number")
    }

    override val age: Int
        get() = 35

    override fun toString(): String {
        return "Driver name is ${name + " " + lastName} and age is $age "
    }
}