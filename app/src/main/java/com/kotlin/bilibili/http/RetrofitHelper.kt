package com.kotlin.bilibili.http


import com.google.gson.Gson
import com.kotlin.bilibili.http.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitHelper {
    var api: Api? = null

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val mClient = OkHttpClient.Builder()
                .connectTimeout(3000, TimeUnit.SECONDS)
                .writeTimeout(3000, TimeUnit.SECONDS)
                .readTimeout(3000, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
//                .addInterceptor(mloggingInterceptor)
                .build()
        val mRetrofit = Retrofit.Builder()
                .baseUrl(ServerAddress.base_url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(mClient)
                .build()
//        initService()
        api = mRetrofit.create<Api>(Api::class.java)
    }

    //    private fun initService() {
//
//    }
    companion object {
        private var mRetrofitHelper: RetrofitHelper? = null
        val instance: RetrofitHelper
            get() {
                if (mRetrofitHelper == null) {
                    synchronized(lock = RetrofitHelper::class.java) {
                        if (mRetrofitHelper == null) {
                            mRetrofitHelper = RetrofitHelper()
                        }
                    }
                }
                return mRetrofitHelper!!
            }

        fun getRetrofitHelper(): RetrofitHelper {
            return mRetrofitHelper!!
        }

    }

}
