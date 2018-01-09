package com.kotlin.bilibili

import android.app.Application
import android.util.Log
import com.kotlin.bilibili.ex.DelegatesExt
import com.tencent.smtt.sdk.QbSdk

class MainApplication : Application() {
    companion object {
        internal var instance: MainApplication by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
//        var cb = object : QbSdk.PreInitCallback {
//            override fun onCoreInitFinished() {
//                Log.e("onCoreInitFinished", "onCoreInitFinished")
//            }
//
//            override fun onViewInitFinished(p0: Boolean) {
//                Log.e("onViewInitFinished", "onViewInitFinished")
//            }
//        }
//        QbSdk.initX5Environment(this, cb)
//        CrashHandler.instance.init(instance)
    }
}