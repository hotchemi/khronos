package khronos

import java.util.*

/**
 * NOTE: In Kotlin you can't add companion object extensions to existing Java class.
 */
object Dates {

    val now = Date()

    val today = Date()

    val tomorrow = setDate(value = 1)

    val yesterday = setDate(value = -1)

    private fun setDate(value: Int): Date {
        calendar.time = Date()
        calendar.add(Calendar.DATE, value);
        return calendar.time
    }

    fun of(year: Int = 0, month: Int = 0, day: Int = 0, hour: Int = 0, minute: Int = 0, second: Int = 0): Date {
        calendar.time = Date()
        if (year > 0) calendar.set(Calendar.YEAR, year)
        if (month > 0) calendar.set(Calendar.MONTH, month)
        if (day > 0) calendar.set(Calendar.DATE, day)
        if (hour > 0) calendar.set(Calendar.HOUR, hour)
        if (minute > 0) calendar.set(Calendar.MINUTE, minute)
        if (second > 0) calendar.set(Calendar.SECOND, second)
        return calendar.time
    }

}