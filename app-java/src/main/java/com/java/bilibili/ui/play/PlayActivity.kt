//package com.kotlin.bilibili.ui.play
//
//import android.annotation.SuppressLint
//import android.os.Build
//import android.support.annotation.RequiresApi
//import android.webkit.*
//import com.kotlin.bilibili.R
//import com.kotlin.bilibili.base.BaseActivity
//import kotlinx.android.synthetic.main.ui_activity_play.*
//import android.view.ViewGroup
//
//
//
///**
// * Created by Eric.zhang on 2018/1/5.
// */
//class PlayActivity : BaseActivity() {
//    private var aid: String = ""
//    override fun layout(): Int {
//        return R.layout.ui_activity_play
//    }
//
//    @SuppressLint("SetJavaScriptEnabled")
//    override fun initData() {
//        aid = intent.getStringExtra("aid")
////如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
//        webview.settings.javaScriptEnabled = true
//// 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
//// 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可
////设置自适应屏幕，两者合用
//        webview.settings.useWideViewPort = true //将图片调整到适合webview的大小
//        webview.settings.loadWithOverviewMode = true // 缩放至屏幕的大小
//        webview.settings.setSupportZoom(true)  //支持缩放，默认为true。是下面那个的前提。
//        webview.settings.builtInZoomControls = true//设置内置的缩放控件。若为false，则该WebView不可缩放
//        webview.settings.displayZoomControls = false //隐藏原生的缩放控件
//
////其他细节操作
//        webview.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK //关闭webview中缓存
//        webview.settings.allowFileAccess = true //设置可以访问文件
//        webview.settings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
//        webview.settings.loadsImagesAutomatically = true //支持自动加载图片
//        webview.settings.defaultTextEncodingName = "utf-8"//设置编码格式
//        webview.settings.domStorageEnabled = true
////        https://m.bilibili.com/video/av17975751.html
//        var a:String = String.format("https://m.bilibili.com/video/av%s.html", aid)
//        webview.loadUrl(a)
//        webview.webViewClient = object :WebViewClient(){
//            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//                view!!.loadUrl(request!!.url.toString())
//                return true
//            }
//        }
//    }
//
//    override fun onDestroy() {
//        if (webview != null) {
//            webview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
//            webview.clearHistory()
//
//            (webview.parent as ViewGroup).removeView(webview)
//            webview.destroy()
////            webview = null
//        }
//        super.onDestroy()
//    }
//}