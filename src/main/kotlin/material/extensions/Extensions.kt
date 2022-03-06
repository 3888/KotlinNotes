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



open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")

    fun methodIsFirst() =  println("methodIsFirst in Button")
}

fun View.showOff() = println("I'm View")
fun Button.showOff() = println("I'm Button")
fun Button.methodIsFirst() = println("methodIsFirst in Extension")