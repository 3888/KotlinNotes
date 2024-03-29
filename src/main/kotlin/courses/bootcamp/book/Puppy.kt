package courses.bootcamp.book

import material.Helper

fun main() {
    val puppy = Puppy()
    val book = Book("Oliver Twist", "Charles Dickens", 1837, 100)

    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
    println("Sad puppy, no more pages in ${book.title}. ")
}


class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Helper.random.nextInt(12))
    }
}


