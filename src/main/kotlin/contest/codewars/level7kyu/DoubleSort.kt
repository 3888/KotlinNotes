package contest.codewars.level7kyu

fun main() {


}

object DoubleSort {
    fun dbSortMy(a: Array<Any>): Array<Any> = listOf(
        a.filterIsInstance<Int>().sorted().reversed(),
        a.filterIsInstance<String>().sorted()).flatten().toTypedArray()

    fun dbSort(a: Array<Any>): Array<Any> = (a.filterIsInstance<Int>().sortedBy { it } + a.filterIsInstance<String>().sorted()).toTypedArray()

    fun dbSort2(a:Array<Any>): Array<Any> =
        a.partition { it !is String }.let { (n, s) -> (n as List<Int>).sorted() + (s as List<String>).sorted() }.toTypedArray()
}