package com.kotlin.bilibili.ui.main.fragment.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kotlin.bilibili.R
import com.kotlin.bilibili.modle.Archives
import kotlinx.android.synthetic.main.video_grid_card_item.view.*

/**
 * home tab adapter
 * Created by Administrator on 2016/12/6.
 */
class HomeAdapter(private val mContext: Context, private val mType: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mVideos: MutableList<Archives>? = null
    private var mOnItemClickListener: OnItemClickListener? = null

    fun setmOnItemClickListener(mOnItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener
    }

    fun setPartionData(mVideos: MutableList<Archives>) {
        this.mVideos = mVideos
    }

    fun addDynamicVideo(data: MutableList<Archives>) {
        if (mVideos == null) {
            mVideos = data
        } else {
            mVideos!!.addAll(data)
        }
        notifyDataSetChanged()
    }

    fun clearDynamicVideo() {
        if (mVideos != null) {
            mVideos!!.clear()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder?
        val inflater = LayoutInflater.from(parent.context)
        viewHolder = VideoHolder(inflater.inflate(R.layout.video_grid_card_item, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val videoHolder = holder as VideoHolder
        val adult = mVideos!![position]
        videoHolder.content = adult
//                if (LogUtil.isDebug) {
//                    Glide.with(mContext).load(Constans.png[new Random().nextInt(49)]).asBitmap().into(videoHolder.ivPic);
//                } else {

                    Glide.with(mContext).load(adult.pic)
                            .into(videoHolder.ivPic)
//                }
        videoHolder.tvVip!!.text = adult.title
    }

    override fun getItemCount(): Int {
        if (null == mVideos) {
            return 0
        } else {
            return mVideos!!.size
        }
    }

    internal inner class VideoHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var ivPic: ImageView? = itemView.cover
        var tvVip: TextView? = itemView.title
        var content: Archives? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener!!.onVideoItemClick(content!!)
            }
        }
    }

    interface OnItemClickListener {
        fun onVideoItemClick(aid: Archives)
    }

}