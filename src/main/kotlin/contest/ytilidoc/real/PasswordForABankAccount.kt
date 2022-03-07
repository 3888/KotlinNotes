package contest.ytilidoc.real

import material.primitives.isEven
import material.strings.checkByRegex

fun main() {
    println(solutionWorkBook())
}

private fun solutionWorkBook(
    input: String =
//                                 "test 5 a0A pass007 ?xy1"
//"a" // one character words
//        "" // empty
//"test" // tests that contains one word only
"abcde1 abcdf2 abcdg3" // all words have odd number of digits
): Int {
    val strArray = input.split(" ").toTypedArray()
    val passwords = HashSet<String>()

    val regex = "[A-Za-z0-9]+"
    for (password in strArray) {
        //        println(password)

        val digitCount = password.filter {
            it.isDigit()
        }.count()
        //        println(digitCount)


//        kotlinRegex(password, regex)
        if (checkByRegex(password, regex) &&
            !isEven(digitCount)
        ) passwords.add(password)
    }

    var maxLength = 0
//    println(passwords)
    passwords.forEach {
        if (it.length > maxLength) maxLength = it.length
    }

    return maxLength
}

