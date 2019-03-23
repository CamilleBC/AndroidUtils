package com.camillebc.androidutils.extensions

import android.content.Context
import android.content.pm.PackageManager

fun Context.grantPermission(permission: String) {
    if (this.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {

    }
}