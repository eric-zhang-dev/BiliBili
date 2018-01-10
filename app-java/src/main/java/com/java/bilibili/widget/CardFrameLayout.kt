package com.kotlin.bilibili.widget

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet

class CardFrameLayout : CardView {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        useCompatPadding = true
    }
}
