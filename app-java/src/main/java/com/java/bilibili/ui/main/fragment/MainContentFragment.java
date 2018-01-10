package com.java.bilibili.ui.main.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.java.bilibili.R;
import com.java.bilibili.base.RxBaseFragment;
import com.java.bilibili.ui.main.fragment.adapter.HomePagerAdapter;
import com.java.bilibili.ui.main.fragment.impl.MainImpl;
import com.java.bilibili.ui.main.fragment.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class MainContentFragment extends RxBaseFragment<MainPresenter> implements MainImpl.View {
    public static String TAG = "MainContentFragment";
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabs;
    HomePagerAdapter mHomePagerAdapter;
    private List<Fragment> mFragments;
    @Override
    public void showLoading() {

    }
    public static MainContentFragment newInstance() {
        MainContentFragment fragment = new MainContentFragment();
        return fragment;
    }
    @Override
    public void showError(String msg) {

    }

    @Override
    public void initUserInfo(String data) {

    }

    @Override
    protected MainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int layout() {
        return R.layout.ui_fragment_main_content;
    }

    @Override
    protected void initData() {
        FragmentManager fm = getChildFragmentManager();
        mFragments = new ArrayList<>();

        mFragments.add(HomeFragment.newInstance("1"));
        mFragments.add(HomeFragment.newInstance("2"));
        mFragments.add(HomeFragment.newInstance("3"));
        mFragments.add(HomeFragment.newInstance("4"));
        mFragments.add(HomeFragment.newInstance("5"));
        mFragments.add(HomeFragment.newInstance("6"));
        mFragments.add(HomeFragment.newInstance("7"));


        viewPager.setAdapter(mHomePagerAdapter = new HomePagerAdapter(fm, mFragments, t));
        viewPager.setOffscreenPageLimit(mFragments.size());
        tabs.setupWithViewPager(viewPager);

    }
    String[] t = {"A","B","C","D","E","F","G"};
}
