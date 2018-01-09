package com.d.m.system.ui.login.presenter

import com.kotlin.bilibili.base.RxPresenter
import com.kotlin.bilibili.ui.login.impl.LoginImpl


class LoginPresenter : RxPresenter<LoginImpl.View>(), LoginImpl.Presenter {
    override fun login(username: String, password: String) {
//        toSubscribe(RetrofitHelper.instance.api!!.login(username, password), object : Subscriber<LoginInfo>() {
//            override fun onNext(t: LoginInfo?) {
//                mView!!.initLoginInfo(t!!.data.section_id)
//            }
//
//            override fun onCompleted() {
//            }
//
//            override fun onError(e: Throwable?) {
//                Log.e("TAg", e.toString())
//            }
//
//        })
    }

}