package material.extensions

fun main() {
//    extension()
//    extensionAsProperty()
//    nullableExtension()
//    infixExtension()
    extensionIsNotOverride()

}

private fun extension() {
    "Hello".easyPrint()
}

private fun chainOfExtensions() {
    //    "hello".easyPrint().toUpperCase() // Error
    "hello".easyPrintChain().toUpperCase() // OK
}

private fun extensionAsProperty() {
    "How many vowels?".numVowels.easyPrint()
}

private fun nullableExtension() {
    val nullableString: String? = null
    nullableString.printWithDefault("Default string")
    nullableString?.easyPrint()
}

private fun infixExtension() {
    null printWithDefaultInfix "Default string" // C infix
    null.printWithDefault("Default string") // Без infix
}

private fun extensionIsNotOverride() {
    val view: View = Button()
    view.click() // Button clicked
    view.showOff() // I'm View

    val button = Button()
    button.methodIsFirst() // in case name shadowing class is always first
}