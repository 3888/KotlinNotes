package material.exceptions

import material.Helper
import java.util.*

fun main() {
//    arrayIndexOutOfBoundsException()
//    notImplementedError()
//    ClassCastException()

//    todo()

//    tryCatchAsValue()

//    throwExceptionViaCheckInFunction()

//    preconditionCheckNotNull(null)
//    preconditionRequire(null)
//    preconditionRequireNotNull(null)
//    preconditionError()
    preconditionAssert(null)


}

private fun arrayIndexOutOfBoundsException(): String {
    val alphabet = listOf("1", "2", "3")
    return alphabet[Helper.random.nextInt(4, 6)]
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

private fun throwExceptionViaCheckInFunction() {
    var swordsJuggling: Int? = null

    val ability = (1..3).shuffled().last()
    println("Ability is $ability")
    val isJugglingProficient = ability == 3

    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    println("isJugglingProficient $isJugglingProficient")
    println("swordsJuggling = $swordsJuggling")
    proficiencyCheck(swordsJuggling)

    swordsJuggling = swordsJuggling!!.plus(1)
    println("You juggle $swordsJuggling swords!")
}

private fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
}

private fun preconditionCheckNotNull(value: Int?) {
    checkNotNull(value, { "Error message or Any" })
}

private fun preconditionRequire(value: Int?) {
    require(value != null) {
        "Error message or Any"
    }
}

private fun preconditionRequireNotNull(value: Int?) {
    requireNotNull(value) {
        "Error message or Any"
    }
}

private fun preconditionError() {
    error("Error message")
}

private fun preconditionAssert(value: Int?) {
    assert(value != null) {
        "Error message or Any"
    }
}