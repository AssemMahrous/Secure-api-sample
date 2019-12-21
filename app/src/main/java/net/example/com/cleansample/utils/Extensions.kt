package net.example.com.cleansample.utils

import net.example.com.cleansample.BuildConfig

fun isDevelopmentDebug(block: () -> Unit) {
    if (BuildConfig.DEBUG && BuildConfig.FLAVOR.contains("develop", ignoreCase = true)) {
        block.invoke()
    }
}
