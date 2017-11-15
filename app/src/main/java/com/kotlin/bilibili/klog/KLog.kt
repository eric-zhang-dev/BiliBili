package com.kotlin.bilibili.klog


import android.text.TextUtils
import com.kotlin.bilibili.BuildConfig
import java.io.File

object KLog {
    val LINE_SEPARATOR = System.getProperty("line.separator")
    val NULL_TIPS = "Log with null object"

    private val DEFAULT_MESSAGE = "execute"
    private val PARAM = "Param"
    private val NULL = "null"
    private val TAG_DEFAULT = "KLog"
    private val SUFFIX = ".java"

    val JSON_INDENT = 4
    val V = 0x1

    val D = 0x2
    val I = 0x3
    val W = 0x4
    val E = 0x5
    val A = 0x6

    private val JSON = 0x7
    private val XML = 0x8

    private val STACK_TRACE_INDEX = 5

    private var mGlobalTag: String? = null
    private var mIsGlobalTagEmpty = true
    private var IS_SHOW_LOG = true

    fun init(isShowLog: Boolean) {
        IS_SHOW_LOG = isShowLog
    }

    fun init(isShowLog: Boolean, tag: String?) {
        IS_SHOW_LOG = isShowLog
        mGlobalTag = tag
        mIsGlobalTagEmpty = TextUtils.isEmpty(mGlobalTag)
    }

    fun v() {
        printLog(V, null, DEFAULT_MESSAGE)
    }

    fun v(msg: Any) {
        printLog(V, null, msg)
    }

    fun v(tag: String, vararg objects: Any) {
        printLog(V, tag, *objects)
    }

    fun d() {
        printLog(D, null, DEFAULT_MESSAGE)
    }

    fun d(msg: Any) {
        printLog(D, null, msg)
    }

    fun d(tag: String, vararg objects: Any) {
        printLog(D, tag, *objects)
    }

    fun i() {
        printLog(I, null, DEFAULT_MESSAGE)
    }

    fun i(msg: Any) {
        printLog(I, null, msg)
    }

    fun i(tag: String, vararg objects: Any) {
        printLog(I, tag, *objects)
    }

    fun w() {
        printLog(W, null, DEFAULT_MESSAGE)
    }

    fun w(msg: Any) {
        printLog(W, null, msg)
    }

    fun w(tag: String, vararg objects: Any) {
        printLog(W, tag, *objects)
    }

    fun e() {
        printLog(E, null, DEFAULT_MESSAGE)
    }

    fun e(msg: Any) {
        printLog(E, null, msg)
    }

    fun e(tag: String, vararg objects: Any) {
        printLog(E, tag, *objects)
    }

    fun a() {
        printLog(A, null, DEFAULT_MESSAGE)
    }

    fun a(msg: Any) {
        printLog(A, null, msg)
    }

    fun a(tag: String, vararg objects: Any) {
        printLog(A, tag, *objects)
    }

    fun json(jsonFormat: String) {
        printLog(JSON, null, jsonFormat)
    }

    fun json(tag: String, jsonFormat: String) {
        printLog(JSON, tag, jsonFormat)
    }

    fun xml(xml: String) {
        printLog(XML, null, xml)
    }

    fun xml(tag: String, xml: String) {
        printLog(XML, tag, xml)
    }

    fun file(targetDirectory: File, msg: Any) {
        printFile(null, targetDirectory, null, msg)
    }

    fun file(tag: String, targetDirectory: File, msg: Any) {
        printFile(tag, targetDirectory, null, msg)
    }

    fun file(tag: String, targetDirectory: File, fileName: String, msg: Any) {
        printFile(tag, targetDirectory, fileName, msg)
    }

    private fun printLog(type: Int, tagStr: String?, vararg objects: Any) {

        if (!IS_SHOW_LOG || !BuildConfig.DEBUG) {
            return
        }

        val contents = wrapperContent(tagStr, *objects)
        val tag = contents[0]
        val msg = contents[1]
        val headString = contents[2]

        when (type) {
            V, D, I, W, E, A -> BaseLog.printDefault(type, tag, headString + msg)
            JSON -> JsonLog.printJson(tag, msg, headString)
            XML -> XmlLog.printXml(tag, msg, headString)
        }
    }


    private fun printFile(tagStr: String?, targetDirectory: File, fileName: String?, objectMsg: Any) {

        if (!IS_SHOW_LOG) {
            return
        }

        val contents = wrapperContent(tagStr, objectMsg)
        val tag = contents[0]
        val msg = contents[1]
        val headString = contents[2]

        FileLog.printFile(tag, targetDirectory, fileName, headString, msg)
    }

    private fun wrapperContent(tagStr: String?, vararg objects: Any): Array<String> {

        val stackTrace = Thread.currentThread().stackTrace

        val targetElement = stackTrace[STACK_TRACE_INDEX]
        var className = targetElement.className
        val classNameInfo = className.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (classNameInfo.size > 0) {
            className = classNameInfo[classNameInfo.size - 1] + SUFFIX
        }

        if (className.contains("$")) {
            className = className.split("\\$".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0] + SUFFIX
        }

        val methodName = targetElement.methodName
        var lineNumber = targetElement.lineNumber

        if (lineNumber < 0) {
            lineNumber = 0
        }

        val methodNameShort = methodName.substring(0, 1).toUpperCase() + methodName.substring(1)

        var tag = tagStr ?: className

        if (mIsGlobalTagEmpty && TextUtils.isEmpty(tag)) {
            tag = TAG_DEFAULT
        } else if (!mIsGlobalTagEmpty) {
            tag = mGlobalTag
        }

        val msg = if (objects == null) NULL_TIPS else getObjectsString(*objects)
        val headString = "[ ($className:$lineNumber)#$methodNameShort ] "

        return arrayOf(tag, msg, headString)
    }

    private fun getObjectsString(vararg objects: Any): String {

        if (objects.size > 1) {
            val stringBuilder = StringBuilder()
            stringBuilder.append("\n")
            for (i in objects.indices) {
                val `object` = objects[i]
                if (`object` == null) {
                    stringBuilder.append(PARAM).append("[").append(i).append("]").append(" = ").append(NULL).append("\n")
                } else {
                    stringBuilder.append(PARAM).append("[").append(i).append("]").append(" = ").append(`object`.toString()).append("\n")
                }
            }
            return stringBuilder.toString()
        } else {
            val `object` = objects[0]
            return `object`?.toString() ?: NULL
        }
    }
}
