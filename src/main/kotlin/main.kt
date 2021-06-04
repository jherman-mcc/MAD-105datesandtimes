import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.text.DecimalFormat
import java.util.*

fun main(args: Array<String>) {
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    val today = LocalDate.now()
    val formattedToday = today.format(formatter)

    val twoDigits = DecimalFormat("####.00")

    println("Today is $formattedToday")
    val referenceMoon = LocalDate.of(2021, 5, 26)
    val formattedRef = referenceMoon.format(formatter)
//  println("Reference Moon date is $formattedRef")
    if (referenceMoon.isAfter(today)) {
        var daystoRefMoon = today.until(referenceMoon, ChronoUnit.DAYS)
        println("Days to Full Moon is: $daystoRefMoon")
    } else {
        var daysfromRefMoon = (today.until(referenceMoon, ChronoUnit.DAYS))*-1
        var total = 29.5 - daysfromRefMoon
        println("The future new moon is in $total days")
    }
}