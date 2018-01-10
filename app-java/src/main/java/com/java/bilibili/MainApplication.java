package com.java.bilibili;

import android.app.Application;

public class MainApplication extends Application {
    private static MainApplication instance;

    public static synchronized MainApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}

