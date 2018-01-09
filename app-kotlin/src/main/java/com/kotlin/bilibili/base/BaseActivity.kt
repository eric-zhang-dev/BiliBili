package com.kotlin.bilibili.base

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.kotlin.bilibili.MainApplication
import com.kotlin.bilibili.manager.AppManager


abstract class BaseActivity : AppCompatActivity() {
    lateinit var activity: Activity
    protected var app: MainApplication.Companion = MainApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        activity = this
        AppManager.appManager.addActivity(this)
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.appManager.finishActivity(this)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    protected abstract fun layout(): Int

    protected abstract fun initData()
}
