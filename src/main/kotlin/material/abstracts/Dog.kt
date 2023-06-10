package material.abstracts

class Dog : Animal() {
    override fun makeSound() {
        println("Dog barks")
    }

    fun showInfo() {
        println("Name: $aName, Age: $aAge")
    }
}
