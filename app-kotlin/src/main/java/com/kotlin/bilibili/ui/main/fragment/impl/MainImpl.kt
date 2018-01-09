package com.kotlin.bilibili.ui.main.fragment.impl

import com.kotlin.bilibili.base.BasePresenter
import com.kotlin.bilibili.base.BaseView

/**
 * Created by Administrator on 2017/11/13 0013.
 */
interface MainImpl {
    interface View : BaseView {
        fun initUserInfo(data: String)
    }

    interface Presenter : BasePresenter<View> {
        fun getUserInfo(id: String)
    }
}