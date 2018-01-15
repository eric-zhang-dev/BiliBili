package com.java.bilibili.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.java.bilibili.http.api.Api;
import com.java.bilibili.klog.KLog;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class RetrofitHelper {
    private static RetrofitHelper mRetrofitHelper;
    private Retrofit mRetrofit;

    public static OkHttpClient mClient;
    private Api api;


    private RetrofitHelper() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//yth1628978981
        mClient = new OkHttpClient.Builder()
                .connectTimeout(3000, TimeUnit.SECONDS)
                .writeTimeout(3000, TimeUnit.SECONDS)
                .readTimeout(3000, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        KLog.json(message);
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ServerAddress.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mClient)
                .build();
        initService();
    }

    private void initService() {
        api = mRetrofit.create(Api.class);
    }

    public static RetrofitHelper getInstance() {
        if (mRetrofitHelper == null) {
            synchronized (RetrofitHelper.class) {
                if (mRetrofitHelper == null) {
                    mRetrofitHelper = new RetrofitHelper();
                }
            }
        }
        return mRetrofitHelper;
    }

    public static RetrofitHelper getmRetrofitHelper() {
        return mRetrofitHelper;
    }

    public Api getApi() {
        return api;
    }
}
