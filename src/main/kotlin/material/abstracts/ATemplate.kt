package material.abstracts

class ATemplate : BaseTemplate() {

    override fun showMessageMinus() {
        count--
        println("Count $count")
    }
}


