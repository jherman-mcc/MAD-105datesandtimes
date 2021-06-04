import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.text.DecimalFormat
import java.util.*

fun main(args: Array<String>) {
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    val today = LocalDate.now()
    val formattedToday = today.format(formatter)
//   *** Next val is used for testing purposes only. If testing comment out the above line.
//   *** This gives the computer a different today's date for testing purposes only.
//  val formattedToday = LocalDate.of(2022,12, 6)
    val twoDigits = DecimalFormat("####.00")

    println("Today is $formattedToday")
    val referenceMoon = LocalDate.of(2021, 5, 26)
    val formattedRef = referenceMoon.format(formatter)
//  If testing then comment out the next line.
     if (referenceMoon.isAfter(today)) {
//    *** Next line is used for testing purposes to see future dates in the future
//   if (referenceMoon.isAfter(formattedToday)) {
//    Comment out next line if testing different today dates
        var daystoRefMoon = today.until(referenceMoon, ChronoUnit.DAYS)
//    Next line is used for testing only
//      var daystoRefMoon = formattedToday.until(referenceMoon, ChronoUnit.DAYS)
        println("Days to Full Moon is: $daystoRefMoon")
    } else {
//      Next line must be commented out if testing
        var daysfromRefMoon:Double = (today.until(referenceMoon, ChronoUnit.DAYS).toDouble())*-1
//      Next line is for testing purposes only. Use if testing different today dates.
//      var daysfromRefMoon:Double = (formattedToday.until(referenceMoon, ChronoUnit.DAYS).toDouble())*-1
        if (daysfromRefMoon > 29.5) {
            daysfromRefMoon = daysfromRefMoon % 29.5
        }
        var total = 29.5 - daysfromRefMoon
        println("The future new moon is in $total days")
    }
}