package khronos

import java.util.*

/**
 * NOTE: In Kotlin you can't add companion object extensions to existing Java class.
 */
object Dates {
    val today = Date()

    val tomorrow = setDate(value = 1)

    val yesterday = setDate(value = -1)

    private fun setDate(value: Int): Date {
        calendar.time = Date()
        calendar.add(Calendar.DATE, value)
        return calendar.time
    }

    fun of(year: Int = -1, month: Int = -1, day: Int = -1, hour: Int = -1, minute: Int = -1, second: Int = -1, millisecond: Int = -1): Date {
        return Date().with(year, month, day, hour, minute, second, millisecond)
    }
}
