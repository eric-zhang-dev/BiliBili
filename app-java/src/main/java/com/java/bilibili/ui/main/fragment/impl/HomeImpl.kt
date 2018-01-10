package com.kotlin.bilibili.ui.main.fragment.impl

import com.kotlin.bilibili.base.BasePresenter
import com.kotlin.bilibili.base.BaseView
import com.kotlin.bilibili.modle.Data

/**
 * Created by Eric on 2017/11/13 0013.
 */
interface HomeImpl {
    interface View : BaseView {
        fun initDataInfo(data:Data)
    }

    interface Presenter : BasePresenter<View> {
        fun getAnimaData(tid: Int,pn:Int)
    }
}