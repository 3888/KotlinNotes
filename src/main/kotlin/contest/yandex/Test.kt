package contest.yandex

fun main(args: Array<String>) {
    val j = readLine()!!
    val s = readLine()!!

    var result = 0
    for (c in s) {
        if (j.contains(c)) {
            result += 1;
        }
    }

    println(result)
}