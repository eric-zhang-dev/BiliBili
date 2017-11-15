package com.kotlin.bilibili.ui.login.impl

import com.kotlin.bilibili.base.BasePresenter
import com.kotlin.bilibili.base.BaseView

interface LoginImpl {
    interface View : BaseView {
        fun initLoginInfo(data: String)
    }

    interface Presenter : BasePresenter<View> {
        fun login(username: String, password: String)
    }
}