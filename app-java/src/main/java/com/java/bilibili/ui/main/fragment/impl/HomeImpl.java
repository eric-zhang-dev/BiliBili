package com.java.bilibili.ui.main.fragment.impl;

import com.java.bilibili.base.BasePresenter;
import com.java.bilibili.base.BaseView;
import com.java.bilibili.modle.Data;


public class HomeImpl {
    public interface View extends BaseView {
        void initDataInfo(Data data);
    }

    public interface Presenter extends BasePresenter<View> {
        void getAnimaData(int tid, int pn);
    }
}
