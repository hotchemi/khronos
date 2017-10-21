package khronos

import org.junit.Test

/**
 * Unit test for StringExtensions.kt.
 */
class StringExtensionsTest {

    @Test fun toDate() {
        assertEquals(
                expected = Dates.of(year = 1987, month = 6, day = 2, hour = 0, minute = 0, second = 0, millisecond = 0),
                actual = "1987-06-02".toDate("yyyy-MM-dd"))
    }

}
