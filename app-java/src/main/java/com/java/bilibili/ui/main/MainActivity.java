package com.java.bilibili.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.java.bilibili.R;
import com.java.bilibili.base.BaseActivity;
import com.java.bilibili.ui.main.fragment.MainContentFragment;

import butterknife.BindView;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @BindView(R.id.drawer)
    NavigationView drawer;

    @Override
    protected int getLayout() {
        return R.layout.ui_activity_main;
    }

    @Override
    protected void initEventAndData() {
//        drawer.setNavigationItemSelectedListener(this);
        switchFragment(0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    private void switchFragment(int index) {
        Fragment fragment = null;
        String tag = null;
//        isShowHome = index == 0;
        switch (index) {
            case 0:
                tag = MainContentFragment.TAG;
                fragment = getSupportFragmentManager().findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = MainContentFragment.newInstance();
                }
                break;
            case 1:
//                tag = PicContentFragment.TAG;
//                fragment = getSupportFragmentManager().findFragmentByTag(tag);
//                if (fragment == null) {
//                    fragment = PicContentFragment.newInstance();
//                }
                break;
            default:
                return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main_right_fragment, fragment, tag).commit();
    }

}
