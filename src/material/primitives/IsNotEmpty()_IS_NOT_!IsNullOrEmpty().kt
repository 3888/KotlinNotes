package material.primitives

//https://medium.com/mobile-app-development-publication/kotlin-isnotempty-is-not-isnullorempty-3760db54939a
fun main() {
    val someString = "someString"
    println(isNotEmpty(someString)) // true
    println(!isNullOrEmpty(someString)) // true

    val emptyString: String? = ""
    println(emptyString?.let { isNotEmpty(it) }) // false
    println(isNullOrEmpty(emptyString)) // true

}

private fun isNullOrEmpty(string: String?): Boolean {
    return string.isNullOrEmpty()
}

private fun isNotEmpty(string: String): Boolean {
    return string.isNotEmpty()
}