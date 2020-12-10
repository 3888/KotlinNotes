package material.intialization

fun main() {
//    val initBlock = InitBlock()
//    val initBlockBeforeConstructor = InitBlock("Hello")

//    val initBlockWithLogic = InitBlockWithLogic("")

//    val initializationBeforeInit = InitializationBeforeInit()
//    val NPEInCaseUseValueBeforeInitialization = NPEInCaseUseValueBeforeInitialization()

//    println(WrongInitializationOrder("Madrigal").playerName)

//   initOrderTask()

}

fun initOrderTask() {
    val sword = Sword("Excalibur")
    println(sword.name) // The Legendary Excalibur

    sword.name = "Gleipnir"
    println(sword.name) // The Legendary Rinpielg
}

private class InitBlock() {
    constructor(message: String) : this() {
        println("constructor $message")
    }

    init {
        println("Init block")
    }
}

private class InitBlockWithLogic(message: String) {

    init {
        require(message.isNotEmpty()) { println("Message can't be empty") }
    }
}

private class InitializationBeforeInit() {
    val health = 100 // Initialization before init block

    init {
        val healthBonus = health.times(3)
        println("Health is $healthBonus")
    }

//    val health = 100 // IDE error Variable 'health' must be initialized
}

private class NPEInCaseUseValueBeforeInitialization() {
    val name: String
    private fun firstLetter() = name[0]

    init {
//        name = "Madrigal" // call firstLetter() is OK bcs name is initialized
        println(firstLetter()) // NPE bcs name is not initialized
        name = "Madrigal"
    }
}

private class WrongInitializationOrder(_name: String) {
    //    val name: String = _name  // in this case all Fine. Calling playerName after name = _name
    val playerName: String = initPlayerName() // calling playerName before name = _name
    val name: String = _name
    private fun initPlayerName() = name
}

private class Sword(_name: String) {
    var name = _name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }

//    init {
//        name = _name // The Legendary Rubilacxe
//    }
}