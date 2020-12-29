package material.functional_programming

fun main() {
    flipValues()
}

private fun flipValues() {
    val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)
    println(gradesByStudent)

    val list = mutableMapOf<Double, String>()
    gradesByStudent.map {
        list.put(it.value, it.key)
    }
    println(list)
}