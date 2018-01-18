package com.java.bilibili;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 //          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 //                              _oo0oo_
 //                             o8888888o
 //                             88" . "88
 //                             (| -_- |)
 //                             0\  =  /0
 //                           ___/`---‘\___
 //                        .' \\\|     |// '.
 //                       / \\\|||  :  |||// \\
 //                      / _ ||||| -:- |||||- \\
 //                      | |  \\\\  -  /// |   |
 //                      | \_|  ''\---/''  |_/ |
 //                      \  .-\__  '-'  __/-.  /
 //                    ___'. .'  /--.--\  '. .'___
 //                 ."" '<  '.___\_<|>_/___.' >'  "".
 //                | | : '-  \'.;'\ _ /';.'/ - ' : | |
 //                \  \ '_.   \_ __\ /__ _/   .-' /  /
 //            ====='-.____'.___ \_____/___.-'____.-'=====
 //                              '=---='
 //
 //
 //          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 //
 //                  佛祖保佑                 永无BUG
 */
public class MainApplication extends Application {
    private static MainApplication instance;

    public static synchronized MainApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}

