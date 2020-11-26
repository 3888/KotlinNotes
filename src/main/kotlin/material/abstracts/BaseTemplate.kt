package material.abstracts

abstract class BaseTemplate {

    var count = 0
    fun showMessagePlus() {
        count++
        println("Message $count")
    }

    abstract fun showMessageMinus()

}