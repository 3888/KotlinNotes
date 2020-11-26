package material.filters


fun main() {
    filterData()

}

private fun todo() {
    val decorations = listOf("paper", "puppy", "board", "player")
    println("filter ${decorations.filter { true }}")

    val eager = decorations.filter { it[0] == 'p' }
    println("filter with conditions ${eager.filter { it[0] == 'p' }}")

//    apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered = $filtered")
    println("filtered.toList() = ${filtered.toList()}")

//    apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
    }

    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")

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
    val list: List<Data> = listOf(
        Data("first", false),
        Data("second", false),
        Data("third ", true)
    )

val result = list.filter { it.isActive }

    print(result.first().data )
}

private data class Data(val data: String, val isActive: Boolean)






