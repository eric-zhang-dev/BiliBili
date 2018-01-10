package com.kotlin.bilibili.http

interface ServerAddress<T> {
    companion object {
        //https://api.bilibili.com/archive_rank/getarchiverankbypartion?jsonp=jsonp&tid=24&pn=1//动画 mad.amv
        const val base_url = "https://api.bilibili.com/"
        const val get_anima_list = "archive_rank/getarchiverankbypartion"
        const val bedlist = "ApiManage/Quickadd/bedList"//病床列表
        const val add_PD = "ApiManage/Quickadd/addPD"
        const val bind = "ApiManage/Quickadd/bind"
            const val bind_PD = "ApiManage/Quickadd/bindPD"
        const val patient_list = "ApiManage/Quickadd/patientList"
        const val login = "ApiManage/Auth/login"//登录
        const val patient = "ApiManage/Patient/index"//患者管理
        //        const val patient_search = "ApiManage/Patient/search"//患者查询
        const val bed_room = "ApiManage/Room/index"//病房列表
        const val add_room = "ApiManage/Room/add"//添加病房
        const val edit_room = "ApiManage/Room/edit"//编辑病房
        const val delete_room = "ApiManage/Room/delete"//删除病房

        const val bed_list = "ApiManage/Bed/index"//病床列表
        const val bed_add = "ApiManage/Bed/add"//添加病床
        const val edit_bed = "ApiManage/Bed/edit"//编辑病房
        const val delete_bed = "ApiManage/Bed/delete"//删除病房

        const val device = "ApiManage/Device/index"//设备列表
        const val add_device = "ApiManage/Device/add"//添加设备
        const val edit_device = "ApiManage/Device/edit"//添加设备
        const val delete_device = "ApiManage/Device/delete"//添加设备

        const val grade = "ApiManage/Level/index"//等级设置
        const val grade_handle = "ApiManage/Level/indexHandle"//提交等级设置
        const val tem_monitor = "ApiManage/Monitor/index"//体温监测
    }
}
