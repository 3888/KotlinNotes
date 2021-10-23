package material.functions.link.somepackage

class OtherPackageClass {
    fun doubleFromOtherPackageClass(n: Int): Int = n * 2

    companion object {
        fun doubleInCompanionFromOtherPackageClass(n: Int): Int = n * 2
    }
}

fun doubleFromOtherPackage(n: Int): Int = n * 2