package khronos

import java.text.SimpleDateFormat
import java.util.*

internal val calendar: Calendar by lazy {
    Calendar.getInstance()
}

operator fun Date.plus(duration: Duration): Date {
    calendar.time = this
    calendar.add(duration.unit, duration.value)
    return calendar.time
}

operator fun Date.minus(duration: Duration): Date {
    calendar.time = this
    calendar.add(duration.unit, -duration.value)
    return calendar.time
}

operator fun Date.rangeTo(other: Date) = DateRange(this, other)

fun Date.with(year: Int = -1, month: Int = -1, day: Int = -1, hour: Int = -1, minute: Int = -1, second: Int = -1, millisecond: Int = -1): Date {
    calendar.time = this
    if (year > -1) calendar.set(Calendar.YEAR, year)
    if (month > 0) calendar.set(Calendar.MONTH, month - 1)
    if (day > 0) calendar.set(Calendar.DATE, day)
    if (hour > -1) calendar.set(Calendar.HOUR_OF_DAY, hour)
    if (minute > -1) calendar.set(Calendar.MINUTE, minute)
    if (second > -1) calendar.set(Calendar.SECOND, second)
    if (millisecond > -1) calendar.set(Calendar.MILLISECOND, millisecond)
    return calendar.time
}

fun Date.with(weekday: Int = -1): Date {
    calendar.time = this
    if (weekday > -1) calendar.set(Calendar.WEEK_OF_MONTH, weekday)
    return calendar.time
}

val Date.beginningOfYear: Date
    get() = with(month = 1, day = 1, hour = 0, minute = 0, second = 0, millisecond = 0)

val Date.endOfYear: Date
    get() = with(month = 12, day = 31, hour = 23, minute = 59, second = 59, millisecond = 999)

val Date.beginningOfMonth: Date
    get() = with(day = 1, hour = 0, minute = 0, second = 0, millisecond = 0)

val Date.endOfMonth: Date
    get() = endOfMonth()

fun Date.endOfMonth(): Date {
    calendar.time = this
    val lastDay = calendar.getActualMaximum(Calendar.DATE)
    return with(day = lastDay, hour = 23, minute = 59, second = 59, millisecond = 999)
}

val Date.beginningOfDay: Date
    get() = with(hour = 0, minute = 0, second = 0, millisecond = 0)

val Date.endOfDay: Date
    get() = with(hour = 23, minute = 59, second = 59, millisecond = 999)

val Date.beginningOfHour: Date
    get() = with(minute = 0, second = 0, millisecond = 0)

val Date.endOfHour: Date
    get() = with(minute = 59, second = 59, millisecond = 999)

val Date.beginningOfMinute: Date
    get() = with(second = 0, millisecond = 0)

val Date.endOfMinute: Date
    get() = with(second = 59, millisecond = 999)

fun Date.toString(format: String): String = SimpleDateFormat(format).format(this)

fun Date.isSunday(): Boolean {
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
}

fun Date.isMonday(): Boolean {
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY
}

fun Date.isTuesday(): Boolean {
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY
}

fun Date.isWednesday(): Boolean {
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY
}

fun Date.isThursday(): Boolean {
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY
}

fun Date.isFriday(): Boolean {
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
}

fun Date.isSaturday(): Boolean {
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
}
