package com.java.bilibili.http;

import com.java.bilibili.http.api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
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
//                .addInterceptor(interceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ServerAddress.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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
