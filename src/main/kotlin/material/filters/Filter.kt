package material.filters


fun main() {

//    examples()
//    filterData()
//    filterNot()
//    filterSingleValue()
    filterMultiplyValue()
}

fun filterMultiplyValue() {
    val list = listOf(
        DataExample("a", true),
        DataExample("b", false),
        DataExample("", true)
    )

    println(list.filter {
        when {
            it.data.isNotEmpty() -> it.data.isNotEmpty() && it.isActive
            it.isActive -> true
            else -> false
        }
    }
    )
}

fun filterSingleValue() {
    val filterStringCondition = "aaaBBB_c_"
    val string = "AAAsdvdsfaaaBewbewbBBB___c___"
    println(filterStringCondition.filter { it in string })

    val filterIntCondition = 111
    val number = 111111111.toString()
    println(filterIntCondition.toString().filter { it in number })
}

fun filterNot() {
    val newArray = intArrayOf(1, 3, 6, -4, -1, -5, 2, 7, 9, 11, 8).sortedArray().filterNot { it < 1 }
    println(newArray)
}

fun isLetter(str: String): String {
//    return str.filter(Char::isLetter)
    return str.filter { it.isLetter() }
//    return str.filter { it in 'a'..'z' || it in 'A'..'Z' }
}

private fun examples() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    println(
        spices.filter { it.contains("curry") }.sortedBy { it.length }
    )

    println(
        spices.filter { it.startsWith('c') }.filter { it.endsWith('e') }
    )

    println(
        spices.filter { it.startsWith('c') && it.endsWith('e') }
    )

    println(
        spices.take(3).filter { it.startsWith('c') }
    )
}

private fun filterData() {
    val list: List<DataExample> = listOf(
        DataExample("first", false),
        DataExample("second", false),
        DataExample("third ", true)
    )

    val result = list.filter { it.isActive }

    print(result.first().data)
}

private data class DataExample(val data: String, val isActive: Boolean)






