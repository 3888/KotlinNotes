package material.functions.anonymous


fun main() {

//    count()
//    countLambda()

//    whatIsTheDifferenceBetween()

//    valNoArgs() // String
//    funNoArgs() // Unit
//
//    oneArg("Jonny")
//    oneArgAndIt()
//    twoArgs()
//    twoArgsAndImplicitType()

//    functionAsArg()
//    functionArgAsLambda()

//    runSimulation("Jack") { name, number -> "$name $number" }
//    runSimulationInline("JackInline") { name, number -> "$name $number" }

//    linkToFunctionAsArg(
//            "JackInline",
//            ::printConstructionCost
//    ) { name, number -> "$name $number" }

    functionAsReturnType() // High order functions

}


private fun count() = println("Mississippi".count())

private fun countLambda() = println("Mississippi".count { letter ->
    letter == 's'
})
private fun whatIsTheDifferenceBetween() {
    println("random ${Math.random()}")
    println("random ${{ Math.random() }}")
}



private val valNoArgs: () -> String = {
    val currentYear = 2020
    "Welcome to SimVillage, Mayor! (copyright $currentYear)"
}

private fun funNoArgs() = println({
    val currentYear = 2020
    "Welcome to $currentYear"
//  if no "()" here "})" we'll have output:  () -> kotlin.String
}())

private fun oneArg(name: String) {
    val greetingFunction: (String) -> String = { playerName ->
        val currentYear = 2020
        "Welcome to $currentYear, $playerName!"
    }
    println(greetingFunction(name))
}

private fun oneArgAndIt() {
    val greetingFunction: (String) -> String = {
        val currentYear = 2020
        "Welcome to $currentYear, $it!"
    }
    println(greetingFunction("Bobby"))
}

private fun twoArgs() {
    val greetingFunction: (String, Int) -> String = { name, year ->
        "Welcome to $year, $name!"
    }
    println(greetingFunction("Ben", 2020))
}

private fun twoArgsAndImplicitType() {
    val greetingFunction = { name: String, year: Int ->
        "Welcome to $year, $name!"
    }
    println(greetingFunction("Ben", 2020))
}

private fun functionAsArg() {
    val greetingFunction = { playerName: String, number: Int ->
        val currentYear = 2020
        println("Adding $number players")
        "Welcome to $currentYear $playerName!"
    }

    runSimulation("Donald", greetingFunction)
}

/*
(112) 2018  Kotlin. Программирование для профессионалов  Скин Дж., Гринхол Д
 сокращенный синтаксис вызова можно применить к нашей функции runSimulation. runSimulation ожидает
 два аргумента: строку и функцию. Передайте функции runSimulation аргументы, которые не являются функциями,
в круглых скобках. Затем допишите последний аргумент функции вне скобок
*/
private fun functionArgAsLambda() {
    runSimulation("Bingo") { name, number ->
        val currentYear = 2020
        println("Adding $number players")
        "Welcome $currentYear $name!"
    }
}

private fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val number = (1..5).shuffled().last() // Случайно выберет 1, 2 или 5
    println(greetingFunction(playerName, number))
}


private inline fun runSimulationInline(playerName: String, greetingFunction: (String, Int) -> String) {
    val number = (1..5).shuffled().last() // Случайно выберет 1, 2 или 5
    println(greetingFunction(playerName, number))
}

private fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}

private inline fun linkToFunctionAsArg(
        playerName: String,
        costPrinter: (Int) -> Unit,
        greetingFunction: (String, Int) -> String
) {
    val number = (1..5).shuffled().last() // Случайно выберет 1, 2 или 5
    costPrinter(number)
    println(greetingFunction(playerName, number))
}

private fun functionAsReturnType(){
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Luke"))
    println(greetingFunction("Obi-Wan"))
}

private fun configureGreetingFunction(): (String) -> String {
    val structureType = "Stars"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2020
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}