package material.loops

fun main() {
    val fish = 12
    val plants = 5
    val swarm = listOf(fish, plants)
    val fishes = arrayOf("dolphin", "orka", "whale")

    contentToString(arrayOf(swarm, fishes))
    allElements(swarm)
    withIndex(fishes)
    valueInRange(1..5, 3)
    charInCharRange('a'..'z', 'l')

}

private fun contentToString(bigSwarm: Array<Any>) {
    println(bigSwarm.contentToString())
}

private fun allElements(swarm: List<Any>) {
    for (element in swarm) println("element = $element ")
}

private fun withIndex(fishes: Array<String>) {
    for ((index, element) in fishes.withIndex()) {
        println("The fish value at index $index = $element")
    }
}

private fun valueInRange(range: IntRange, value: Int) {
    println("Is $value in $range  ${value in range}")
    if (value in range) println("$value is in $range")
}

private fun charInCharRange(alphabet: CharRange, char: Char) {
    println("The char $char is in $alphabet ${char in alphabet} ")
}

private fun printCharRangeAndRange() {
    val charRange = 'a'..'f'
    val numRange = 0..5

    for (i in charRange) print(" $i")
    println("")
    for (i in numRange) print(" $i")
    println("")
    println("${charRange.toList()}")
    println("")
}


private fun booleanLoginInRange(){
    println("${1 in 1..3}")
    println("${1 in 3 downTo 1}")
    println("${1 in 1 until 3}")
    println("${3 in 1 until 3}")
    println("${2 in 1..3}")
    println("${2 !in 1..3}")
    println("${'x' in 'a'..'z'}")
}



