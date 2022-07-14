package com.bs.bs_test.utils

import android.os.Build
import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

class dateUtils {
    fun getCustomDate(d: String): String? {
        var newDate: String? = null
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val sdf1 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf1.timeZone = TimeZone.getTimeZone("UTC")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val instant = Instant.now()
            newDate = instant.toString()
            Log.d("dateo", d)
            Log.d("daten", newDate)
        }
        try {
            val startDate = sdf1.parse(newDate)
            val endDate = sdf.parse(d)
            Log.d("daten", endDate.toString())
            var different = startDate.time - endDate.time
            val secondsInMilli: Long = 1000
            val minutesInMilli = secondsInMilli * 60
            val hoursInMilli = minutesInMilli * 60
            val daysInMilli = hoursInMilli * 24
            val elapsedDays = different / daysInMilli
            different = different % daysInMilli
            val elapsedHours = different / hoursInMilli
            different = different % hoursInMilli
            val elapsedMinutes = different / minutesInMilli
            different = different % minutesInMilli
            val elapsedSeconds = different / secondsInMilli
            return if (startDate.year != endDate.year) {
                val dateRe = endDate.toString()
                dateRe.substring(4, 10) + "," + dateRe.substring(29, dateRe.length)
            } else if (elapsedDays > 29) {
                val dateRe = endDate.toString()
                dateRe.substring(4, 11)
            } else if (elapsedDays > 0) {
                "$elapsedDays d ago"
            } else if (elapsedHours > 0) {
                "$elapsedHours h ago"
            } else if (elapsedMinutes > 0) {
                "$elapsedMinutes min ago"
            } else {
                "$elapsedSeconds sec ago"
            }
//            return elapsedSeconds.toString()
        } catch (e: ParseException) {
            e.printStackTrace()
            Log.d("elapsedSeconds",e.toString())
        }
        return "elapsedSeconds"
    }
}