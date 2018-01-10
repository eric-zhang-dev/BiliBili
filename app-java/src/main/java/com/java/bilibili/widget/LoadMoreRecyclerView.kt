package com.kotlin.bilibili.widget

import android.content.Context
import android.support.annotation.IntRange
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.kotlin.bilibili.R
import kotlinx.android.synthetic.main.recyclerview_load_more_item.view.*

class LoadMoreRecyclerView : RecyclerView {
    private var mIsLoading = false
    private var mEnableLoadMore = true
    private var mShowLoadingView = true

    private var mAdapter: LoadMoreAdapter? = null
    private var mLoadMoreViewText: String? = null

    private var mShowProgressBar = true

    private var mOnLoadMoreLinstener: OnLoadMoreLinstener? = null
    private var mOnLoadMoreViewClickListener: OnLoadMoreViewClickListener? = null

    private var mLoadViewClickable: Boolean = false

    private var mCurrentLoadViewState: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        mLoadMoreViewText = resources.getString(R.string.loading)
        mShowProgressBar = true
        mLoadViewClickable = false
        mCurrentLoadViewState = STATE_REFRESHING
        addOnScrollListener(LoadMoreScrollLinstener())
    }


    override fun setAdapter(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?) {
        if (adapter == null) {
            return
        }
        mAdapter = LoadMoreAdapter(adapter)
        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                mAdapter!!.notifyDataSetChanged()
            }

            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                mAdapter!!.notifyItemRangeChanged(positionStart, itemCount)
            }

            override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
                mAdapter!!.notifyItemRangeChanged(positionStart, itemCount, payload)
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                mAdapter!!.notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                mAdapter!!.notifyItemRangeRemoved(positionStart, itemCount)
            }

            override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                mAdapter!!.notifyItemMoved(fromPosition, toPosition)
            }
        })
        super.setAdapter(mAdapter)
    }

    fun setEnableLoadMore(enable: Boolean) {
        if (mEnableLoadMore == enable) {
            return
        }
        mEnableLoadMore = enable
    }

    private fun setLoadView(text: String, showProgress: Boolean) {
        mLoadMoreViewText = text
        mShowProgressBar = showProgress
        if (layoutManager.childCount == 0 || !mShowLoadingView || mAdapter == null) {
            return
        }
        mAdapter!!.notifyItemChanged(mAdapter!!.itemCount - 1)
    }

    fun setLodingViewState(@IntRange(from = 0, to = 5) state: Int) {
        if (mCurrentLoadViewState == state) {
            return
        }
        mCurrentLoadViewState = state
        when (state) {
            STATE_REFRESHING -> {
                mLoadViewClickable = false
                setLoadView(resources.getString(R.string.loading), true)
            }
            STATE_FAIL -> {
                mLoadViewClickable = false
                setLoadView(resources.getString(R.string.load_error), false)
            }
            STATE_RETRY -> {
                mLoadViewClickable = true
                setLoadView(resources.getString(R.string.load_failed_with_click), false)
            }
            STATE_NO_MORE -> {
                mLoadViewClickable = false
                setLoadView(resources.getString(R.string.no_data_tips), false)
            }
            STATE_NO_DATA -> {
                mLoadViewClickable = false
                setLoadView(resources.getString(R.string.type_no_data), false)
            }
        }
    }

    fun setShowLoadingView(show: Boolean) {
        if (mShowLoadingView == show) {
            return
        }
        mShowLoadingView = show
        if (layoutManager.childCount == 0 || mAdapter == null) {
            return
        }
        if (mShowLoadingView) {
            mAdapter!!.notifyItemInserted(mAdapter!!.itemCount - 1)
        } else {
            mAdapter!!.notifyItemRemoved(mAdapter!!.itemCount)
        }
    }

    fun setOnLoadMoreLinstener(linstener: OnLoadMoreLinstener) {
        mOnLoadMoreLinstener = linstener
    }

    fun setOnLoadMoreViewClickListener(listener: OnLoadMoreViewClickListener) {
        mOnLoadMoreViewClickListener = listener
    }

    fun getItemViewType(position: Int): Int {
        if (mAdapter == null) {
            return TYPE_LOAD_MORE
        } else {
            return mAdapter!!.getItemViewType(position)
        }
    }

    fun setLoading(loading: Boolean) {
        mIsLoading = loading
    }

    inner class LoadMoreAdapter internal constructor(private val mInternalAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            if (viewType == TYPE_LOAD_MORE) {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_load_more_item, parent, false)
                return LoadMoreViewHolder(view)
            } else {
                return mInternalAdapter.onCreateViewHolder(parent, viewType)
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (getItemViewType(position) == TYPE_LOAD_MORE) {
                val loadMoreViewHolder = holder as LoadMoreViewHolder
                loadMoreViewHolder.textView!!.text = mLoadMoreViewText
                loadMoreViewHolder.progressBar!!.visibility = if (mShowProgressBar) View.VISIBLE else View.GONE
                loadMoreViewHolder.itemView.isClickable = mLoadViewClickable
            } else {
                mInternalAdapter.onBindViewHolder(holder, position)
            }
        }

        override fun getItemCount(): Int {
            if (mShowLoadingView) {
                return mInternalAdapter.itemCount + 1
            } else {
                return mInternalAdapter.itemCount
            }
        }

        override fun getItemViewType(position: Int): Int {
            if (mShowLoadingView && position == itemCount - 1) {
                return TYPE_LOAD_MORE
            } else {
                return mInternalAdapter.getItemViewType(position)
            }
        }

        internal inner class LoadMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            var progressBar: ProgressBar? = itemView.progressbar
            var textView: TextView? = itemView.text

            init {
                itemView.setOnClickListener(this)
            }

            override fun onClick(v: View) {
                if (mOnLoadMoreViewClickListener != null) {
                    mOnLoadMoreViewClickListener!!.onLoadMoreViewClick()
                }
            }
        }
    }

    interface OnLoadMoreLinstener {
        fun onLoadMore()
    }

    interface OnLoadMoreViewClickListener {
        fun onLoadMoreViewClick()
    }

    inner class LoadMoreScrollLinstener : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            val layoutManager = recyclerView!!.layoutManager
            if (layoutManager.childCount <= 0) {
                return
            }
            if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                    !mIsLoading && mOnLoadMoreLinstener != null &&
                    mEnableLoadMore && !canScrollVertically(1) &&
                    mAdapter != null && mAdapter!!.itemCount > 0) {
                mIsLoading = true
                mOnLoadMoreLinstener!!.onLoadMore()
            }
        }
    }

    companion object {
        val TYPE_LOAD_MORE = -1
        val STATE_REFRESHING = 1
        val STATE_FAIL = 2
        val STATE_RETRY = 3
        val STATE_NO_MORE = 4
        val STATE_NO_DATA = 5
    }
}
