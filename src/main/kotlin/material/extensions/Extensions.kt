package material.extensions

fun Any.easyPrint() = println(this)

fun <T> T.easyPrintChain(): T {
    println(this)
    return this
}

fun String?.printWithDefault(default: String) = println(this ?: default)
infix fun String?.printWithDefaultInfix(default: String) = println(this ?: default)

val String.numVowels
    get() = count { "aeiouy".contains(it) }
