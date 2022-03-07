package contest.codewars.level7kyu

fun main() {

    println(getCount("abracadabra"))
}

private fun getCountMy(str: String): Int {
    var count = 0
    str.map {
        if (it in "aeiou") count++
    }
    return count
}

private fun getCount(str: String) = str.count { it in "aeiou" }
private fun getCount2(str: String) = str.count { x -> "aeiou".contains(x) }

private fun getCount3(str: String) = str.filter { ch -> ch in "aeiou" }.length

private fun getCount4(str: String): Int = str.length - str.replace("[aeiou]".toRegex(), "").length
private fun getCount5(str: String): Int = Regex("([aeiou])").findAll(str).count()




