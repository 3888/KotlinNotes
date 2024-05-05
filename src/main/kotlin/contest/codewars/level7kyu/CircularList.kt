package contest.codewars.level7kyu

fun main() {
    val circularList2 = CircularList2(1, 2, 3, 4, 5)

    circularList2.prev() //   5))
    circularList2.prev() //   4))
    circularList2.next() //   5))
    circularList2.next() //   1))
    circularList2.next() //   2))
    circularList2.next() //   3))
    circularList2.next() //   4))
    circularList2.prev() //   3))
    circularList2.prev() //   2))
    circularList2.next() //   3))
    circularList2.next() //   4))
    circularList2.next() //   5))
    circularList2.next() //   1))
    circularList2.next() //   2))
    circularList2.next() //   3))

}

class CircularListMy<T>(vararg val elements: T) {
    init {
        position = -2
        if (elements.isEmpty()) throw Exception("Elements is empty")
    }

    fun next(): T {
        if (elements.isEmpty())
            println("next ${elements.contentToString()}")
        if (position == -2) {
            position = 0
            return elements[position]
        }
        position++
        if (position == elements.size) position = 0

        return elements[position]
    }

    fun prev(): T {
        println("prev ${elements.contentToString()}")
        if (position == -2) {
            position = elements.size - 1
            return elements[position]
        }
        position--
        if (position == -1) position = elements.size - 1
        return elements[position]
    }

    companion object {
        var position = -2
    }
}

class CircularList2<T>(vararg val elements: T) {
    var i = -1

    init {
        if (elements.isEmpty()) throw Exception()
    }

    fun next(): T {
        i = (i + 1) % elements.size
        return elements[i]
    }

    fun prev(): T {
        i = (if (i < 1) elements.size else i) - 1
        return elements[i]
    }
}

class CircularList3<T>(vararg val elements: T) {
    var i = -1
    init { if(elements.isEmpty()) throw Exception() }
    fun next() = elements.getOrNull(++i) ?: run { i = 0; elements.first() }
    fun prev() = elements.getOrNull(--i) ?: run { i = elements.lastIndex; elements.last() }
}