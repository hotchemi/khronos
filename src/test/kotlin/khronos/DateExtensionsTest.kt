package khronos

import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

/**
 * Unit test for DateExtensions.kt.
 */
class DateExtensionsTest {
    companion object {
        val iso8601 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
    }

    @Test fun plus() {
        val date = iso8601.parse("2017-10-21T13:05:20.632")
        assertEquals(
            expected = iso8601.parse("2017-10-28T15:05:20.632"),
            actual = date + 1.week + 2.hours
        )
    }

    @Test fun minus() {
        val date = iso8601.parse("2017-10-21T13:05:20.632")
        assertEquals(
            expected = iso8601.parse("2017-10-20T13:05:19.999"),
            actual = date - 1.day - 633.milliseconds
        )
    }

    @Test fun with() {
        run {
            val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 4, second = 33, millisecond = 123)
            assertEquals(
                    expected = Dates.of(year = 1990, month = 6, day = 2, hour = 12, minute = 4, second = 33, millisecond = 123),
                    actual = date.with(year = 1990))
        }
        run {
            val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 55, second = 1, millisecond = 321)
            assertEquals(
                    expected = Dates.of(year = 1987, month = 6, day = 9, hour = 12, minute = 55, second = 1, millisecond = 321),
                    actual = date.with(weekday = 2))
        }
    }

    @Test fun beginningOfYear() {
        val date = Dates.of(year = 2016, month = 6, day = 2, hour = 5, minute = 30, second = 59, millisecond = 888)
        assertEquals(
                expected = Dates.of(year = 2016, month = 1, day = 1, hour = 0, minute = 0, second = 0, millisecond = 0),
                actual = date.beginningOfYear)
    }

    @Test fun endOfYear() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 5, minute = 0, second = 0, millisecond = 101)
        assertEquals(
                expected = Dates.of(year = 1987, month = 12, day = 31, hour = 23, minute = 59, second = 59, millisecond = 999),
                actual = date.endOfYear)
    }

    @Test fun beginningOfMonth() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 5, minute = 0, second = 0, millisecond = 123)
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 1, hour = 0, minute = 0, second = 0, millisecond = 0),
                actual = date.beginningOfMonth)
    }

    @Test fun endOfMonth() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 0, second = 0, millisecond = 0)
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 30, hour = 23, minute = 59, second = 59, millisecond = 999),
                actual = date.endOfMonth)
    }

    @Test fun beginningOfDay() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 0, second = 0, millisecond = 12)
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 2, hour = 0, minute = 0, second = 0, millisecond = 0),
                actual = date.beginningOfDay)
    }

    @Test fun endOfDay() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 9, minute = 0, second = 0, millisecond = 998)
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 2, hour = 23, minute = 59, second = 59, millisecond = 999),
                actual = date.endOfDay)
    }

    @Test fun beginningOfHour() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 30, second = 30, millisecond = 1)
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 0, second = 0, millisecond = 0),
                actual = date.beginningOfHour)
    }

    @Test fun endOfHour() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 30, second = 30, millisecond = 58)
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 59, second = 59, millisecond = 999),
                actual = date.endOfHour)
    }

    @Test fun beginningOfMinute() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 30, second = 30, millisecond = 2)
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 30, second = 0, millisecond = 0),
                actual = date.beginningOfMinute)
    }

    @Test fun endOfMinute() {
        val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 30, second = 30, millisecond = 54)
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 30, second = 59, millisecond = 999),
                actual = date.endOfMinute)
    }

    @Test fun to_String() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 5)
        Assert.assertEquals(
                SimpleDateFormat("yyyy-MM-dd HH").format(calendar.time),
                5.minutes.since.toString("yyyy-MM-dd HH"))
    }

    @Test fun isSunday() {
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 21)
            val date = calendar.time
            assert(date.isSunday())
        }
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 22)
            val date = calendar.time
            assert(!date.isSunday())
        }
    }

    @Test fun isMonday() {
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 22)
            val date = calendar.time
            assert(date.isMonday())
        }
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 23)
            val date = calendar.time
            assert(!date.isMonday())
        }
    }

    @Test fun isTuesday() {
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 23)
            val date = calendar.time
            assert(date.isTuesday())
        }
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 24)
            val date = calendar.time
            assert(!date.isTuesday())
        }
    }

    @Test fun isWednesday() {
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 24)
            val date = calendar.time
            assert(date.isWednesday())
        }
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 25)
            val date = calendar.time
            assert(!date.isWednesday())
        }
    }

    @Test fun isThursday() {
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 25)
            val date = calendar.time
            assert(date.isThursday())
        }
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 26)
            val date = calendar.time
            assert(!date.isThursday())
        }
    }

    @Test fun isFriday() {
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 26)
            val date = calendar.time
            assert(date.isFriday())
        }
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 27)
            val date = calendar.time
            assert(!date.isFriday())
        }
    }

    @Test fun isSaturday() {
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 27)
            val date = calendar.time
            assert(date.isSaturday())
        }
        run {
            val calendar = Calendar.getInstance()
            calendar.set(2016, 1, 28)
            val date = calendar.time
            assert(!date.isSaturday())
        }
    }

    @Test fun compareTo() {
        run {
            Assert.assertTrue(1.day.ago < Dates.today)
        }
        run {
            Assert.assertTrue(1.day.since > Dates.today)
        }
    }

}
