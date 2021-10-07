package contest.codility

fun main() {
    println(solution(""))
}

private fun solution(string: String): Int {
    val charList: MutableList<Char> =
        "BALLOON1BALLOONN2BALLOON3"
//        "BAONXXOLL"
//        "BAOOLLNNOLOLGBAX"
//    "QAWABAWONL"
//                "BAOOLLNNOLOLGBAXQAWABAONXXOLLBAWONL"
            .toMutableList()

    val remainder = mutableListOf<Char>()
    remainder.addAll(charList)

    val result = mutableListOf("b", "a", "l", "l", "o", "o", "n")
    val baloon = mutableListOf("b", "a", "l", "l", "o", "o", "n")

    var ballonCount: Int
    var answer = 0

    charList.forEachIndexed { index, char ->
        val symbol = char.toString()
        when (symbol) {
            "B" -> {
                result[0] = symbol
                remainder.removeAt(remainder.indexOf(char))
            }
            "A" -> {
                result[1] = symbol
                remainder.removeAt(remainder.indexOf(char))
            }
            "L" -> {
//                0123456
//                BALLOON
                if (result[2] == "l") {
                    result[2] = "L"
                    return@forEachIndexed
                }

                if (result[3] == "l") {
                    result[3] = "L"
                }
                remainder.removeAt(remainder.indexOf(char))
            }

            "O" -> {
                if (result[4] == "o") {
                    result[4] = "O"
                    return@forEachIndexed
                }

                if (result[5] == "o") {
                    result[5] = "O"
                }
                remainder.removeAt(remainder.indexOf(char))

            }

            "N" -> {
                result[6] = symbol
                remainder.removeAt(remainder.indexOf(char))
            }
        }
//        println(char)


//        println("charList $charList")
//        println("remainder cuted $remainder")

        ballonCount = result.filter {
            it.single().isUpperCase()
        }.count()

//        println("********ballonCount $ballonCount ")

        if (ballonCount == 7) {
            result.clear()
            result.addAll(baloon)
            ballonCount = 0

            answer += 1
        }
    }

//
//    println("result $result")
//    println("remainder $remainder")

    return answer
}