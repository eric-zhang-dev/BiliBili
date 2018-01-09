package com.kotlin.bilibili.manager

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.Stack

class AppManager {
    companion object {
        private var activityStack: Stack<Activity>? = null
        private var instance: AppManager? = null

        val appManager: AppManager
            get() {
                if (instance == null) {
                    instance = AppManager()
                }
                return instance as AppManager
            }
    }

    fun addActivity(activity: Activity) {
        if (AppManager.activityStack == null) {
            AppManager.activityStack = Stack<Activity>()
        }
        AppManager.activityStack!!.add(activity)
    }

    fun currentActivity(): Activity? {
        if (AppManager.activityStack == null || AppManager.activityStack!!.isEmpty()) {
            return null
        }
        val activity = AppManager.activityStack!!.lastElement()
        return activity
    }

    fun findActivity(cls: Class<*>): Activity? {
        var activity: Activity? = null
        for (aty in AppManager.activityStack!!) {
            if (aty.javaClass == cls) {
                activity = aty
                break
            }
        }
        return activity
    }

    fun finishActivity() {
        val activity = AppManager.activityStack!!.lastElement()
        finishActivity(activity)
    }

    fun finishActivity(activity: Activity?) {
        var a = activity
        if (a != null) {
            AppManager.activityStack!!.remove(a)
            a.finish()
//            a = null
        }
    }

    fun finishActivity(cls: Class<*>) {
        for (activity in AppManager.activityStack!!) {
            if (activity.javaClass == cls) {
                finishActivity(activity)
            }
        }
    }

    fun finishOthersActivity(cls: Class<*>) {
        for (activity in AppManager.activityStack!!) {
            if (activity.javaClass != cls) {
                finishActivity(activity)
            }
        }
    }

    fun finishAllActivity() {
        var i = 0
        val size = AppManager.activityStack!!.size
        while (i < size) {
            if (null != AppManager.activityStack!![i]) {
                AppManager.activityStack!![i].finish()
            }
            i++
        }
        AppManager.activityStack!!.clear()
    }

    fun AppExit(context: Context) {
        try {
            finishAllActivity()
            val activityMgr = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityMgr.killBackgroundProcesses(context.packageName)
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(0)
        } catch (e: Exception) {
            System.exit(0)
        }

    }

}