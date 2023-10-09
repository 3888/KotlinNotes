package material.collections.associative_arrays.map


fun main() {
    val words = listOf("apple", "banana", "orange")
    val letters = words.flatMap { it.chunked(2) }
    val letters2 = words.flatMap { it.toList() }
    println(letters)
    println(letters2)

    val value = listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatMap {
        it
    }
    println(value)

    val books = listOf(
        Book("Thursday Next", listOf("Jasper Forde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")),
    )

    println(books.flatMap { it.authors }.toSet())
}

private class Book(val title: String, val authors: List<String>)