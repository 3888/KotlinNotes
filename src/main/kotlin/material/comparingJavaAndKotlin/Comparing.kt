package material.comparingJavaAndKotlin

import UserJava

fun main() {
    val userJava = UserJava("mail@mail.ru")
    println("Java example -  ${userJava.email}")

    val userKotlin = UserKotlin("test@mail.com")
    println("Kotlin example ${userKotlin.email} open by ${userKotlin.isOpenBy} ${userKotlin.isOpen}")
    userKotlin.isOpenBy = "Somebody"
    println("Kotlin example ${userKotlin.email} open by ${userKotlin.isOpenBy} ${userKotlin.isOpen}")

}