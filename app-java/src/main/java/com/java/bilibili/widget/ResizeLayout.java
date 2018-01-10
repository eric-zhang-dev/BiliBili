package com.java.bilibili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class ResizeLayout extends RelativeLayout {
    private setParam a;

    public ResizeLayout(Context context) {
        super(context);
    }

    public ResizeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResizeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface setParam {
        void a(int para1, int para2);
    }

    public void setOnSizeChangedListener(setParam param) {
        this.a = param;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (a != null) {
            a.a(oldh, h);
        }
    }
}
