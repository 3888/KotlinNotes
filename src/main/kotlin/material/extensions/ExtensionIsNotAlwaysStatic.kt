package material.extensions

/*
https://proandroiddev.com/tonnes-of-fun-with-kotlin-d1b9ed6f5907
* */
fun main() {

    println("".extensionIsStaticInJava()) //  private static final String
    Printer().print("") //  private final String

}

private fun String.extensionIsStaticInJava(): String {
    return "$this is static"
}

class Printer {
    fun print(str: String) {
        println(str.extensionIsNotStaticInJava())
    }

    private fun String.extensionIsNotStaticInJava(): String {
        return "$this is not static"
    }
}