package com.camillebc.androidutils.extensions

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager

enum class BatteryStatus { DISCHARGING, CHARGING }

fun BatteryManager.getBatteryStatus(context: Context): BatteryStatus {
    val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { intentFilter ->
        context.registerReceiver(null, intentFilter)
    }
    val status: Int = batteryStatus?.getIntExtra(android.os.BatteryManager.EXTRA_STATUS, -1) ?: -1

    if (status == android.os.BatteryManager.BATTERY_STATUS_CHARGING
        || status == android.os.BatteryManager.BATTERY_STATUS_FULL) {
        return BatteryStatus.CHARGING
    }
    return BatteryStatus.DISCHARGING
}
