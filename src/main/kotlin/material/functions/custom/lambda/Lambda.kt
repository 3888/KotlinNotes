package material.functions.custom.lambda

fun main() {

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(list.customLambdaFilter {
        it > 3
    })

    val listAny = listOf("Hi", 123, null, 2.6)
    println(listAny.customLambdaFilterGeneric { it != null })

    val listString = listOf("Hi", "Hello", "Hola")
    println(listString.customLambdaFilterGenericRestricted { it.isNotEmpty() })
}

private fun List<Int>.customLambdaFilter(filterFunction: (Int) -> (Boolean)): List<Int> {
    val resultList = mutableListOf<Int>()
    for (value in this) {
        if (filterFunction(value)) resultList.add(value)
    }
    return resultList
}

private fun <T> List<T>.customLambdaFilterGeneric(filterFunction: (T) -> (Boolean)): List<T> {
    val resultList = mutableListOf<T>()
    for (value in this) {
        if (filterFunction(value)) resultList.add(value)
    }
    return resultList
}

private fun <T : String> List<T>.customLambdaFilterGenericRestricted(filterFunction: (T) -> (Boolean)): List<T> {
    val resultList = mutableListOf<T>()
    for (value in this) {
        if (filterFunction(value)) resultList.add(value)
    }
    return resultList
}