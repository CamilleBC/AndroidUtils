package com.camillebc.androidutils.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

enum class InternetStatus { OFFLINE, RESTRICTED, UNRESTRICTED }

fun ConnectivityManager.getConnectivityStatus(context: Context): InternetStatus {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (connectivityManager.activeNetworkInfo == null )return InternetStatus.OFFLINE
    val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if ( networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)){
        if ( networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)){
            return InternetStatus.UNRESTRICTED
        }
        return InternetStatus.RESTRICTED
    }
    return InternetStatus.OFFLINE
}
