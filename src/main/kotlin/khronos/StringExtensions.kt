package khronos;

import java.text.SimpleDateFormat

fun String.dateFromFormat(format: String) = SimpleDateFormat(format).parse(this)
