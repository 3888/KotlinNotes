import java.util.*

fun main() {
    readLineOK()
}

private fun scannerCE() {
    val sc = Scanner(System.`in`)
    val input: Any = sc.nextLine()
    val string = input.toString()

    val splitIndex = string.indexOf(" ")
    val a = string.take(splitIndex).toLong()
    val b = string.substring(splitIndex + 1, string.length).toLong()

    val result = a + b
    println(result)
}

private fun readLineOK() {

    val string = readLine()!!

    val splitIndex = string.indexOf(" ")
    val a = string.take(splitIndex).toLong()
    val b = string.substring(splitIndex + 1, string.length).toLong()

    val result = a + b
    println(result)
}


