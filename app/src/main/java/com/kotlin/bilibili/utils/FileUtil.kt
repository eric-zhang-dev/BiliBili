package com.kotlin.bilibili.utils

import java.io.File
import java.io.FileOutputStream


object FileUtil {

    fun getDirectory(path: String): File {
        val appDir = File(path)
        if (!appDir.exists()) {
            appDir.mkdirs()
        }
        return appDir
    }

    fun writeFile(path: String, content: String): Int {
        try {
            val f = File(path)
            if (f.exists()) {
                f.delete()
            }
            if (f.createNewFile()) {
                val utput = FileOutputStream(f)
                utput.write(content.toByteArray())
                utput.close()
            } else {
                return 0
            }
        } catch (e: Exception) {
            return 0
        }
        return 1
    }
}
