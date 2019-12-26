package khronos

import org.junit.Assert
import java.text.SimpleDateFormat
import java.util.*

internal val iso8601: SimpleDateFormat by lazy {
    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
}

fun assertEquals(expected: Date, actual: Date) {
    Assert.assertEquals(iso8601.format(expected), iso8601.format(actual))
}

fun assertVeryClose(maxOffset: Int = 200, from: Date, to: Date) {
    Assert.assertTrue(
            String.format("There is more than %d ms between %s and %s", maxOffset, iso8601.format(from), iso8601.format(to)),
            Math.abs(from.time - to.time) <= maxOffset)
}

fun assertEquals(expected: Duration, actual: Duration) {
    Assert.assertEquals(expected, actual)
}
