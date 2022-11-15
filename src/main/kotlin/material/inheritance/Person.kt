package material.inheritance

open class Person(var name: String, val age: Int = 0) {

    open val ageOpenVal: Int = 31

    protected open val nickName: String = "R2D2"

    fun getPhoneNotOpen() {
        println("+38068 not open")
    }

    open fun getPhoneOpen() {
        println("+38068 open")
    }

    override fun toString(): String {
        return "Person name is $name age is $ageOpenVal"
    }
}