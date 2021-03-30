package material.loops

import material.constants.adt.enum.EnumColors
import java.util.*
import kotlin.random.Random

/*
https://kotlinlang.org/docs/reference/control-flow.html
 */

fun main() {

//    differentConditionsToCheckFishName("Vobla")
//    whenForEnum(EnumColors.GRAY)
//    whenCombineConditions(EnumColors.GRAY)
//    ifLogic()
//    dayOfWeek()
//    isItWeekend()

    areaOfVisibilityInWhen()

//    println(whatShouldIDoToday("HAPPY", "Sad", 25))

}

//check a value for being in or !in a range or a collection
private fun differentConditionsToCheckFishName(fishName: String) {
    when (fishName.length) {
        0 -> println("Fish name cannot be empty")
        in 1..12 -> println("$fishName is a good fish name")
        else -> "Too long fish name"
    }
}

private fun whenForEnum(color: EnumColors) {
    val result = when (color) {
        EnumColors.BLACK -> "Black"
        EnumColors.WHITE -> "White"
        EnumColors.RED -> "Red"
        EnumColors.GREEN -> "Green"
        else -> "I don't know" // in case we didn't describe GRAY
    }
    println(result)
}

private fun whenCombineConditions(color: EnumColors) {
    val result = when (color) {
        EnumColors.BLACK -> "Black"
        EnumColors.WHITE -> "White"
        EnumColors.RED -> "Red"
        EnumColors.GREEN -> "Green"
//    Вам не нужно использовать break, как в Java. Для комбинирования разных веток используйте запятые.
        EnumColors.GRAY, EnumColors.ORANGE -> "Gray and Orange in one slot"
    }
    println(result)
}

//We can use arbitrary expressions (not only constants) as branch conditions
private fun arbitraryExpressionsLikeIfLogic() {
    val a = Random.nextInt(1, 10)
    val b: Int = Random.nextInt(1, 10)

    println(" a = $a  b = $b")
    when {
        a > b -> println(" $a > $b ${a > b}")
        a < b -> println(" $a < $b ${a < b}")
        a == b -> println(" $a == $b ${a == b}")
    }
}

private fun areaOfVisibilityInWhen() {
    when (val number = Random.nextInt(1, 10)) {
        0, 1 -> print("Hello $number")
        in 2..5 -> print("Hey $number")
        else -> print("No $number")
    }
}

//when replaces the switch operator of C-like languages.
private fun dayOfWeek() {
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(
        when (day) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "Time has stopped"
        }
    )
}

private fun isItWeekend() {
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    dayOfWeek()
    println("Is it weekend?")
    println(
        when (day) {
            7, 1 -> "Yes"
            else -> "No"
        }
    )
}

private fun whatShouldIDoToday(mood: String, weather: String, temperature: Int): String {
    return when {
        mood.toLowerCase() == "happy" && weather.toLowerCase() == "sunny"
                && temperature in 15..30 -> " Let's go for a walk!"
        else -> "Well...It's better to stay home"
    }
}