package khronos

import org.junit.Test
import java.util.*

/**
 * Unit test for [Dates].
 */
class DatesTest {

    @Test fun now() {
        assertVeryClose(from = Date(), to = Dates.today)
    }

    @Test fun today() {
        assertVeryClose(from = Date(), to = Dates.today)
    }

    @Test fun tomorrow() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        assertVeryClose(from = calendar.time, to = Dates.tomorrow)
    }

    @Test fun yesterday() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        assertVeryClose(from = calendar.time, to = Dates.yesterday)
    }

    @Test fun dateYear() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, 1990)
        assertVeryClose(from = calendar.time, to = Dates.of(year = 1990))
    }

    @Test fun dateMonth() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, 0)
        assertVeryClose(from = calendar.time, to = Dates.of(month = 1))
    }

    @Test fun dateDay() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DATE, 21)
        assertVeryClose(from = calendar.time, to = Dates.of(day = 21))
    }

    @Test fun dateHour() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 4)
        assertVeryClose(from = calendar.time, to = Dates.of(hour = 4))
    }

    @Test fun dateMinute() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MINUTE, 30)
        assertVeryClose(from = calendar.time, to = Dates.of(minute = 30))
    }

    @Test fun dateSecond() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.SECOND, 10)
        assertVeryClose(from = calendar.time, to = Dates.of(second = 10))
    }

}
