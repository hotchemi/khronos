package khronos

import java.util.*

val Int.year: Duration
    get() = Duration(unit = Calendar.YEAR, value = this)

val Int.years: Duration
    get() = year

val Int.month: Duration
    get() = Duration(unit = Calendar.MONTH, value = this - 1)

val Int.months: Duration
    get() = month

val Int.week: Duration
    get() = Duration(unit = Calendar.WEEK_OF_MONTH, value = this)

val Int.weeks: Duration
    get() = week

val Int.day: Duration
    get() = Duration(unit = Calendar.DATE, value = this)

val Int.days: Duration
    get() = day

val Int.hour: Duration
    get() = Duration(unit = Calendar.HOUR_OF_DAY, value = this)

val Int.hours: Duration
    get() = hour

val Int.minute: Duration
    get() = Duration(unit = Calendar.MINUTE, value = this)

val Int.minutes: Duration
    get() = minute

val Int.second: Duration
    get() = Duration(unit = Calendar.SECOND, value = this)

val Int.seconds: Duration
    get() = second

val Int.millisecond: Duration
    get() = Duration(unit = Calendar.MILLISECOND, value = this)

val Int.milliseconds: Duration
    get() = millisecond
