@file:JvmName("DateUtils")

package xyz.kurozero.notes.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(date: Date?): String {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
    return dateFormat.format(date)
}