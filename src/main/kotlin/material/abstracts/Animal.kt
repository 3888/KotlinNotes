package material.abstracts

abstract class Animal {
    protected var aName: String = ""
    protected var aAge: Int = 0

    fun setName(name: String) {
        this.aName = name
    }

    fun setAge(age: Int) {
        this.aAge = age
    }

    abstract fun makeSound()
}


