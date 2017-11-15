package com.kotlin.bilibili.base

interface BasePresenter<in T : BaseView> {

    fun attachView(view: T)

    fun detachView()
}
