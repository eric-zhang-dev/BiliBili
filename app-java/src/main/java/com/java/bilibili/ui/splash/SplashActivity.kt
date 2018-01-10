package com.kotlin.bilibili.ui.splash

import android.content.Intent
import android.view.View
import com.kotlin.bilibili.R
import com.kotlin.bilibili.base.BaseActivity
import com.kotlin.bilibili.ui.main.MainActivity
import kotlinx.android.synthetic.main.bili_app_layout_login_action_button.*

class SplashActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            btn_register -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    override fun layout(): Int = R.layout.ui_activity_login

    override fun initData() {
        btn_register.setOnClickListener(this)
    }
}