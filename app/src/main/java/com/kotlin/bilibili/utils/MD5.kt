package com.kotlin.bilibili.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and

/**
 * Created by Administrator on 2017/1/4.
 */

object MD5 {
    fun md5(string: String): String {
        val hash: ByteArray
        try {
            hash = MessageDigest.getInstance("MD5").digest(
                    string.toByteArray(charset("UTF-8")))
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Huh, MD5 should be supported?", e)
        } catch (e: UnsupportedEncodingException) {
            throw RuntimeException("Huh, UTF-8 should be supported?", e)
        }

        val hex = StringBuilder(hash.size * 2)
        for (b in hash) {
            if (b and 0xFF.toByte() < 0x10)
                hex.append("0")
            hex.append(Integer.toHexString((b and 0xFF.toByte()).toInt()))
        }
        return hex.toString()
    }

    fun getAppVersionName(context: Context): String {
        val pm = context.packageManager// context为当前Activity上下文
        val pi: PackageInfo
        try {
            pi = pm.getPackageInfo(context.packageName, 0)
            val version = pi.versionName
            return version
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return "1"
    }
}
