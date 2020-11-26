package material.exceptions

import java.util.*

fun main() {
//    arrayIndexOutOfBoundsException()
//    notImplementedError()
//    ClassCastException()

//    todo()

//    tryCatchAsValue()

    throwExceptionViaCheckInFunction()

}

private fun arrayIndexOutOfBoundsException(): String {
    val alphabet = listOf("1", "2", "3")
    return alphabet[Random().nextInt(10)]
}

private fun notImplementedError(): Nothing = throw NotImplementedError()

private fun todo() {
    TODO("Do your job!")
}

private fun ClassCastException() {
    val name: Any = 5
    val stringName: String = name as String

    print(stringName)

}

private fun tryCatchAsValue() {
    val nullableString: String? = null

    val textToPrint = try {
        nullableString!!.length
    } catch (e: Exception) {
        "Error $e"
    }

    print(textToPrint)
}

private fun throwExceptionViaCheckInFunction(){
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    proficiencyCheck(swordsJuggling)

    swordsJuggling = swordsJuggling!!.plus(1)
    println("You juggle $swordsJuggling swords!")
}

private fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
}