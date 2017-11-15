package com.kotlin.bilibili.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

class ResizeLayout : RelativeLayout {
    internal var a: setParam? = null

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if (this.a != null) {
            this.a!!.a(oldh, h)
        }
    }

    fun setOnSizeChangedListener(parama: setParam) {
        this.a = parama
    }

    interface setParam {
        fun a(paramInt1: Int, paramInt2: Int)
    }
}
