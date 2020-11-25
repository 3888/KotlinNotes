package material.exceptions

fun main() {
    
    throwCustomException()

}

private fun throwCustomException() {
    val swordsJuggling: Int? = null

    swordsJuggling ?: throw UnskilledSwordJugglerException()
}

class UnskilledSwordJugglerException() :
        IllegalStateException("Player cannot juggle swords")