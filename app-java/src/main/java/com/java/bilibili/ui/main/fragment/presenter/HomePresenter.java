package com.java.bilibili.ui.main.fragment.presenter;

import com.java.bilibili.base.RxPresenter;
import com.java.bilibili.http.RetrofitHelper;
import com.java.bilibili.http.ServerResponse;
import com.java.bilibili.modle.Data;
import com.java.bilibili.ui.main.fragment.impl.HomeImpl;

import rx.Subscriber;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class HomePresenter extends RxPresenter<HomeImpl.View> implements HomeImpl.Presenter {
    @Override
    public void getAnimaData(int tid, int pn) {
        toSubscribe(RetrofitHelper.getInstance().getApi().getAnimaList(tid + "", pn + ""), new Subscriber<ServerResponse<Data>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ServerResponse<Data> t) {
                mView.initDataInfo(t.getData());
            }
        });
    }
}
