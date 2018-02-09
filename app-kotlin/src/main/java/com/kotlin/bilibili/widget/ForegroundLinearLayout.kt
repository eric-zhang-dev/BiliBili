package com.kotlin.bilibili.widget

import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet

import com.kotlin.bilibili.R


class ForegroundLinearLayout : LinearLayoutCompat {

    private var mForeground: Drawable? = null

    private var mForegroundBoundChange: Boolean = false

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
            val array = context.obtainStyledAttributes(attrs, R.styleable.ForegroundView)
            mForeground = array.getDrawable(R.styleable.ForegroundView_android_foreground)
            foreground = mForeground!!
            array.recycle()
        }
    }

    override fun setForeground(foreground: Drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            super.setForeground(foreground)
        } else {
            if (mForeground !== foreground) {
                if (mForeground != null) {
                    mForeground!!.callback = null
                    unscheduleDrawable(mForeground)
                }
            }
            mForeground = foreground
            if (mForeground != null) {
                setWillNotDraw(false)
                mForeground!!.callback = this
                if (mForeground!!.isStateful) {
                    mForeground!!.state = drawableState
                }
            } else {
                setWillNotDraw(true)
            }
            requestLayout()
            invalidate()
        }
    }

    override fun verifyDrawable(who: Drawable): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return super.verifyDrawable(who)
        } else {
            return super.verifyDrawable(who) || who === mForeground
        }
    }

    override fun jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (mForeground != null) {
                mForeground!!.jumpToCurrentState()
            }
        }
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (mForeground != null && mForeground!!.isStateful) {
                mForeground!!.state = drawableState
            }
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        mForegroundBoundChange = mForegroundBoundChange or changed
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mForegroundBoundChange = true
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (mForeground != null) {
                if (mForegroundBoundChange) {
                    mForegroundBoundChange = false
                    mForeground!!.setBounds(0, 0, right - left, bottom - top)
                }
                mForeground!!.draw(canvas)
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun drawableHotspotChanged(x: Float, y: Float) {
        super.drawableHotspotChanged(x, y)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (mForeground != null) {
                mForeground!!.setHotspot(x, y)
            }
        }
    }
}
