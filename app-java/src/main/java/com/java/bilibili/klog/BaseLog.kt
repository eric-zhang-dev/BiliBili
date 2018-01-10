package com.kotlin.bilibili.klog


import android.util.Log


object BaseLog {
    fun printDefault(type: Int, tag: String, msg: String) {

        var index = 0
        val maxLength = 4000
        val countOfSub = msg.length / maxLength

        if (countOfSub > 0) {
            for (i in 0..countOfSub - 1) {
                val sub = msg.substring(index, index + maxLength)
                printSub(type, tag, sub)
                index += maxLength
            }
            printSub(type, tag, msg.substring(index, msg.length))
        } else {
            printSub(type, tag, msg)
        }
    }

    private fun printSub(type: Int, tag: String, sub: String) {
        when (type) {
            KLog.V -> Log.v(tag, sub)
            KLog.D -> Log.d(tag, sub)
            KLog.I -> Log.i(tag, sub)
            KLog.W -> Log.w(tag, sub)
            KLog.E -> Log.e(tag, sub)
            KLog.A -> Log.wtf(tag, sub)
        }
    }
}
