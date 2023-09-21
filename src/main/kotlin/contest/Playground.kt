package contest


fun main() {



}



fun maxMultiple(d: Int, b: Int): Int = (b / d) * d

// "battle no requires which that is victory greatest The"
fun reverseWords(str: String) = str.split(" ")
    .reversed()
    .toString()
    .substring(0)
    .replace(",", "")
    .replace("[", "")
    .replace("]", "")

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




