package material.loops

fun main() {
    whileExample(5)
    doExample(5)

}

private fun whileExample(endValue: Int) {
    var startValue: Int = 0

    while (startValue < endValue) {
        println("i  = $startValue")
        startValue++
    }
}

private fun doExample(endValue: Int) {
    var number = 0
    do {
        print("$number ")
        number++
    } while (number < endValue)
}

