package khronos

import org.junit.Test
import java.util.*

/**
 * Unit test for [Duration].
 */
class DurationTest {

    @Test fun ago() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        val yesterday = calendar.time
        assertEquals(expected = yesterday, actual = 1.days.ago)
    }

    @Test fun later() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.YEAR, 5)
        val fiveYearsLater = calendar.time
        assertEquals(expected = fiveYearsLater, actual = 5.years.since)
    }

    /**Test that subtracting a month results in the correct change to the date.*/
    @Test fun subtractMonth() {
        val n = Dates.today + 5.months
        val dayNumber = n.dayByCalendar()
        val monthNumber = n.monthByCalendar()
        val monthAgo = n - 1.month
        assert(monthAgo.dayByCalendar() == dayNumber)
        val delta = (if (monthNumber == 0) 11 else monthNumber - 1)
        assert(monthAgo.monthByCalendar() == delta)
    }

}
