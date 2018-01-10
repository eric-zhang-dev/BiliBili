package com.java.bilibili.widget;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;


public class WebClient extends WebViewClient{
    private RelativeLayout progressBar;

    public void setProgressBar(RelativeLayout progressBar) {
        this.progressBar = progressBar;
    }

    public WebClient(RelativeLayout progressBar) {
        super();
        this.progressBar = progressBar;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // TODO Auto-generated method stub
        view.loadUrl(url);
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        view.getSettings().setBlockNetworkImage(true);
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        view.getSettings().setBlockNetworkImage(false);
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
        super.onPageFinished(view, url);
    }
}
