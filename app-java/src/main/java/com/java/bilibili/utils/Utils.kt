package com.kotlin.bilibili.utils

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import com.kotlin.bilibili.MainApplication
import com.kotlin.bilibili.R
import com.kotlin.bilibili.manager.AppManager

object Utils{
    fun showDialog(context: Context, title: String, msg: String, listener: DialogInterface.OnClickListener) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(msg)
        builder.setTitle(title)
        builder.setPositiveButton(context.getString(R.string.ok), listener)
        builder.setNegativeButton(context.getString(R.string.cancel), null)
        builder.create().show()
    }
//    val menuList: List<MenuBeen>
//        get() {
//            val menuBeens = ArrayList<MenuBeen>()
//            menuBeens.add(MenuBeen(R.string.temperature_monitoring, R.mipmap.temp_l))
//            menuBeens.add(MenuBeen(R.string.patient_setting, R.mipmap.patient_l))
//            menuBeens.add(MenuBeen(R.string.bed_setting, R.mipmap.bed_l))
//            menuBeens.add(MenuBeen(R.string.device_setting, R.mipmap.device_l))
//            menuBeens.add(MenuBeen(R.string.grade_setting, R.mipmap.grade_l))
//            menuBeens.add(MenuBeen(R.string.saoma, R.mipmap.grade_l))
//            return menuBeens
//        }
    fun exitApp(context: Context) {
        Utils.showDialog(context, context.getString(R.string.exit), context.getString(R.string.exit_ok), DialogInterface.OnClickListener { _, _ -> AppManager.appManager.AppExit(MainApplication.instance) })
    }
}
