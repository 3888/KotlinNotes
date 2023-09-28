package contest.codewars.level7kyu

import java.time.LocalTime

fun main() {

    arrayOf("12:12:12") //1
    arrayOf("00:00:00", "00:01:11", "02:15:59", "23:59:58", "23:59:59") //1
    arrayOf("12:00:00", "23:59:59", "00:00:00") //2
    arrayOf("12:00:00", "12:00:00", "00:00:00") //3

    checkLogs(
        arrayOf("00:00:00", "00:01:11", "02:15:59", "23:59:58", "23:59:59")
//        arrayOf("12:00:00", "23:59:59", "00:00:00") //2
//        arrayOf("12:00:00", "12:00:00", "00:00:00")
    )

}

fun checkLogsMy(log: Array<String>): Int {
    var previousLog = -1
    var currentLog: Int
    var days = 1
    if (log.isEmpty()) return 0

    log.forEach {
        currentLog = LocalTime.parse(it).toSecondOfDay()
        when {
            previousLog > currentLog -> days++
            previousLog == currentLog -> days++
        }
        previousLog = currentLog
    }

    return days
}

fun checkLogs(log: Array<String>): Int =
    log.size - log.asSequence().zipWithNext{ x, y -> x < y }.count{ it }