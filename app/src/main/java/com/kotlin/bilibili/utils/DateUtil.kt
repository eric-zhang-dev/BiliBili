package com.kotlin.bilibili.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

/**
 * 日期操作类
 */
object DateUtil {
    val DATE_NODAY = "yyyy-MM"
    val DATE = "yyyy-MM-dd"
    val DATEMONTHCZ = "yyyy年MM月"
    val DATESTR = "yyyyMMdd"
    val TIME = "HH:mm:ss"
    val DATETIME = "yyyy-MM-dd HH:mm:ss"
    val DATE_TIME = "yyyy-MM-dd  HH:mm"
    val PRECISE = "yyyy-MM-dd HH.mm.ss.SSS"
    val `$PRECISE` = "yyyy-MM-dd\$HH.mm.ss"
    val DATETIMESTR = "yyyyMMddHHmmss"
    val TIMESTR = "HHmmss"

    @SuppressLint("WrongConstant")
            /**
             * 根据日期返回对应当前月的最大天数

             * @return
             */
    fun getMaxDays(date: Date): Int {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    /**
     * 根据日期返回年

     * @param date
     * *
     * @return date为null时返回0
     */
    fun getYear(date: Date): Int {
        return get(date, Calendar.YEAR)
    }

    /**
     * 根据日期返回年

     * @param date
     * *
     * @return date为null时返回0
     */
    fun getYear(date: String): Int {
        return get(toDate(date), Calendar.YEAR)
    }

    /**
     * 根据日期返回月

     * @param date
     * *
     * @return date为null时返回0
     */
    fun getMonth(date: Date): Int {
        return get(date, Calendar.MONTH)
    }

    /**
     * 根据日期返回月

     * @param date
     * *
     * @return date为null时返回0
     */
    fun getMonth(date: String): Int {
        return get(toDate(date), Calendar.MONTH)
    }

    /**
     * 根据日期返回天

     * @param date
     * *
     * @return date为null时返回0
     */
    fun getDay(date: Date): Int {
        return get(date, Calendar.DAY_OF_MONTH)
    }

    /**
     * 根据日期返回天

     * @param date
     * *
     * @return date为null时返回0
     */
    fun getDay(date: String): Int {
        return get(toDate(date), Calendar.DAY_OF_MONTH)
    }

    /**
     * 获取当前小时 (24小时制)

     * @return
     */
    val hour: Int
        get() = get(getNowDate(System.currentTimeMillis()), Calendar.HOUR_OF_DAY)

    /**
     * 获取指定日期时间 的 小时 (24小时制)

     * @param dateTimeStr
     * *
     * @return
     */
    fun getHour(dateTimeStr: String): Int {
        return get(toDateTime(dateTimeStr), Calendar.HOUR_OF_DAY)
    }

    /**
     * 获取当前分钟 (24小时制)

     * @return
     */
    val min: Int
        get() = get(getNowDate(System.currentTimeMillis()), Calendar.MINUTE)

    /**
     * 获取指定日期时间的 分钟 (24小时)

     * @param dateTimeStr
     * *
     * @return
     */
    fun getMin(dateTimeStr: String): Int {
        return get(toDateTime(dateTimeStr), Calendar.MINUTE)
    }

    operator fun get(date: Date?, type: Int): Int {
        if (date == null) {
            return 0
        }
        val c = Calendar.getInstance()
        c.time = date
        return c.get(type)
    }

    /**
     * 日期字符串转换成指定的格式

     * @param dateString
     * *
     * @param pattern
     * *
     * @return
     */
    fun toPattern(dateString: String?, pattern: String?): String? {
        if (dateString == null || dateString == "") {
            return null
        }
        if (pattern == null || pattern == "") {
            throw RuntimeException("toPattern is null")
        }
        var date: Date?
        if (pattern == DATE || pattern == DATESTR
                || pattern == DATEMONTHCZ)
            date = toDate(dateString)
        else
            date = toDateTime(dateString)
        return toPattern(date, pattern)
    }

    /**
     * 日期字符串转换成Date 不包含Time

     * @param dateTimeStr
     * *
     * @return
     */
    fun toDate(dateTimeStr: String?): Date? {
        if (dateTimeStr == null || dateTimeStr == "") {
            return null
        }
        val sdf = SimpleDateFormat(DATE)
        try {
            return sdf.parse(dateTimeStr)
        } catch (e1: ParseException) {
            return null
        }

    }

    /**
     * 日期字符串转换成Date 不包含Time

     * @param dateTimeStr
     * *
     * @return
     */
    fun toDateNoDay(dateTimeStr: String?): Date? {
        if (dateTimeStr == null || dateTimeStr == "") {
            return null
        }
        val sdf = SimpleDateFormat(DATE_NODAY)
        try {
            return sdf.parse(dateTimeStr)
        } catch (e1: ParseException) {
            return null
        }

    }

    /**
     * 日期字符串转换成Date 包含Time

     * @param dateTimeStr
     * *
     * @return
     */
    fun toDateTime(dateTimeStr: String?): Date? {
        if (dateTimeStr == null || dateTimeStr == "") {
            return null
        }
        val sdf = SimpleDateFormat(DATETIME)
        try {
            return sdf.parse(dateTimeStr)
        } catch (e1: ParseException) {
            return null
        }

    }

    fun is1Min(lastTime: Long): Boolean {
        return System.currentTimeMillis() - lastTime >= 60 * 1000
    }

    /**
     * 日期时间字符串转换成时间只包含Time

     * @return
     */
    fun toTime(date: Date?): String? {
        if (date == null)
            return null
        val sdf = SimpleDateFormat(TIME)
        try {
            return sdf.format(date)
        } catch (e1: Exception) {
            return null
        }

    }

    /**
     * 日期Date转换成指定的格式

     * @param date
     * *
     * @param pattern
     * *
     * @return
     */
    fun toPattern(date: Date?, pattern: String): String? {
        if (date == null) {
            return null
        }
        val sdf = SimpleDateFormat(pattern)
        return sdf.format(date)
    }

    /**
     * 比较两个日期 判断DATE1是否在时间date2之前

     * @param DATE1
     * *
     * @param DATE2
     * *
     * @return 1：DATE1 在 DATE2之后 -1：DATE1 在 DATE2之前 0：日期相等
     */
    fun compare_date(DATE1: String, DATE2: String): Int {
        val df = SimpleDateFormat(DATE_TIME)
        try {
            val dt1 = df.parse(DATE1)
            val dt2 = df.parse(DATE2)
            if (dt1.time > dt2.time) {
                return 1
            } else if (dt1.time < dt2.time) {
                return -1
            } else {
                return 0
            }
        } catch (exception: Exception) {
            return 0
        }

    }

    fun compareDate(DATE1: String, DATE2: String): Int {
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm")
        try {
            val dt1 = df.parse(DATE1)
            val dt2 = df.parse(DATE2)
            if (dt1.time > dt2.time) {
                return 1
            } else if (dt1.time < dt2.time) {
                return -1
            } else {
                return 0
            }
        } catch (exception: Exception) {
            return 0
        }

    }

    /**
     * 计算times开始经过seconds秒后的日期时间

     * @param startDate
     * *
     * @param seconds
     * *
     * @return
     */
    fun getDateAfterTime(startDate: String, seconds: Long): String {
        val format = SimpleDateFormat(DATETIME)
        return format.format(toDateTime(startDate)!!.time + seconds * 1000)
    }

    /**
     * @param datestr 日期字符串
     * *
     * @param day     相对天数，为正数表示之后，为负数表示之前
     * *
     * @return 指定日期字符串n天之前或者之后的日期
     */
    @SuppressLint("WrongConstant")
    fun getBeforeAfterDate(datestr: String, day: Int): String {
        val df = SimpleDateFormat("yyyy-MM-dd")
        var olddate: Date?
        try {
            df.isLenient = false
            olddate = Date(df.parse(datestr).time)
        } catch (e: ParseException) {
            throw RuntimeException("日期转换错误")
        }

        val cal = GregorianCalendar()
        cal.time = olddate

        val Year = cal.get(Calendar.YEAR)
        val Month = cal.get(Calendar.MONTH)
        val Day = cal.get(Calendar.DAY_OF_MONTH)

        val NewDay = Day + day

        cal.set(Calendar.YEAR, Year)
        cal.set(Calendar.MONTH, Month)
        cal.set(Calendar.DAY_OF_MONTH, NewDay)

        return df.format(Date(cal.timeInMillis))
    }

    /**
     * 获取一小时后的时间

     * @return
     */
    val time: Long
        get() {
            var curr = System.currentTimeMillis()
            curr += (5 * 60 * 1000).toLong()
            return curr
        }

    /**
     * 计算两日期的年份差,date1<date2 @param date1 * @param date2 * @return></date2>
     */
    @SuppressLint("WrongConstant")
    fun diffYear(date1: String, date2: String): Int {
        try {
            val d = toDate(date1)
            val d1 = toDate(date2)
            val c = Calendar.getInstance()
            c.time = d
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            c.time = d1
            val year1 = c.get(Calendar.YEAR)
            val month1 = c.get(Calendar.MONTH)
            if (month1 < month) {
                return Math.abs(year1 - year - 1)
            } else {
                return Math.abs(year1 - year)
            }
        } catch (e: Exception) {
            return 0
        }

    }

    /**
     * 计算两个日期的月份差

     * @param date1
     * *
     * @param date2
     * *
     * @return
     */
    @SuppressLint("WrongConstant")
    fun diffMonth(date1: String, date2: String): Int {
        try {
            val d = toDateNoDay(date1)
            val d1 = toDateNoDay(date2)
            val c = Calendar.getInstance()
            c.time = d
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            c.time = d1
            val year1 = c.get(Calendar.YEAR)
            val month1 = c.get(Calendar.MONTH)
            if (year == year1) {// 两个日期相差几个月，即月份差
                return Math.abs(month1 - month)
            } else {// 两个日期相差几个月，即月份差
                return Math.abs(12 * (year1 - year) + month1 - month)
            }
        } catch (e: Exception) {
            return 0
        }

    }

    /**
     * 计算两个日期间隔的天数

     * @param startDate
     * *
     * @param endDate
     * *
     * @return
     */
    @SuppressLint("WrongConstant")
    fun getDaysBetween(startDate: Date, endDate: Date): Long {
        val fromCalendar = Calendar.getInstance()
        fromCalendar.time = startDate
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0)
        fromCalendar.set(Calendar.MINUTE, 0)
        fromCalendar.set(Calendar.SECOND, 0)
        fromCalendar.set(Calendar.MILLISECOND, 0)

        val toCalendar = Calendar.getInstance()
        toCalendar.time = endDate
        toCalendar.set(Calendar.HOUR_OF_DAY, 0)
        toCalendar.set(Calendar.MINUTE, 0)
        toCalendar.set(Calendar.SECOND, 0)
        toCalendar.set(Calendar.MILLISECOND, 0)
        // return (toCalendar.getTime().getTime() -
        // fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
        return (toCalendar.timeInMillis - fromCalendar.timeInMillis) / (1000 * 3600 * 24)
    }

    /**
     * 获取d天前/后的时间

     * @param d
     * *
     * @param day
     * *
     * @return
     */
    @SuppressLint("WrongConstant")
    fun getDateBeforeDay(d: Date, day: Int, isWoman: Boolean): Date {
        val now = Calendar.getInstance()
        now.time = d
        if (isWoman) {
            now.set(Calendar.DATE, now.get(Calendar.DATE) - day)
        } else {
            now.set(Calendar.DATE, now.get(Calendar.DATE) + day)
        }
        return now.time
    }

    /**
     * 实现给定某日期，判断是星期几 <br></br>
     * date 必须yyyy-MM-dd

     * @return <br></br>
     */
    fun getWeekday(date: String?): String {
        if (date == null || "" == date || date.length == 0) {
            return ""
        }
        try {
            val sd = SimpleDateFormat("yyyy-MM-dd")
            val sdw = SimpleDateFormat("E")
            val d = sd.parse(date)
            return sdw.format(d)
        } catch (e: Exception) {
        }

        return ""
    }

    /**
     * 计算某一星期几的日期

     * @param delay 推迟的周数，0本周，-1向前推迟一周，1下周，依次类推
     * *
     * @param week  Calendar中的值 例如：Calendar.MONDAY ...等等
     * *
     * @return
     */
    @SuppressLint("WrongConstant")
    fun getDateByWeek(delay: Int, week: Int): String {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, delay * 7)
        cal.set(Calendar.DAY_OF_WEEK, week)
        return toPattern(cal.time, DATE)!!
    }

    /**
     * 返回本月第一天日期

     * @return
     */
    val currentMonthFirst: String
        @SuppressLint("WrongConstant")

        get() {
            val calendar = GregorianCalendar()
            calendar.set(Calendar.DATE, 1)
            return toPattern(calendar.time, DATE)!!
        }

    /**
     * 返回本月最后一天日期

     * @return
     */
    val currentMonthLast: String
        @SuppressLint("WrongConstant")

        get() {
            val calendar = GregorianCalendar()
            calendar.set(Calendar.DATE, 1)
            calendar.roll(Calendar.DATE, -1)
            return toPattern(calendar.time, DATE)!!
        }

    /**
     * 计算两个日期之间的所有日期 (不包含临界点)

     * @param dateFrom
     * *
     * @param dateTo
     * *
     * @return
     */
    fun getDateBetween(df: String, dt: String): List<String> {
        var dateFrom = df
        var dateTo = dt
        val list = ArrayList<String>()
        val dateFormat = "yyyy-MM-dd"
        val format = SimpleDateFormat(dateFormat)
        if (dateFrom == dateTo) {
            return list
        }
        var tmp: String
        if (dateFrom.compareTo(dateTo) > 0) { // 确保 dateFrom的日期不晚于dateTo
            tmp = dateFrom
            dateFrom = dateTo
            dateTo = tmp
        }
        tmp = format.format(toDate(dateFrom)!!.time + 3600 * 24 * 1000)
        var num = 0
        while (tmp.compareTo(dateTo) < 0) {
            list.add(tmp)
            num++
            tmp = format.format(toDate(tmp)!!.time + 3600 * 24 * 1000)
        }
        if (num == 0)
            return list
        return list
    }

    /**
     * 计算两个日期之间所有的时间(每隔60s)

     * @param dateFrom
     * *
     * @param dateTo
     * *
     * @return
     */
    fun getTimeBetween(df: String, dt: String): List<String> {
        var dateFrom = df
        var dateTo = dt
        val list = ArrayList<String>()
        val format = SimpleDateFormat(DATETIME)
        if (dateFrom == dateTo) {
            return list
        }
        var tmp: String
        if (dateFrom.compareTo(dateTo) > 0) { // 确保 dateFrom的日期不晚于dateTo
            tmp = dateFrom
            dateFrom = dateTo
            dateTo = tmp
        }
        tmp = format.format(toDate(dateFrom)!!.time + 60 * 1000)
        var num = 0
        while (tmp.compareTo(dateTo) < 0) {
            list.add(tmp)
            num++
            tmp = format.format(toDateTime(tmp)!!.time + 60 * 1000)
        }
        if (num == 0)
            return list
        return list
    }

    /**
     * 返回当前日期时间

     * @return Date
     */
    fun getNowDate(l: Long): Date {
        return Date(l)
    }

    fun getDatas(l: Long): String {
        val sdf = SimpleDateFormat(DATE_TIME)
        return sdf.format(getNowDate(l))
    }

    /**
     * yyyy-MM-dd HH:mm:ss"格式返回当前时间

     * @return String
     */
    val nowString: String
        get() {
            val sdf = SimpleDateFormat(DATETIME)
            return sdf.format(getNowDate(System.currentTimeMillis()))
        }

    /**
     * yyyy-MM-dd"格式返回当前时间

     * @return String
     */
    val nowStrings: String
        get() {
            val sdf = SimpleDateFormat(DATE)
            return sdf.format(getNowDate(System.currentTimeMillis()))
        }

    fun getData(time: Long, type: String): String {
        val sdf = SimpleDateFormat(type)
        return sdf.format(Date(time))
    }

    /**
     * 根据指定格式返回当前日期时间

     * @return String
     */
    fun getNowString(pattern: String): String {
        val sdf = SimpleDateFormat(pattern)
        return sdf.format(getNowDate(System.currentTimeMillis()))
    }

    fun deleteYear(time: String): String {
        return time.substring(time.indexOf("-") + 1)
    }

    fun deleteDay(time: String): String {
        return time.substring(0, time.lastIndexOf("-"))
    }


    /**
     * 获取UTC时间 (取自0001年1月1日午夜12:00以来UTC毫微秒)

     * @return
     */
    val utcTime: Long
        @SuppressLint("WrongConstant")

        get() {
            val mCalendar = Calendar.getInstance()
            val zoneOffset = mCalendar.get(Calendar.ZONE_OFFSET)
            val dstOffset = mCalendar.get(Calendar.DST_OFFSET)
            mCalendar.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset))
            return mCalendar.timeInMillis * 10000 + 621355968000000000L
        }

    /**
     * 将2016/5/1 20:07:10 格式的日期转成5-1 20:07

     * @param time
     * *
     * @return
     */
    fun changeTime(time: String): String {
        val t = time.replace(time.substring(0, 5), "")
        val string = t.replace(t.substring(t.length - 3, t.length), "")
        return string.replace("/", "-")
    }

}
