package com.kotlin.bilibili.utils

object Constants {
    val UA = "Android Client/beta(qq group:null)"
    val BASE_URL = "http://api.look-movie.com"
    val HOME_LIST = BASE_URL + "/api2/adult/list/{page}/{tag}"
    val APP_UPDATE = BASE_URL + "/api2/update/check/%s"
    val TOKEN = "/oauth/token"
    val USRE_LOGIN = "/api2/user/reg"
    val USRE_INFO = "/api2/user/info"
    val PRE_ORDER = "/api2/pay/ordering/1"
    val DEVICE_COUNT = "/api2/device/{deviceId}"
    val ADD_POP = "/api2/adult/pop/{adultId}"
    val ADD_PLAY_STATUS = "/api2/adult/status"
    val GET_PIC = BASE_URL + "/api2/pic/list/{page}/{tag}"
    val TAB_TITLES = arrayOf("动画", "推荐", "追番", "影视", "专栏")
    val PIC_TAB_TITLES = arrayOf("INDAIN", "JP", "US", "CHINA", "ASIAN")
    val HOME_TAG_1 = 1
    val HOME_TAG_2 = 2
    val HOME_TAG_3 = 3
    val HOME_TAG_4 = 4
    val HOME_TAG_5 = 5
    val HOME_TAG_6 = 6
    val HOME_TAG_7 = 7
    val HOME_TAG_8 = 8
    val HOME_TAG_9 = 9
}
