package com.java.bilibili.ui.main;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.java.bilibili.R;
import com.java.bilibili.base.BaseActivity;
import com.java.bilibili.manager.AppManager;
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

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (drawer_layout.isDrawerOpen(drawer)) {
//            drawer_layout.closeDrawers();
//            return false;
//        }
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_BACK:
//                new MaterialDialog.Builder(this)
//                        .title("退出")
//                        .content("是否退出app")
//                        .positiveText("是")
//                        .negativeText("否").onAny(new MaterialDialog.SingleButtonCallback() {
//                    @Override
//                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                        switch (which) {
//                            case POSITIVE:
//                                AppManager.getAppManager().AppExit(mActivity);
//                                break;
//                            case NEGATIVE:
//                                break;
//                        }
//                    }
//                })
//                        .show();
//                return false;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
