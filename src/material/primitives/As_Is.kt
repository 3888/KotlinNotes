package material.primitives

import kotlin.random.Random

fun main() {

//    isExample()
    asNullableExample()
}

private fun isExample() {
    val value =
            when (Random.nextInt(0, 3)) {
                0 -> ""
                1 -> 0
                2 -> 0L
                else -> 0.0
            }

    when (value) {
        is String -> print(value::class.simpleName)
        is Int -> print(value::class.simpleName)
        is Long -> print(value::class.simpleName)
    }
}


private fun asNullableExample() {
    val name: Any = 5

//    val stringName: String = name as String // ClassCastException

    val stringName: String = name as? String ?: "Empty"

    print(stringName)

}