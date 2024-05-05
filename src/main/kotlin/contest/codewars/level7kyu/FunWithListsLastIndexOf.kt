package contest.codewars.level7kyu


fun main() {
    Kata.lastIndexOfMy(Kata.listFromList(listOf(17, "17", 1.2)), "17")

}


object Kata {
    fun lastIndexOfMy(head: Node?, value: Any): Int = head.toString().split(",").indexOf("$value${value::class.simpleName}")

    fun lastIndexOf(head: Node?, value: Any) = generateSequence(head) { it.next }.indexOfLast { it.data == value }

    fun listFromList(r: List<Any>): Node? = if (r.none()) null else Node(r[0], listFromList(r.drop(1)))


    data class Node(val data: Any?, val next: Node? = null) {
        override fun toString(): String {
            return if (next != null) {
                "$data${data!!::class.simpleName},$next"
            } else {
                data.toString()
            }
        }
    }
}

