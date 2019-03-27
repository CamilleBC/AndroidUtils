package com.camillebc.androidutils.extensions

import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

const val CALENDAR_SEP = " | "

fun Calendar.combinedFormat(): SimpleDateFormat = SimpleDateFormat("EEE, d MMM yyyy" + CALENDAR_SEP + "HH:mm")
fun Calendar.combinedStrings(dateString: String, timeString: String) = StringBuilder()
    .append(dateString)
    .append(CALENDAR_SEP)
    .append(timeString)
    .toString()
fun Calendar.dateFormat(): SimpleDateFormat = SimpleDateFormat("EEE, d MMM yyyy")
fun Calendar.dateString(): String = this.dateFormat().format(this.time).capitalize()
fun Calendar.dateStringToDate(dateString: String) = dateFormat().parse(dateString)
fun Calendar.stringToDate(dateString: String, timeString: String) = combinedFormat().parse(combinedStrings(dateString, timeString))
fun Calendar.timeFormat(): SimpleDateFormat = SimpleDateFormat("HH:mm")
fun Calendar.timeString(): String = this.timeFormat().format(this.time).capitalize()
fun Calendar.timeStringToDate(timeString: String) = timeFormat().parse(timeString)
