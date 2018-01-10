package com.java.bilibili.widget.test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class MyViewGroupA extends LinearLayout {
    String TAG = this.getClass().getSimpleName();

    public MyViewGroupA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "MyViewGroupA --->dispatchTouchEvent: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "MyViewGroupA --->onInterceptTouchEvent: " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "MyViewGroupA --->onTouchEvent: " + event.getAction());
        return super.onTouchEvent(event);
    }
}
