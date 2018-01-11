package com.java.bilibili.ui.main.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.java.bilibili.R;
import com.java.bilibili.base.RxBaseFragment;
import com.java.bilibili.modle.Data;
import com.java.bilibili.ui.main.fragment.adapter.HomeAdapter;
import com.java.bilibili.ui.main.fragment.impl.HomeImpl;
import com.java.bilibili.ui.main.fragment.presenter.HomePresenter;
import com.java.bilibili.widget.LoadMoreRecyclerView;

import butterknife.BindView;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class HomeFragment extends RxBaseFragment<HomePresenter> implements HomeImpl.View, LoadMoreRecyclerView.OnLoadMoreLinstener, SwipeRefreshLayout.OnRefreshListener, HomeAdapter.OnItemClickListener {
    @BindView(R.id.swiperefresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_view)
    LoadMoreRecyclerView recyclerView;
    int tid = 24;
    int pn = 0;
    private String tag;
    private HomeAdapter mAdapter;
    private boolean isRefresh = true;

    public static HomeFragment newInstance(String tag) {
        Bundle args = new Bundle();
        args.putString("TAG", tag);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void initDataInfo(Data data) {
        swipeRefreshLayout.setRefreshing(false);
        mAdapter.addDynamicVideo(data.getArchives());
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layout() {
        return R.layout.ui_fragment_home_list;
    }

    @Override
    protected void initData() {
        tag = getArguments().getString("TAG");
        mPresenter.getAnimaData(tid, pn);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new HomeAdapter(mContext, 0);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setmOnItemClickListener(this);
        recyclerView.setOnLoadMoreLinstener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
    }

    @Override
    public void onLoadMore() {
        isRefresh = false;
        pn++;
        recyclerView.setLoading(false);
        mPresenter.getAnimaData(tid, pn);
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        pn = 0;
        recyclerView.setEnableLoadMore(true);
        recyclerView.setLoadingViewState(LoadMoreRecyclerView.STATE_REFRESHING);
        mPresenter.getAnimaData(tid, pn);
    }

    @Override
    public void onVideoItemClick(Data.Archives aid) {

    }
}
