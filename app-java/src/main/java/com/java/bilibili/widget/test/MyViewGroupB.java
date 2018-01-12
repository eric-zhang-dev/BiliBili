package com.java.bilibili.widget.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class MyViewGroupB extends RelativeLayout {
    String TAG = this.getClass().getSimpleName();

    public MyViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "MyViewGroupB --->dispatchTouchEvent: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "MyViewGroupB --->onInterceptTouchEvent: " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "MyViewGroupB --->onTouchEvent: " + event.getAction());
        return super.onTouchEvent(event);
    }
}
