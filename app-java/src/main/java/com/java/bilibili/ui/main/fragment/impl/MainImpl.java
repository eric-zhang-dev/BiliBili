package com.java.bilibili.ui.main.fragment.impl;

import com.java.bilibili.base.BasePresenter;
import com.java.bilibili.base.BaseView;

public class MainImpl {
    public interface View extends BaseView {
        void initUserInfo(String data);
    }

    public interface Presenter extends BasePresenter<View> {
        void getUserInfo(String id);
    }
}
