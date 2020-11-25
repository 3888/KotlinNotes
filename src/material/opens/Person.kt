package material.opens

open class Person(var name: String){

    open val age : Int = 31

    fun getPhoneNotOpen(){
        println("+38068 not open")
    }

    open fun getPhoneOpen(){
        println("+38068 open")
    }

    override fun toString(): String {
        return "Person name is $name age is $age"
    }
}