package com.kotlin.bilibili.http

import java.io.Serializable

class ServerResponse<T> : Serializable {
    var status: Int = 0
    var message: String? = null
    var data: T? = null
}
