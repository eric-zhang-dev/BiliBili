package com.kotlin.bilibili.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class RxBaseFragment<T extends BasePresenter> extends Fragment implements BaseView{
    protected static final String TAG = RxBaseFragment.class.toString();
    protected T mPresenter;
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
//    private Unbinder mUnBinder;
    protected boolean isInited = false;

    @Override
    public void onAttach(Context context) {
        mActivity = getActivity();
        mContext = context;
        super.onAttach(context);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(layout(), null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = setPresenter();
        mPresenter.attachView(this);
//        mUnBinder = ButterKnife.bind(this, view);
        if (savedInstanceState == null) {
            if (!isHidden()) {
                isInited = true;
                initData();
            }
        } else {
            /*if (!isSupportHidden()) {
                isInited = true;
                initEventAndData();
            }*/
        }
    }

    protected abstract T setPresenter();

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!isInited && !hidden) {
            isInited = true;
            initData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        mUnBinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }


    public void useNightMode(boolean isNight) {

    }
    protected abstract int layout();

    protected abstract void initData();
}
