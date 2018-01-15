package com.java.bilibili.ui.main.fragment.presenter;

import com.java.bilibili.base.RxPresenter;
import com.java.bilibili.http.RetrofitHelper;
import com.java.bilibili.http.ServerResponse;
import com.java.bilibili.modle.Data;
import com.java.bilibili.ui.main.fragment.impl.HomeImpl;
import com.java.bilibili.utils.RxUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class HomePresenter extends RxPresenter<HomeImpl.View> implements HomeImpl.Presenter {
    @Override
    public void getAnimaData(int tid, int pn) {
        RetrofitHelper.getInstance().getApi().getAnima(tid + "", pn + "").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new Observer<ServerResponse<Data>>() {
            @Override
            public void onSubscribe(Disposable d) {
                addSubscribe(d);
            }

            @Override
            public void onNext(ServerResponse<Data> t) {
                mView.initDataInfo(t.getData());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
//        addSubscribe(RetrofitHelper.getInstance().getApi().getAnima(tid+"",pn+"").compose()
//                .subscribeWith()
//        );
//        toSubscribe(RetrofitHelper.getInstance().getApi().getAnimaList(tid + "", pn + ""), new Subscriber<ServerResponse<Data>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(ServerResponse<Data> t) {
//                mView.initDataInfo(t.getData());
//            }
//        });
    }
}
