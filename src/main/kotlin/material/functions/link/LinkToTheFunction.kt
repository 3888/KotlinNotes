package material.functions.link

import material.functions.link.somepackage.OtherPackageClass
import material.functions.link.somepackage.doubleFromOtherPackage


fun main() {
    val exampleLambda: (Int) -> Int = { n -> double(n) }
    val exampleLambdaIt: (Int) -> Int = { double(it) }

    val exampleLink: (Int) -> Int = ::double

    val someClass = MyClass()
    val exampleLinkFromClass: (Int) -> Int = someClass::double
    val exampleLinkFromClass2: (Int) -> Int = MyClass()::double

    val exampleLinkFromOtherPackage: (Int) -> Int = OtherPackageClass()::doubleFromOtherPackageClass
    val exampleLinkFromOtherPackage2: (Int) -> Int = ::doubleFromOtherPackage

    val exampleFromCompanion: (Int) -> Int = (MyClass)::doubleInCompanion // deprecated
    val exampleFromCompanion2: (Int) -> Int = MyClass.Companion::doubleInCompanion
    val exampleFromCompanion3: (Int) -> Int = OtherPackageClass.Companion::doubleInCompanionFromOtherPackageClass

}

private fun double(n: Int): Int = n * 2

private class MyClass {
    fun double(n: Int): Int = n * 2

    companion object {
        fun doubleInCompanion(n: Int): Int = n * 2
    }
}

