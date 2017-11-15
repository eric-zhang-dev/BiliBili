package com.kotlin.bilibili.ui.main.fragment.presenter

import com.kotlin.bilibili.base.RxPresenter
import com.kotlin.bilibili.http.RetrofitHelper
import com.kotlin.bilibili.http.ServerResponse
import com.kotlin.bilibili.modle.Data
import com.kotlin.bilibili.ui.main.fragment.impl.HomeImpl
import rx.Subscriber

/**
 * Created by Eric on 2017/11/13 0013.
 */
class HomePresenter : RxPresenter<HomeImpl.View>(), HomeImpl.Presenter {

    override fun getAnimaData(tid: Int, pn: Int) {
        toSubscribe(RetrofitHelper.instance.api!!.getAnimaList(tid, pn), object : Subscriber<ServerResponse<Data>>() {
            override fun onNext(t: ServerResponse<Data>?) {
                mView!!.initDataInfo(t!!.data!!)
            }

            override fun onCompleted() {
            }

            override fun onError(e: Throwable?) {
                mView!!.showError(e.toString())
            }

        })
    }

}