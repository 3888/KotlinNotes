package material.pairs

fun main() {
//    destructurization()
//    pairExample("fishnet" to "catching fish" to "small fish", "big shark")

    unzip()

}

private fun destructurization() {
    val (a, b) = Pair(1, "string")
    println("a type is ${a::class.simpleName}")
    println("b type is ${b::class.simpleName}")

    val fishnet = "fishnet" to "catching fish"
    val (tool, use) = fishnet
    println("The $tool is a tool for $use")

    fun giveMeATool(): Pair<String, String> {
        return ("fishnet" to "catching")
    }

    val (toolSecond, useSecond) = giveMeATool()
    println(toolSecond)
    println(useSecond)
}

private fun pairExample(pairWithPair: Pair<Pair<String, String>, String>, string: String) {
    val pair = "Hey" to "Bro"
    val pairTostring = pair.toString()
    println("fishnet.toString() = $pairTostring")
    println("fishnet.toList() = ${pair.toList()}")


    val hugePair = pairWithPair to pairTostring
    println(hugePair)
    println("hugePair first = ${hugePair.first} ")
    println("hugePair first.first = ${hugePair.first.first} ")
    println("hugePair first.second = ${hugePair.first.second} ")
    println("hugePair second  = ${hugePair.second} ")


    val pairOfPairs = ("fishnet" to "catching fish") to ("big size" to "and strong")
    println("pairOfPairs first ${pairOfPairs.first} ")
    println("pairOfPairs first.first ${pairOfPairs.first.first} ")
    println("pairOfPairs first.second ${pairOfPairs.first.second} ")
    println("pairOfPairs second ${pairOfPairs.second} ")
    println("pairOfPairs second.first ${pairOfPairs.second.first} ")
    println("pairOfPairs second.second ${pairOfPairs.second.second} ")

}

private fun unzip() {
    val example: Array<Pair<Int, Int>> = arrayOf(10 to 0, 3 to 5, 5 to 8)
    println(example.unzip())
}