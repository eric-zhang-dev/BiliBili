package com.kotlin.bilibili.ui.main.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.bilibili.R
import com.kotlin.bilibili.base.RxBaseFragment
import com.kotlin.bilibili.modle.Archives
import com.kotlin.bilibili.modle.Data
import com.kotlin.bilibili.ui.main.fragment.adapter.HomeAdapter
import com.kotlin.bilibili.ui.main.fragment.impl.HomeImpl
import com.kotlin.bilibili.ui.main.fragment.presenter.HomePresenter
import com.kotlin.bilibili.widget.LoadMoreRecyclerView
import kotlinx.android.synthetic.main.ui_fragment_home_list.*

/**
 * Created by Eric on 2017/11/13 0013.
 */
class HomeFragment(tag: Int) : RxBaseFragment<HomePresenter>(), HomeImpl.View, LoadMoreRecyclerView.OnLoadMoreLinstener, SwipeRefreshLayout.OnRefreshListener, HomeAdapter.OnItemClickListener {
    var tid: Int = 24
    var pn: Int = 0
    var mAdapter: HomeAdapter? = null
    var isRefresh = true
    override fun layout(): Int = R.layout.ui_fragment_home_list
    override fun initDataInfo(data: Data) {
        swiperefresh_layout.isRefreshing = false
        mAdapter!!.addDynamicVideo(data.archives)
    }

    override fun onLoadMore() {
        isRefresh = false
        pn++
        recycler_view.setLoading(false)
        mPresenter.getAnimaData(tid, pn)
    }

    override fun onRefresh() {
        isRefresh = true
        pn = 0
        recycler_view.setEnableLoadMore(true)
        recycler_view.setLodingViewState(LoadMoreRecyclerView.STATE_REFRESHING)
        mPresenter.getAnimaData(tid, pn)
    }

    override fun showLoading() {
    }

    override fun showError(msg: String) {
    }

    override fun setPresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun onVideoItemClick(d: Archives) {
    }

    override fun initData() {
        mPresenter.getAnimaData(tid, pn)
        recycler_view.layoutManager = GridLayoutManager(context, 2)
        mAdapter = HomeAdapter(mContext, 0)
        recycler_view.adapter = mAdapter
        mAdapter!!.setmOnItemClickListener(this)
        recycler_view.setOnLoadMoreLinstener(this)
        swiperefresh_layout.setOnRefreshListener(this)
        swiperefresh_layout.setColorSchemeResources(R.color.colorPrimary)
    }

}