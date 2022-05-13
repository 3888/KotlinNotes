package material.generics

fun main() {
    contravariance(GrandParent())
    contravariance(Parent())
    contravariance(Child())
}


open class GrandParent
open class Parent : GrandParent()
class Child : Parent()

private fun contravariance(grantParentType: GrandParent): GrandParent = grantParentType

