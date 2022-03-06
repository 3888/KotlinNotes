package material.strings

import java.util.regex.Matcher
import java.util.regex.Pattern

/*
https://www.youtube.com/watch?v=_pLpx6btq6U
https://regex101.com/
 */
class Regex

fun main() {
    val input = "Tonny'Stark"
    val regex = "[A-Za-z'-]+"
//    kotlinRegex(input, regex)
//    matcher(input, regex)

//    singleSymbol()
//    zeroAndMoreSymbol()
//    oneAndMoreSymbol()
//    zeroOrOneSymbol()

//    quantificationNTimes()

//    symbolFromRange()
//    symbolNotFromRange()

//    startOfTheLine()
//    endOfTheLine()
//    space()

//    shielding ()
//    wordBoundary()
//    NoWordBoundary()

//    anyFigure()
//    anyNonFigure()
//    wordCharacter()
//    nonWordCharacter()

//    firstLetterIsCapital()

//    println(replaceAndRegextoDragonSpeak("Humpty dumpty seat on the wall"))
//    replaceAllBrackets()

    regexNoShielding()

}

private fun String.checkRegex() = "[ABC]".toRegex().matches(this)

private fun matcher(input: String, regex: String) {
    val pattern = Pattern.compile(regex)
    val matcher: Matcher = pattern.matcher(input)
    println(
        "matcher input $input regex $regex ${matcher.matches()}"
    )
}

fun kotlinRegex(input: String, regex: String) {
    println(
        "kotlinRegex input *$input* regex is *$regex* result = ${Regex(regex).matches(input)}"
    )
}

fun checkByRegex(input: String, regex: String): Boolean {
    return Regex(regex).matches(input)
}

private fun singleSymbol() {
//    . - любой одиночный символ
    kotlinRegex("A1asfafg", "A.")
    kotlinRegex("A1", "A.")
    kotlinRegex("A ", "A.")
    kotlinRegex("A123", "A...")
}

private fun zeroAndMoreSymbol() {
//    * - от нуля и выше
    kotlinRegex("c C", "cA*")
}

private fun zeroOrOneSymbol() {
//    ? - ноль или один символ
    kotlinRegex("а", "A?")  // no (((
}

private fun oneAndMoreSymbol() {
//    + - от одного и выше
    kotlinRegex("A1asfafg", "A+") // no (((
}

private fun quantificationNTimes() {
//    {n} - n раз
    kotlinRegex("aa", "a{2}")
    kotlinRegex("aaaa", "a+{2}")
}

private fun symbolFromRange() {
//    [] - любой из указанных содержится
//    kotlinRegex("EYZX", "[a-z]+")
//    kotlinRegex("gweEYZX", "[A-Z]+")
//    kotlinRegex("gweEYZX", "[a-zA-Z]+")
//    kotlinRegex("gweEYZX123", "[a-zA-Z0-9]+")
//    kotlinRegex("22354", "[1234567890]+")
//    kotlinRegex("22354", "[0-9]+")
    kotlinRegex("-2345345", "-[0-9]+") // All negative and positive
//    kotlinRegex("22354", "[1-0]+") // Error PatternSyntaxException
}

private fun symbolNotFromRange() {
//    [] - любой из указанных не содержится
    kotlinRegex("23423", "[^a-z]+")
    kotlinRegex("fsdf", "[^0-9]+")
}

private fun startOfTheLine() {
//    ^ - начало строки
    kotlinRegex(
        "ssdgsdg", "^[a-z]+"
    )
}

private fun endOfTheLine() {
//    $ - конец строки
    kotlinRegex("\n", "[$]") // no (((
}

fun whitespace() {
//    \s - пробел
    kotlinRegex(" ", "\\s")
    kotlinRegex("    ", "\\s+")
    kotlinRegex("aasf", "\\s+")
    kotlinRegex("aa sf", "[a-z\\s]+")
}

private fun shielding() {
//    \ - экранирование
    kotlinRegex("dd", "\\.") // no (((
}

private fun wordBoundary() {
//    \b - граница слова
    kotlinRegex(" d ", "\\b+") // no (((
}

private fun NoWordBoundary() {
//    \b - без граница слова
    kotlinRegex("sgsg", "\\B+") // no (((
}

private fun anyFigure() {
//    \d - любая цифра equal to [0-9]
//    kotlinRegex("1", "\\d")
//    kotlinRegex("Y", "\\d")
//    \d - указанное колличесво цифр equal to [0-9]
//    kotlinRegex("123", "\\d\\d\\d")
//    kotlinRegex("123", "\\d\\d")

}

private fun anyNonFigure() {
//    \D - все кроме цифр equal to [^0-9]
    kotlinRegex("@", "\\D")
    kotlinRegex("hgsdhsY", "\\D+")
    kotlinRegex("1", "\\D")

}

private fun wordCharacter() {
//    \w - matches any word character (equal to [a-zA-Z0-9_])
    kotlinRegex("hgsdhsY", "\\w+")
    kotlinRegex("@#%@# ", "\\w+")
}

private fun nonWordCharacter() {
//    \w - matches any word character (equal to [^a-zA-Z0-9_])
    kotlinRegex("hgsdhsY", "\\W+")
    kotlinRegex("@#%@# ", "\\W+")
}

private fun firstLetterIsCapital() {
    kotlinRegex("test", "[A-Z][A-Za-z'-]+")
    kotlinRegex("Test", "[A-Z][A-Za-z'-]+")
}

private fun replaceAndRegextoDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun replaceAllBrackets() {
    /*
    https://stackoverflow.com/questions/15585569/simple-regex-replace-brackets
    * */
    val string = "{[Condition(type=DOLS, value=test test)]}"
        .replace("value=", "")
        .replace(Regex("[\\(\\)\\]\\[\\{\\}]"), "")

    println(string)
}

private fun regexNoShielding() {
//    2017 Kotlin in Action (94)
    val path = "/Users/yole/kotlin-book/chapter.adoc"

    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir : $directory, name: $filename , ext : $extension")
    }
}

