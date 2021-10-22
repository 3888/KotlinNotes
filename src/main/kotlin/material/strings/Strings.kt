package material.strings

import kotlin_bootcamp.aquarium.Fish
import java.util.*


fun main() {

//    interpolation()
//    concatenate()
//    isNullOrEmptyNameVisible()
//    take()
//    takeLast()
//    replace()
//    feedTheFish()
//    println("\nYour fortune is: ${getFortune()}")
//    maxOf(20, 30)
    takeAfter()
//    takeAndAppend()
//    joinToString()
//    nullToString()
//    isEmptyVsIsBlank()
//    nullOrEmptyVSNullOrBlank()

//    multiString_trimIndent()
//    multiString_trimMargin()

//    stringToNumber()

//    splitDelimiters()
//    splitRegex()
    // TODO    https://bezkoder.com/kotlin-split-string-example/

}

fun interpolation() {
    val name: String = "3888"
    val first = 1
    val second = 2

    println("Hello " + name)
    println("Hello $name")
    println("Value = ${first + second}")
}

private fun splitDelimiters() {
    val webAddress = "http://someadderess.com"

    println(webAddress.split("//")[0])
    println(webAddress.split("//")[1])

    val str = "bezkoder.com = Programming Tutorials - Web Development - Mobile App"

    val separate2 = str.split("=", "-").map { it.trim() }
    println(str)
    println(separate2)
}

private fun splitRegex() {
//    TODO  https://stackoverflow.com/questions/51460166/split-text-using-regex-java-kotlin-with-multiple-delimiter
    val str = "bezkoder.com = Programming Tutorials - Web Development - Mobile App"

    val separate1 = str.split("=|-".toRegex()).map { it.trim() }
    println(str)
    println(separate1)
}

fun isEmptyVsIsBlank() {
    val string = "ABC"
    val emptyString = ""
    val spaceString = "   "

    println("string isBlank ${string.isBlank()}")
    println("string isEmpty ${string.isEmpty()}")
    println("emptyString isBlank ${emptyString.isBlank()}")
    println("emptyString isEmpty ${emptyString.isEmpty()}")
    println("spaceString isBlank ${spaceString.isBlank()}")
    println("spaceString  isEmpty ${spaceString.isEmpty()}")
}

fun nullOrEmptyVSNullOrBlank() {
    val thisIsBlank = "   "

    println("thisIsBlank length = ${thisIsBlank.length}")
    println("isNullOrEmpty ${thisIsBlank.isNullOrEmpty()}")
    println("isNullOrBlank ${thisIsBlank.isNullOrBlank()}")

    val thisIsEmpty = ""

    println("thisIsEmpty length = ${thisIsEmpty.length}")
    println("isNullOrEmpty ${thisIsEmpty.isNullOrEmpty()}")
    println("isNullOrBlank ${thisIsEmpty.isNullOrBlank()}")
}

private fun concatenate() {
    /*
    https://www.baeldung.com/kotlin-concatenate-strings

    */

    val name = "Duncan"
    val lastName = "Macleod"
    println("$name $lastName")
    println(name.plus(" ").plus(lastName)) // plus() Method
    println(name + " " + lastName) //+ Operator
    println(StringBuilder().append(name).append(" ").append(lastName)) // StringBuilder

    val fullName = "$name $lastName" // String templates
    println(fullName)

    val numberOfDogs = 2
    val numberOfCats = 5

    println("I've a $numberOfDogs dogs and a $numberOfCats cats.")
    println("Totally there are a ${numberOfDogs + numberOfCats} pets in my house.")
}

private fun isNullOrEmptyNameVisible() {
    /*
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/is-null-or-empty.html
    * */

    val name: String? = ""
    val lastName: String? = null

    val fullName = if (name.isNullOrEmpty()) lastName else "$name$lastName"
    println(fullName.isNullOrEmpty().not())
}

private fun take() {
    val address = "A very long street name somewhere in the Earth"
    println(address.take(24).plus("..."))
}

fun takeLast() {
    val address = "A very long street name somewhere in the Earth"
    println(address.takeLast(1))
}

private fun takeAndAppend() {
    //pattern     "#### ### #### #"
    //index     "0 1 2 3 5 6 7 9 10 11 12 13"
    //value     "* * 1 2 3 4 5 6 7  8  9  0"
    val phone = "**12345678"
    val part1 = phone.substring(0, 4)
    val part2 = phone.substring(4, 7)
    var part3 = ""
    var part4 = ""

    if (phone.length == 10) {
        part3 = phone.substring(7)
    }

    if (phone.length == 11) {
        part3 = phone.substring(7, 10)
        part4 = phone.substring(10)
    }

    if (phone.length == 12) {
        part3 = phone.substring(7, 11)
        part4 = " " + phone.substring(11)
    }


    println(
        part1
            .plus(" ")
            .plus(part2)
            .plus(" ")
            .plus(part3)
            .plus(part4)
    )
}

private fun replace() {
    var a = 1
    println("We have $a")
    val s1 = "a is $a"
    println("value of s1 = $s1")
    a = 2
    println("Now a = $a")
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println("New value s2 = $s2")
    println()

    val path =
        "\\/storage\\/emulated\\/0\\/Android\\/data\\/app.panomic\\/files\\/Pictures\\/temp\\/6\\/2020_04_06_15_56_08.jpg"
    println(path)
    println(path.replace("\\", ""))
}

private fun getFortune(): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends, because they are your greatest fortune."
    )
    print("\nEnter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1
    println(
        "index = remainder of dividing birthday ($birthday) by the fortunes.size (${fortunes.size}) = " +
                "${birthday.rem(fortunes.size)}"
    )
    return fortunes[birthday.rem(fortunes.size)]

//
//    var fortune: String
//    for (i in 1..2) {
//        fortune = getFortune()
//        println("\nYour fortune is: $fortune")
//        if (fortune.contains("Take it easy")) break
//    }
}

private fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
}

private fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

private fun fishFood(day: String): String {
//    var food = "fasting"
//    when (day) {
//        "Monday" -> food = "flakes"
//        "Tuesday" -> food = "pellets"
//        "Wednesday" -> food = "redworms"
//        "Thursday" -> food = "granules"
//        "Friday" -> food = "mosquitoes"
//        "Saturday" -> food = "lettuce"
//        "Sunday" -> food = "plankton"
//    }
//    return food

    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

private fun takeAfter() {
    val myString = "http://address//change-phone-number?token=b27897c2-a8ff-4254-95d0-e80429632a3b.html"
    val toBeSearched = "token="
    val token = myString.substring(myString.indexOf(toBeSearched) + toBeSearched.length)

    print(token.substring(0, token.length - 5))
}

private fun joinToString() {
    val list = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))
    println(list.filter { it.name.contains("i") }.joinToString(" ") { it.name })

    val list2 = listOf("Flipper", "Moby Dick", "Dory")
    println(list2.filter { it.contains("i") }.joinToString(" ") { it })
}

private fun nullToString() {
    val test: String? = null
    println(test.toString() is String) // true
//    println(test is String) // false
}

private fun multiString_trimIndent() {
    val name = "Aramis"
    print(
        """
        The $name name
        contains ${name.length} letters
    """.trimIndent()
    )
}

private fun multiString_trimMargin() {
    println(
        """This is the first line
|and this is the second one
|and this is the third one
|...""".trimMargin()
    )
}


private fun stringToNumber() {
    val number = "123"
    val decimal = "1.2"

    println(number.toInt())
    println(decimal.toDouble())

    println(number.toFloat())
    try {
        println(decimal.toInt())

    } catch (e: Exception) {
        println(e)
    }

    println(decimal.toIntOrNull() ?: "Oo-ops!")
}
