package material.constructor

fun main() {
//    val test = InitBlock()
//    val testMessage = InitBlock("Hello")

//    val initBlockLogic = InitBlockLogic("")


}

private class InitBlock() {
    constructor(message: String) : this() {
        println("constructor $message")
    }

    init {
        println("Init block")
    }
}

private class InitBlockLogic(message: String) {

    init {
        require(message.isNotEmpty()) { println("Message can't be empty") }
    }
}
