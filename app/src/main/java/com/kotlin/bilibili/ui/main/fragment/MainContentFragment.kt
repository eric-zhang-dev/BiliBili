package com.kotlin.bilibili.ui.main.fragment

import android.support.v4.app.Fragment
import android.widget.Toast
import com.kotlin.bilibili.R
import com.kotlin.bilibili.base.RxBaseFragment
import com.kotlin.bilibili.ui.main.fragment.adapter.HomePagerAdapter
import com.kotlin.bilibili.ui.main.fragment.impl.MainImpl
import com.kotlin.bilibili.ui.main.fragment.presenter.MainPresenter
import com.kotlin.bilibili.utils.Constants
import kotlinx.android.synthetic.main.ui_fragment_main_content.*
import java.util.ArrayList

/**
 * Created by Administrator on 2017/11/13 0013.
 */
class MainContentFragment : RxBaseFragment<MainPresenter>(), MainImpl.View {
    var TAG = "MainContentFragment"
    var mHomePagerAdapter: HomePagerAdapter? = null
    private var mFragments: ArrayList<Fragment>? = null
    fun newInstance(): MainContentFragment {
        return MainContentFragment()
    }

    override fun showLoading() {
    }

    override fun initUserInfo(data: String) {
    }

    override fun setPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun layout(): Int = R.layout.ui_fragment_main_content

    override fun initData() {
        val fm = childFragmentManager
        mFragments = ArrayList<Fragment>()
        mFragments!!.add(HomeFragment(Constants.HOME_TAG_9))
        mFragments!!.add(HomeFragment(Constants.HOME_TAG_1))
        mFragments!!.add(HomeFragment(Constants.HOME_TAG_2))
        mFragments!!.add(HomeFragment(Constants.HOME_TAG_3))
        mFragments!!.add(HomeFragment(Constants.HOME_TAG_4))
//        mFragments!!.add(HomeFragment(Constants.HOME_TAG_5))
//        mFragments!!.add(HomeFragment(Constants.HOME_TAG_6))
        mHomePagerAdapter = HomePagerAdapter(fm, mFragments!!, Constants.TAB_TITLES)
        viewpager.adapter = mHomePagerAdapter
        viewpager.offscreenPageLimit = mFragments!!.size
        tabs.setupWithViewPager(viewpager)
    }

    override fun showError(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    }
}