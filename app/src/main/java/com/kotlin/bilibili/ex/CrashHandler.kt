package com.kotlin.bilibili.ex

import android.content.Context
import android.util.Log
import com.kotlin.bilibili.BuildConfig
import com.kotlin.bilibili.manager.AppManager
import com.kotlin.bilibili.utils.DateUtil
import com.kotlin.bilibili.utils.FileUtil
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.util.*

class CrashHandler : Thread.UncaughtExceptionHandler {
    companion object {
        val TAG = "CrashHandler"
        val DEBUG = BuildConfig.DEBUG
        private var INSTANCE: CrashHandler? = null
        private val CRASH_REPORTER_EXTENSION = ".txt"
        val instance: CrashHandler
            get() {
                if (INSTANCE == null)
                    INSTANCE = CrashHandler()
                return INSTANCE as CrashHandler
            }
    }

    private var mContext: Context? = null
    private var mDefaultHandler: Thread.UncaughtExceptionHandler? = null
    fun init(ctx: Context) {
        mContext = ctx
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(thread: Thread, ex: Throwable) {
        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler!!.uncaughtException(thread, ex)
        } else {
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
            }
            AppManager.appManager.AppExit(mContext!!)
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }

    private fun handleException(ex: Throwable?): Boolean {
        if (ex == null) {
            return true
        }
//        val msg = ex.localizedMessage
        saveCrashInfoToFile(ex)
        return true
    }

    private fun saveCrashInfoToFile(ex: Throwable): String? {
        val info = StringWriter()
        val printWriter = PrintWriter(info)
        ex.printStackTrace(printWriter)
        var cause: Throwable? = ex.cause
        while (cause != null) {
            cause.printStackTrace(printWriter)
            cause = cause.cause
        }
        val result = info.toString()
        printWriter.close()
        try {
            val timestamp = DateUtil.toPattern(Date(), DateUtil.DATETIMESTR)
            val fileName = "crash-" + timestamp + CRASH_REPORTER_EXTENSION
            FileUtil.writeFile(File(FileUtil.getDirectory("sdcard/app_error/"), fileName).absolutePath, result)
            return fileName
        } catch (e: Exception) {
            Log.e(CrashHandler.TAG, "an error occured while writing report file...", e)
        }

        return null
    }


}