package contest.codewars

fun main() {
    evaporator(10.0, 10.0, 5.0)
}

//https://www.codewars.com/kata/5506b230a11c0aeab3000c1f/discuss
private fun evaporator(content: Double, evapPerDay: Double, threshold: Double): Int {
    var gas = content
    var loose = content / 100 * evapPerDay
    val limit = content / 100 * threshold
    var days = 0

    while (gas > limit) {
        gas -= loose
        loose = gas / 100 * evapPerDay
        days++
    }

    println("days $days")
    return days
}
