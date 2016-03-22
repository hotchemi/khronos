package khronos

import org.junit.Assert
import java.util.*

fun assertEquals(expected: Date, actual: Date) {
    Assert.assertEquals(expected.toString(), actual.toString())
}

fun assertEquals(expected: Duration, actual: Duration) {
    Assert.assertEquals(expected, actual)
}