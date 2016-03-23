package khronos

import org.junit.Test
import java.util.*

/**
 * Unit test for StringExtensions.kt.
 */
class StringExtensionsTest {

    @Test fun toDate() {
        val expected = Calendar.getInstance().apply {
            set(Calendar.YEAR, 1987)
            set(Calendar.MONTH, 5)
            set(Calendar.DATE, 2)
            set(Calendar.HOUR, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }.time
        assertEquals(expected = expected, actual = "1987-06-02".toDate("yyyy-MM-dd"))
    }

}
