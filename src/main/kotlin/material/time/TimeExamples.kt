package material.time

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit


/*
https://www.journaldev.com/17899/java-simpledateformat-java-date-format
*/
fun main() {

//    daysLeft()
//    millisToMinAndSeconds()
//    millisToDate()

//    firstDayOfCurrentMonth()
//    dayOfMonthFromTimeMillis()
    getDayOfMonthSuffix()


}

private fun millisToDate() {
    val simpleDateFormat = SimpleDateFormat("dd/mm/yyyy hh:mm")
    val dateString = simpleDateFormat.format(System.currentTimeMillis())


    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    val localDateTime = LocalDateTime.now()
    val formatted = localDateTime.format(formatter)

    println("simpleDateFormat : $dateString")
    println("LocalDateTime : $formatted")

}

private fun millisToMinAndSeconds(millis: Long): String {
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
    val calendar = Calendar.getInstance() // this takes current date
    calendar[Calendar.DAY_OF_MONTH] = 1
    println(calendar.time) // this returns java.util.Date

    val todaydate = LocalDate.now()
    println("Months first date in yyyy-mm-dd: " + todaydate.withDayOfMonth(1))
}

private fun dayOfMonthFromTimeMillis() {
    val date = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate()
    println("Day of month " + date.withDayOfMonth(1))
}

fun getDayOfMonthSuffix() {
    val intRange = 1..31
    intRange.forEach { dayOfMonth ->
        val ordinal = when {
            dayOfMonth in 11..13 -> "th"
            dayOfMonth % 10 == 1 -> "st"
            dayOfMonth % 10 == 2 -> "nd"
            dayOfMonth % 10 == 3 -> "rd"
            else -> "th"
        }

        println("dayOfMonth $dayOfMonth ordinal $ordinal")
    }
}



