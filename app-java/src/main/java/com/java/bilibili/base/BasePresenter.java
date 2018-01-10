package com.java.bilibili.base;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
