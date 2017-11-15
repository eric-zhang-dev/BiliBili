package com.kotlin.bilibili.utils

import android.content.Context

object SharedUtils {
    fun getString(context: Context, key: String, defValue: String): String {
        val mpref = context.getSharedPreferences(Constent.SHARED_KEY,
                Context.MODE_PRIVATE)
        val value = mpref.getString(key, defValue)
        return value
    }

    fun putString(context: Context, key: String, value: String) {

        val mpref = context.getSharedPreferences(Constent.SHARED_KEY,
                Context.MODE_PRIVATE)
        mpref.edit().putString(key, value).commit()
    }

    fun putLong(context: Context, key: String, value: Long) {
        val mpref = context.getSharedPreferences(Constent.SHARED_KEY,
                Context.MODE_PRIVATE)
        mpref.edit().putLong(key, value).commit()
    }

    fun getInt(context: Context, key: String, defValue: Long): Long {
        val mpref = context.getSharedPreferences(Constent.SHARED_KEY, Context.MODE_PRIVATE)
        val value = mpref.getLong(key, defValue)
        return value
    }

    fun putInt(context: Context, key: String, value: Int) {
        val mpref = context.getSharedPreferences(Constent.SHARED_KEY,
                Context.MODE_PRIVATE)
        mpref.edit().putInt(key, value).commit()
    }

    fun getInt(context: Context, key: String, defValue: Int): Int {
        val mpref = context.getSharedPreferences(Constent.SHARED_KEY, Context.MODE_PRIVATE)
        val value = mpref.getInt(key, defValue)
        return value
    }

    fun getBoolean(context: Context, key: String,
                   defValue: Boolean): Boolean {
        val mpref = context.getSharedPreferences(Constent.SHARED_KEY,
                Context.MODE_PRIVATE)
        val value = mpref.getBoolean(key, defValue)
        return value
    }

    fun putBoolean(context: Context, key: String, value: Boolean) {

        val mpref = context.getSharedPreferences(Constent.SHARED_KEY,
                Context.MODE_PRIVATE)
        mpref.edit().putBoolean(key, value).commit()
    }

    fun removeAll(context: Context) {
        val mpref = context.getSharedPreferences(Constent.SHARED_KEY,
                Context.MODE_PRIVATE)
        mpref.edit().clear().commit()
    }

}
