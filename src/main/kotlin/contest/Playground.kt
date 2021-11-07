package contest


fun main() {
//    asterisksSeparatedBySpaces(3)
//    triangle(7)
}



private fun asterisksSeparatedBySpaces(heightCount: Int) {
    for (i in 1..heightCount) {
        for (j in 1..i) {
            print("*")
        }
        println(" ")
    }
}

private fun triangle(heightCount: Int) {
    for (i in 1..heightCount) {
        var value = 0
        for (j in 1..heightCount - i) {
            print(" ")
//            print(j)
            value = j
        }

        when (i) {
            1 -> println("*")
            2 -> println("*".repeat(i + 1))
            else -> println("*".repeat(i + heightCount - value))
        }
    }

}




