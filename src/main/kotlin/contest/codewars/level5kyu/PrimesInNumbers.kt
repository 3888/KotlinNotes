package contest.codewars.level5kyu


fun main() {
/*
https://www.codewars.com/kata/54d512e62a5e54c96200019e/solutions/kotlin
*/

//        1024
//        86240
//        4238285
//            7775460 //

//    println(factors(775878912))
//    factorsMy(775878912)
}

private fun factorsMy(value: Int): String {
/*
https://www.youtube.com/watch?v=WajdeWS5eVk
https://www.codewars.com/kata/54d512e62a5e54c96200019e/train/kotlin
* */
    var divider = 2
    var dividen = value
    var flag = true

    val container = mutableMapOf<Int, Int>()
    var count = 0

    while (flag) {
//        println("*****dividen $dividen % divider $divider  ${dividen % divider}")
        if (dividen % divider == 0) {
            count += 1
            container[divider] = count
            dividen /= divider
        }

        if (dividen % divider > 0) {
            count = 0
            divider += 1
        }

        if (dividen == 1) flag = false
    }

    val answer = container.toString()
        .replace("{", "(")
        .replace("}", ")")
        .replace(" ", "(")
        .replace(",", ")")
        .replace("=", "**")
        .replace("**1", "")


    return answer
}

fun factors(value: Int): String {
    var dividen = value
    val stringBuilder = StringBuilder()
    for (divider in 2 until Int.MAX_VALUE) {
        if (dividen == 1) {
            break
        }
        var count = 0
        while (dividen % divider == 0) {
            dividen /= divider
            count++
        }
        if (count > 0) {
            stringBuilder.append(
                String.format(
                    "(%1\$d%2\$s)",
                    divider,
                    if (count == 1) "" else String.format("**%1\$d", count)
                )
            )
        }
    }
    return stringBuilder.toString()
}