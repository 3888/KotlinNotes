package contest.codewars.level8kyu

fun main() {



//    println(
//        abbrevNameMy(
////        "Vasya Pupkin"
////        "Patrick Feenan"
////        "Evan Cole"
////        "P Favuzzi"
//            "David Mendieta"
//        )
//    )

}

private fun abbrevNameMy(name: String): String {
    val firstName = name.substring(0, name.indexOf(" ")).first().toUpperCase()
    val lastName = name.substring(name.indexOf(" ") + 1, name.length).first().toUpperCase()

    return "$firstName.$lastName"
}

private fun abbrevNameSubstring(name: String): String {
    val firstName = name.substringBefore(' ').toUpperCase()
    val lastName = name.substringAfter(' ').toUpperCase()
    val initials = firstName[0] + "." + lastName[0]
    return initials
}

private fun abbrevNameSpitAndTake(name: String): String {
    val c = name.split(" ")
    val a = c[0].take(1).toUpperCase()
    val b = c[1].take(1).toUpperCase()
    return "$a.$b"
}

private fun abbrevNameSplit(name: String) = name.toUpperCase().first() + "." + name.toUpperCase().split(" ")[1].first()

private fun abbrevNameJoinToString(name: String) = name.split(" ").joinToString(".") { it.take(1).capitalize() }

private fun abbrevNameSplitAndJoinToString(name: String) = name.split(" ").map { it[0] }.joinToString(".").toUpperCase()