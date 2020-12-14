package kotlin_bootcamp.book

import material.constants.CompileTimeConst

const val MAX_NUMBER_BOOKS = 20

class Book(val title: String, val author: String, val year: Int, var pages: Int) {


    companion object {
        val BASE_URL = "http://www.turtlecare.net/"
    }

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

fun main(args: Array<String>) {

    val book = Book("Romeon and Juliet", "William Shakespeare", 1597, 312)
    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

    println(
        "Here is your book ${bookTitleAuthorYear.first} " +
                "by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}"
    )


}

fun canBorrow(hasBooks: Int): Boolean {
    return (hasBooks < MAX_NUMBER_BOOKS)
}


fun Book.weight(): Double {
    return (pages * 1.5)
}

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

