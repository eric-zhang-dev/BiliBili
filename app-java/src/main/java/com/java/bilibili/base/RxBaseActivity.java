package com.java.bilibili.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kotlin.bilibili.base.BasePresenter;
import com.kotlin.bilibili.base.BaseView;
import com.kotlin.bilibili.manager.AppManager;


public abstract class RxBaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected String TAG = this.getClass().getSimpleName();
    protected T mPresenter;
    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        mPresenter = setPresenter();
        mActivity = this;
        AppManager.Companion.getAppManager().addActivity(mActivity);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initData();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.Companion.getAppManager().finishActivity(mActivity);
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    protected abstract int layout();

    protected abstract T setPresenter();

    protected abstract void initData();
}
