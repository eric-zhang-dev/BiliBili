package com.kotlin.bilibili.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {
    lateinit var mView: View
    lateinit var mActivity: Activity
    lateinit var mContext: Context
    private var isInited = false
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(layout, null)
        return mView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mActivity = activity
        mContext = context!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            if (!isHidden) {
                isInited = true
                initData()
            }
        } else {
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!isInited && !hidden) {
            isInited = true
            initData()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    protected abstract val layout: Int

    protected abstract fun initData()

    companion object {
        protected val TAG = BaseFragment::class.java.toString()
    }
}