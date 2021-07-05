package material.functions


fun main(args: Array<String>) {

    val someExpression = println("Text of some expression")
    println(someExpression)

    val temperature = 10
//    val isHot = if (temperature > 50) true else false
    val isHot = temperature > 50
    println(isHot)

//    println(returnExample())
//    println(returnExampleWithParameter("Test"))
//    voidExample()
//    println(voidExampleWithLogic("Bob ", "Marley ", 31))

    namedArgumentsAllowsAnyArgumentOrder(name = "", number = 3)
    defaultArguments(3)
    defaultArgumentsAllowsAnyArgumentOrder(name = "", number = 3)

}


private fun returnExample(): String {
    return "Ho-ho-ho"
}

private fun returnExampleWithParameter(stringValue: String): String {
    return stringValue
}

private fun voidExample() {
    println("void Example")
}

private fun voidExampleWithLogic(name: String, lastName: String, age: Int) = name.plus(lastName).plus(age)

private fun namedArgumentsAllowsAnyArgumentOrder(
        number: Int,
        name: String) {
}

private fun defaultArguments(
        number: Int = 3,
        name: String = "No name") {
}

private fun defaultArgumentsAllowsAnyArgumentOrder(
        number: Int = 3,
        name: String = "No name") {
}



