package contest.codewars.level7kyu

fun main() {
    println(
        maxRotMy(
            4566183913  // 5689363411

            /*
           4566183913
           {}4`566183913 ->      5661839134
         {5}6`61839134->         5618391346
         {56}1`8391346 ->        5683913461
         {568}3`913461 - >       5689134613
            * */
        )
    )
}


fun maxRotMy(n: Long): Long {
    var result = n.toString()
    var value = ""
    var max = n

    for (i in 0..result.length - 1) {  // i in str.indices
        value = result.drop(i)
        result = result.take(i)
        result = "$result${moveToLast(value)}"
        if (result.toLong() > max) max = result.toLong()

    }
    return max
}

fun moveToLast(value: String): String {
    if (value.length <= 1) return value
    return "${value.takeLast(value.length - 1)}${value.first()}"
}

fun maxRot(n:Long):Long {
    var str = n.toString()
    var x: Long = n
    for (i in str.indices) {
        str = StringBuilder(str + str[i]).deleteCharAt(i).toString()
        x = maxOf(x, str.toLong())
    }
    return x
}

