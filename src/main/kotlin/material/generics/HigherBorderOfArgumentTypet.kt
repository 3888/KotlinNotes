package material.generics

private fun higherBorderOfArgumentType() {
    fun checkGrandFatherType(T: GrandFather) = Unit
    fun checkFatherType(T: Father) = Unit

    checkGrandFatherType(Son())
    checkGrandFatherType(Father())
    checkGrandFatherType(GrandFather())

    checkFatherType(Son())
    checkFatherType(Father())
//    checkFatherType(GrandFather()) // Type mismatch
}

private open class GrandFather
private open class Father : GrandFather()
private open class Son : Father()

