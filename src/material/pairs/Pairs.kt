package material.pairs

fun main() {

}

private fun todo() {
    val (a, b) = Pair(1, "x")
    println("a type is ${a::class.simpleName}") // 1
    println("b type is ${b::class.simpleName}") // x

    val equipment = "fishnet" to "catching fish" to "big size" to "and strong"
    println("equipment first ${equipment.first} ")
    println("equipment second ${equipment.second} ")

    val equip = ("fishnet" to "catching fish") to ("big size" to "and strong")
    println("equip first ${equip.first} ")
    println("equip second ${equip.second} ")

    val fishnet = "fishnet" to "catching fish"
    val (tool, use) = fishnet

    println("The $tool is a tool for $use")


    val fishnetString = fishnet.toString()

    println("fishnet.toString() = $fishnetString")

    println("fishnet.toList() = ${fishnet.toList()}")

    fun giveMeATool(): Pair<String, String> {
        return ("fishnet" to "catching")
    }

    val (toolSecond, useSecond) = giveMeATool()

    println(toolSecond)
    println(useSecond)
}