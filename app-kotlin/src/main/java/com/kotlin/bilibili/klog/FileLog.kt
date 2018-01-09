package com.kotlin.bilibili.klog

import android.util.Log
import java.io.*
import java.util.*

object FileLog {

    fun printFile(tag: String, targetDirectory: File, fileName: String?, headString: String, msg: String) {
        var fileName = fileName

        fileName = if (fileName == null) fileName else fileName
        if (save(targetDirectory, fileName!!, msg)) {
            Log.d(tag, headString + " save log success ! location is >>>" + targetDirectory.absolutePath + "/" + fileName)
        } else {
            Log.e(tag, headString + "save log fails !")
        }
    }

    private fun save(dic: File, fileName: String, msg: String): Boolean {

        val file = File(dic, fileName)

        try {
            val outputStream = FileOutputStream(file)
            val outputStreamWriter = OutputStreamWriter(outputStream, "UTF-8")
            outputStreamWriter.write(msg)
            outputStreamWriter.flush()
            outputStream.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            return false
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            return false
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return true
    }

    private val fileName: String
        get() {
            val random = Random()
            return "KLog_" + java.lang.Long.toString(System.currentTimeMillis() + random.nextInt(10000)).substring(4) + ".txt"
        }
}
