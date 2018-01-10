package com.java.bilibili.ui.main.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.java.bilibili.R;
import com.java.bilibili.modle.Data;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class HomeAdapter extends RecyclerView.Adapter{
    private List<Data.Archives> mVideos;
    private Context mContext;
    private int mType;
    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setPartionData(List<Data.Archives> mVideos) {
        this.mVideos = mVideos;
    }

    public void addDynamicVideo(List<Data.Archives> data) {
        if (mVideos == null) {
            mVideos = data;
        } else {
            mVideos.addAll(data);
        }
    }

    public void clearDynamicVideo() {
        if (mVideos != null) {
            mVideos.clear();
        }
    }

    public HomeAdapter(Context mContext, int type) {
        this.mContext = mContext;
        this.mType = type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        viewHolder = new VideoHolder(inflater.inflate(R.layout.video_grid_card_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VideoHolder videoHolder = (VideoHolder) holder;
        Data.Archives adult = mVideos.get(position);
        videoHolder.content = adult;
        Glide.with(mContext).load(adult.getPic())
                .into(videoHolder.ivPic);
        videoHolder.tvVip.setText(adult.getTitle());
    }

    @Override
    public int getItemCount() {
        if (null == mVideos) {
            return 0;
        } else {
            return mVideos.size();
        }
    }

    class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.cover)
        ImageView ivPic;
        @BindView(R.id.title)
        TextView tvVip;
        Data.Archives content;

        VideoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onVideoItemClick(content);
            }
        }
    }

    public interface OnItemClickListener {
        void onVideoItemClick(Data.Archives aid);
    }


}
