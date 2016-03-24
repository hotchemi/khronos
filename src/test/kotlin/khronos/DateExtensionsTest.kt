package khronos

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Unit test for DateExtensions.kt.
 */
class DateExtensionsTest {

    @Test fun plus() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.WEEK_OF_MONTH, 1)
        val nextWeek = calendar.time
        assertEquals(expected = nextWeek, actual = Dates.today + 1.week)
    }

    @Test fun minus() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -2)
        val dayBeforeYesterday = calendar.time
        assertEquals(expected = dayBeforeYesterday, actual = Dates.today - 2.days)
    }

    @Test fun with() {
        run {
            val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 0, second = 0)
            assertEquals(
                    expected = Dates.of(year = 1990, month = 6, day = 2, hour = 12, minute = 0, second = 0),
                    actual = date.with(year = 1990))
        }
        run {
            val date = Dates.of(year = 1987, month = 6, day = 2, hour = 12, minute = 0, second = 0)
            assertEquals(
                    expected = Dates.of(year = 1987, month = 6, day = 9, hour = 12, minute = 0, second = 0),
                    actual = date.with(weekday = 2))
        }
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
