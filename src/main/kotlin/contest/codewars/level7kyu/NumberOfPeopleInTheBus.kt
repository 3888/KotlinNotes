package contest.codewars.level7kyu

fun main() {
    println(people(arrayOf(10 to 0, 3 to 5, 5 to 8)))

}

private fun peopleMy(busStops: Array<Pair<Int, Int>>) = busStops.sumBy { it.first - it.second}

private fun people(busStops: Array<Pair<Int, Int>>) = busStops.sumBy { (on, off) -> on - off }

private fun people2(busStops: Array<Pair<Int, Int>>): Int = with(busStops.unzip()) { first.sum() - second.sum() }

private fun people3(busStops: Array<Pair<Int, Int>>) = busStops.fold(0, { acc, pair -> acc + pair.first - pair.second })

private fun people4(busStops: Array<Pair<Int, Int>>) = busStops.map { it.first - it.second }.sum()
