package material.bitwise

fun main() {
    /*
    https://www.programiz.com/kotlin-programming/bitwise
    */

    val number1 = 12 //    12 = 00001100 (In Binary)
    val number2 = 25 //    25 = 00011001 (In Binary)
    val result: Int

    result = number1 or number2   // result = number1.or(number2)

//    Bitwise OR Operation of 12 and 25
//    00001100 or
//    00011001
//    ________
    println(result) //    00011101  = 29 (In decimal)

}