package com.kotlin.bilibili.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.kotlin.bilibili.R


class ScalableImageView : ImageView {

    var widthRatio = 0
    var heightRatio = 0

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScalableImageView)
            heightRatio = typedArray.getInt(R.styleable.ScalableImageView_aspectRadioHeight, 0)
            widthRatio = typedArray.getInt(R.styleable.ScalableImageView_aspectRadioWidth, 0)
            typedArray.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (heightRatio != 0 && widthRatio != 0) {
            val width = measuredWidth
            val height = (width.toFloat() * heightRatio / widthRatio).toInt()
            setMeasuredDimension(width, height)
        }
    }
}
