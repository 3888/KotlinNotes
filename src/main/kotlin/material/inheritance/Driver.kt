package material.inheritance

class Driver(var lastName: String) : Person("Bob") {
    override fun getPhoneOpen() {
        println("New number")
    }

    override val ageOpenVal: Int
        get() = 35

    override fun toString(): String {
        return "Driver name is ${name + " " + lastName} and age is $ageOpenVal "
    }

    override val nickName: String = "C3PO"


}