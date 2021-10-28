package contest.codewars.level8kyu

fun main() {

    println(
        centuryMy(2000)
    )
}

private fun centuryMy(number: Int): Int {
    /*
    https://www.codewars.com/kata/5a3fe3dde1ce0e8ed6000097/train/kotlin
    * */
    val hundredYearsCount = (number - number.rem(100)) / 100

    return when {
        number in 1..100 -> 1
        number - (number - number.rem(100)) > 0 -> hundredYearsCount + 1
        number / 100 == hundredYearsCount -> hundredYearsCount
        else -> -1
    }
}

private fun century(number: Int) = (number + 99) / 100