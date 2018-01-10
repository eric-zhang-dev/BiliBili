package com.java.bilibili.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
public class CardFrameLayout extends CardView {
    public CardFrameLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        setUseCompatPadding(true);
    }

    public CardFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CardFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
}
