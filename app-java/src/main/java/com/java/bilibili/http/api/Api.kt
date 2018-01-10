package com.kotlin.bilibili.http.api

import com.kotlin.bilibili.http.ServerAddress
import com.kotlin.bilibili.http.ServerResponse
import com.kotlin.bilibili.modle.Data
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


interface Api {
    @GET(ServerAddress.get_anima_list)
    fun getAnimaList(@Query("tid") tid: Int, @Query("pn") pn: Int): Observable<ServerResponse<Data>>//动画列表

//    @POST(ServerAddress.bind)
//    @FormUrlEncoded
//    fun bind(@Field("section_id") section_id: String,@Field("mac") mac: String): Observable<Saoma>
//
//    @GET(ServerAddress.patient_list)
//    fun getUserList(@Query("section_id") id: String): Observable<ServerResponse<MutableList<User>>>
//
//    @GET(ServerAddress.bedlist)
//    fun getBedList(@Query("section_id") id: String): Observable<ServerResponse<MutableList<BedInfo>>>
//
//    @POST(ServerAddress.bind_PD)
//    @FormUrlEncoded
//    fun bindPD(@Field("pid") pid: String, @Field("mac") mac: String, @Field("section_id") section_id: String): Observable<Saoma>
//
//    @POST(ServerAddress.add_PD)
//    @FormUrlEncoded
//    fun addPD(@Field("mac") mac: String, @Field("section_id") section_id: String, @Field("caseno") caseno: String, @Field("name") name: String, @Field("bid") bid: String): Observable<Saoma>
//
//    @POST(ServerAddress.login)
//    @FormUrlEncoded
//    fun login(@Field("username") username: String, @Field("password") password: String): Observable<LoginInfo>
//
//    @GET(ServerAddress.patient) //患者列表
//    fun patientList(@Query("history") history: String, @Query("page_id") page_id: String, @Query("section_id") section_id: String
//                    , @Query("type") type: Int, @Query("content") content: String): Observable<ServerResponse<MutableList<Data>>>
//
//    @GET(ServerAddress.bed_room) //病房列表
//    fun bedRoomList(@Query("section_id") section_id: String): Observable<ServerResponse<MutableList<Datas>>>
//
//    @POST(ServerAddress.add_room)//添加病房
//    @FormUrlEncoded
//    fun addRoom(@Field("section_id") section_id: String, @Field("room_name") room_name: String): Observable<Saoma>
//
//    @POST(ServerAddress.edit_room)//编辑病房
//    @FormUrlEncoded
//    fun editRoom(@Field("rid") rid: String, @Field("room_name") room_name: String): Observable<Saoma>
//
//    @POST(ServerAddress.delete_room)//删除病房
//    @FormUrlEncoded
//    fun deleteRoom(@Field("rid") rid: String): Observable<Saoma>
//
//    @GET(ServerAddress.bed_list) //病床列表
//    fun bedList(@Query("room_id") room_id: String): Observable<ServerResponse<MutableList<Bed>>>
//
//    @POST(ServerAddress.bed_add)//添加病床
//    @FormUrlEncoded
//    fun addBed(@Field("room_id") room_id: String, @Field("bed_name") bed_name: String, @Field("type") type: String, @Field("section_id") section_id: String): Observable<Saoma>
//
//    @POST(ServerAddress.edit_bed)//编辑病床
//    @FormUrlEncoded
//    fun editBed(@Field("bed_id") bed_id: String, @Field("bed_name") bed_name: String): Observable<Saoma>
//
//    @POST(ServerAddress.delete_bed)//删除病床
//    @FormUrlEncoded
//    fun deleteBed(@Field("bed_id") bed_id: String): Observable<Saoma>
//
//    @GET(ServerAddress.device) //设备列表
//    fun deviceList(@Query("section_id") section_id: String, @Query("page_id") page_id: Int): Observable<ServerResponse<MutableList<Device>>>
//
//    @POST(ServerAddress.add_device)//添加设备
//    @FormUrlEncoded
//    fun addDevice(@Field("device_number") device_number: String, @Field("mac") mac: String, @Field("section_id") section_id: String): Observable<Saoma>
//
//    @POST(ServerAddress.edit_device)//编辑病床
//    @FormUrlEncoded
//    fun editDevice(@Field("did") device_id: String, @Field("device_number") device_number: String): Observable<Saoma>
//
//    @POST(ServerAddress.delete_device)//删除设备
//    @FormUrlEncoded
//    fun deleteDevice(@Field("device_id") device_id: String): Observable<Saoma>
//
//    @GET(ServerAddress.grade) //等级设置
//    fun gradeList(@Query("section_id") section_id: String): Observable<ServerResponse<MutableList<Grade>>>
//
//    @POST(ServerAddress.grade_handle) //提交等级
//    fun gradeHandle(@Body requestBody: RequestBody): Observable<Saoma>
//
//    @GET(ServerAddress.tem_monitor) //体温监测
//    fun temMonitor(@Query("section_id") section_id: String, @Query("type") type: String): Observable<ServerResponse<MutableList<Tem>>>

}
