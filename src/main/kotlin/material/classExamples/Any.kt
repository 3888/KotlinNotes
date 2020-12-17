package material.classExamples

fun main() {
    val any = Any(1, 2)
    val data = Data(1, 2)

    println(any.toString())
    println(data.toString())

    println(Any(1, 2) == Any(1, 2)) // equals
    println(Data(1, 2) == Data(1, 2)) // equals


}

private class Any(val x: Int, val y: Int)

private data class Data(val x: Int, val y: Int)