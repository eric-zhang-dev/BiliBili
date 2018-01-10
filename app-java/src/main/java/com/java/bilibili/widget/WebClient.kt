package com.kotlin.bilibili.widget

import android.graphics.Bitmap
import android.view.View
import android.widget.RelativeLayout

import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient

class WebClient(progressBar: View) : WebViewClient() {
    private var progressBar: View? = null

    fun setProgressBar(progressBar: RelativeLayout) {
        this.progressBar = progressBar
    }

    init {
        this.progressBar = progressBar
    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        view!!.loadUrl(url)
        return super.shouldOverrideUrlLoading(view, url)
    }

    override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
        view.settings.blockNetworkImage = true
        if (progressBar != null) {
            progressBar!!.visibility = View.VISIBLE
        }
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        view!!.settings.blockNetworkImage = false
        if (progressBar != null) {
            progressBar!!.visibility = View.GONE
        }
        super.onPageFinished(view, url)
    }
}
