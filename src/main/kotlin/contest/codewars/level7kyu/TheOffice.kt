package contest.codewars.level7kyu


fun main() {

}

fun outedMy(meet: Map<String, Int>, boss: String): String {
    val new = meet.toMutableMap()
    new[boss] = meet[boss]?.times(2) ?: 0
    val result = new.values.sum() / meet.values.size

    return if (result <= 5) "Get Out Now!" else "Nice Work Champ!"
}

fun outed(meet: Map<String, Int>, boss: String): String {
    val avg = meet.asIterable().sumOf { if (it.key == boss) it.value * 2 else it.value } / meet.size
    return if (avg <= 5) "Get Out Now!" else "Nice Work Champ!"
}

fun outed2(meet: Map<String, Int>, boss: String) =
    if ((meet.values + meet[boss]!!).average() < 5.5) "Get Out Now!" else "Nice Work Champ!"

fun outed3(meet: Map<String, Int>, boss: String): String {
    return if ((meet.values.sum() + meet.getOrDefault(
            boss,
            0
        )) / meet.count() > 5
    ) "Nice Work Champ!" else "Get Out Now!"
}