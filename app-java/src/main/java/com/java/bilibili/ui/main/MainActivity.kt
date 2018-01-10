package com.kotlin.bilibili.ui.main

import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.MenuItem
import com.kotlin.bilibili.R
import com.kotlin.bilibili.R.id.*
import com.kotlin.bilibili.base.BaseActivity
import com.kotlin.bilibili.ui.main.fragment.MainContentFragment
import com.kotlin.bilibili.utils.Utils
import kotlinx.android.synthetic.main.ui_activity_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun layout(): Int = R.layout.ui_activity_main

    override fun initData() {
        drawer.setNavigationItemSelectedListener(this)
        switchFragment(0)
    }

    private fun switchFragment(index: Int) {
        var fragment: Fragment? = null
        var tag: String? = null
//        isShowHome = index == 0
        when (index) {
            0 -> {
                tag = "MainContentFragment"
                fragment = supportFragmentManager.findFragmentByTag(tag)
                if (fragment == null) {
                    fragment = MainContentFragment()
                }
            }
            1 -> {
//                tag = PicContentFragment.TAG
//                fragment = supportFragmentManager.findFragmentByTag(tag)
//                if (fragment == null) {
//                    fragment = PicContentFragment.newInstance()
//                }
            }
            else -> return
        }
        supportFragmentManager.beginTransaction().replace(R.id.main_right_fragment, fragment, tag).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            nav_home -> {

            }
            nav_histories -> {

            }
            nav_offline_manager -> {

            }
            nav_favorites -> {

            }
            nav_following -> {

            }
            nav_watch_later -> {

            }
            upper_center -> {

            }
            nav_live_center -> {

            }
            nav_vip -> {

            }
            nav_unicom_service -> {

            }
        }
        return true
    }

    var mkeyTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (drawer_layout.isDrawerOpen(drawer)) {
            drawer_layout.closeDrawers()
            return false
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mkeyTime > 1200) {
                mkeyTime = System.currentTimeMillis()
            } else {
                Utils.exitApp(this)
            }
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

    fun openDrawer() {
        drawer_layout.openDrawer(drawer)
    }
}
