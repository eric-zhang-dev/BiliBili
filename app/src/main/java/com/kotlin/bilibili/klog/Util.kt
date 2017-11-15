package com.kotlin.bilibili.klog

import android.text.TextUtils
import android.util.Log
import com.kotlin.bilibili.BuildConfig


object Util {
    fun isEmpty(line: String): Boolean {
        return TextUtils.isEmpty(line) || line == "\n" || line == "\t" || TextUtils.isEmpty(line.trim { it <= ' ' })
    }

    fun printLine(tag: String, isTop: Boolean) {
        if (!BuildConfig.DEBUG) return
        if (isTop) {
            Log.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════")
        } else {
            Log.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════")
        }
    }
}
