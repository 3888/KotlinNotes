package material.time

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
import java.util.concurrent.TimeUnit


fun main() {

//    for (i in 1..3) {
//        println(millisToMinAndSeconds(Random.nextLong(59000, 120000)))
//    }

    //    daysLeft()
    firstDayOfCurrentMonth()
}

private fun millisToMinAndSeconds(millis: Long): String {
//    val format = "%d min, %d sec"
    val format = "%d min, %02d sec"

    return String.format(
        format,
        TimeUnit.MILLISECONDS.toMinutes(millis),
        TimeUnit.MILLISECONDS.toSeconds(millis) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
    )
}

private fun daysLeft() {
    val date = "2020-11-20T10:18:47Z"
    val endDate = Instant.parse(date).toEpochMilli()
    val now = System.currentTimeMillis()
    val days = TimeUnit.MILLISECONDS.toDays(
        (endDate - now) // 8
//        now.minus(endDate) // -8
    )


    val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS")
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = now
    val nowFormatted = now.toString() + " = " + formatter.format(calendar.time)
    calendar.timeInMillis = endDate
    val endDateFormatted = endDate.toString() + " = " + formatter.format(calendar.time)

    println(nowFormatted)
    println(endDateFormatted)
    println(days)

}


private fun firstDayOfCurrentMonth() {
    val cal = Calendar.getInstance()
    val firstDay = cal.set(Calendar.DAY_OF_MONTH, 1)
    println(firstDay)
}