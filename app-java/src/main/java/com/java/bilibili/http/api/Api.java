package com.java.bilibili.http.api;

import com.java.bilibili.http.ServerAddress;
import com.java.bilibili.http.ServerResponse;
import com.java.bilibili.modle.Data;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
    @GET(ServerAddress.get_anima_list)
    Observable<ServerResponse<Data>> getAnimaList(@Query("tid") String tid, @Query("pn") String pn);
}
