package material.classExamples

fun main() {


}

object MobyDickWhale {
    val author = "Herman Melville"

    fun jump() {}
}



sealed class Seal

class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "Walrus"
        is SeaLion -> "SeaLion"
    }
}
