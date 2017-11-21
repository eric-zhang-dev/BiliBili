package com.kotlin.bilibili.modle

/**
 * 动画
 */
data class Data(var archives:MutableList<Archives>,var page: Page)
data class Page(var count:String,var num:Int,var size:Int)
data class Archives(var aid:String,var videos:Int,var tid:Int,var tname:String,var copyright:Int,var pic:String,var title:String,
                    var attribute:Int,var duration:Int,var rights:Rights,var stat:Stat,var play:String,var favorites:Int,
                    var video_review:Int,var create:String,var description:String,var mid:Int,var author:String,var face:String)
data class Rights(var bp:Int,var elec:Int,var download:Int,var movie:Int,var pay:Int,var hd5:Int,var no_reprint:Int)
data class Stat(var aid:String,var view:String,var danmaku:Int,var reply:Int,var favorite:Int,var coin:Int,var share:Int,var now_rank:Int,var his_rank:Int,var like:Int)


