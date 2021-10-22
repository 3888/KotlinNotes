package contest.yandex

fun main(args: Array<String>) {
    val j = "abc"
//        readLine()!!
    val s = "aaabbbcccddd"
//        readLine()!!

    var result = 0
    for (c in s) {
        if (j.contains(c)) {
            result += 1;
        }
    }

    println(result)
}