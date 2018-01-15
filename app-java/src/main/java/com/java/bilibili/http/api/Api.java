package com.java.bilibili.http.api;

import com.java.bilibili.http.ServerAddress;
import com.java.bilibili.http.ServerResponse;
import com.java.bilibili.modle.Data;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET(ServerAddress.get_anima_list)
    Observable<ServerResponse<Data>> getAnimaList(@Query("tid") String tid, @Query("pn") String pn);

    @GET(ServerAddress.get_anima_list)
    Observable<ServerResponse<Data>> getAnima(@Query("tid") String tid, @Query("pn") String pn);
}
