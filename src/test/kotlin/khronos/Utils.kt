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

fun assertEquals(expected: Duration, actual: Duration) {
    Assert.assertEquals(expected, actual)
}
