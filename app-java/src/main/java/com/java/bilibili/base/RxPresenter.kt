package com.kotlin.bilibili.base

import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by Eric.zhang on 2018/1/9.
 */
open class RxPresenter<T : BaseView> : BasePresenter<T> {

    protected var mView: T? = null
    private var mCompositeSubscription: CompositeSubscription? = null


    protected fun <T> toSubscribe(o: Observable<T>, s: Subscriber<T>) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s)
        addSubscrebe(s)
    }


    private fun unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription!!.unsubscribe()
        }
    }

    private fun addSubscrebe(subscription: Subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = CompositeSubscription()
        }
        mCompositeSubscription!!.add(subscription)
    }

    override fun attachView(view: T) {
        this.mView = view
    }

    override fun detachView() {
        this.mView = null
        unSubscribe()
    }
}