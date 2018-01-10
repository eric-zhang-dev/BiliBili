package com.java.bilibili.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

class TestView extends View{
    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    private int measureHeight(int heightMeasureSpec) {
        int height = 0;
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        if(mode == MeasureSpec.EXACTLY){
            height = size;
        }else{
            height = 400;
            if(mode == MeasureSpec.AT_MOST){
                height = Math.min(height,size);
            }
        }
        return height;
    }


    private int measureWidth(int widthMeasureSpec) {
        int widith = 0;
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        if(mode == MeasureSpec.EXACTLY){
            widith = size;
        }else{
            widith = 200;
            if(mode == MeasureSpec.AT_MOST){
                widith = Math.min(widith,size);
            }
        }
        return widith;
    }
}

