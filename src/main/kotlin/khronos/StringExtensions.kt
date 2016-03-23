package khronos;

import java.text.SimpleDateFormat

fun String.toDate(format: String) = SimpleDateFormat(format).parse(this)
