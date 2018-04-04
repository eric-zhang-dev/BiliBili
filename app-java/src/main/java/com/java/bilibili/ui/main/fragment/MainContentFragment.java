package com.java.bilibili.ui.main.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.java.bilibili.R;
import com.java.bilibili.base.RxBaseFragment;
import com.java.bilibili.ui.main.fragment.adapter.HomePagerAdapter;
import com.java.bilibili.ui.main.fragment.impl.MainImpl;
import com.java.bilibili.ui.main.fragment.presenter.MainPresenter;

import java.lang.reflect.Field;
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
    @BindView(R.id.bottom_navi_view)
    BottomNavigationView bottomNavigationView;
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
        disableShiftMode(bottomNavigationView);
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

    String[] t = {"A", "B", "C", "D", "E", "F", "G"};

    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
