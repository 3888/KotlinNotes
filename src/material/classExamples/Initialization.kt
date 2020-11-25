package material.classExamples

class Initialization(initValue: String) {

    val value: String

    init {
        println("init")
        value = initValue
    }

    fun make() {
        println("Value = $value")
    }
}
