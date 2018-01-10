package com.java.bilibili.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class DateUtil {
    public static final String DATE_NODAY = "yyyy-MM";
    public static final String DATE = "yyyy-MM-dd";
    public static final String DATEMONTHCZ = "yyyy年MM月";
    public static final String DATESTR = "yyyyMMdd";
    public static final String TIME = "HH:mm:ss";
    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME = "yyyy-MM-dd  HH:mm";
    public static final String PRECISE = "yyyy-MM-dd HH.mm.ss.SSS";
    public static final String $PRECISE = "yyyy-MM-dd$HH.mm.ss";
    public static final String DATETIMESTR = "yyyyMMddHHmmss";
    public static final String TIMESTR = "HHmmss";
    /**
     * 根据日期返回对应当前月的最大天数
     *
     * @return
     */
    public static int getMaxDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据日期返回年
     *
     * @param date
     * @return date为null时返回0
     */
    public static int getYear(Date date) {
        return get(date, Calendar.YEAR);
    }

    /**
     * 根据日期返回年
     *
     * @param date
     * @return date为null时返回0
     */
    public static int getYear(String date) {
        return get(toDate(date), Calendar.YEAR);
    }

    /**
     * 根据日期返回月
     *
     * @param date
     * @return date为null时返回0
     */
    public static int getMonth(Date date) {
        return get(date, Calendar.MONTH);
    }

    /**
     * 根据日期返回月
     *
     * @param date
     * @return date为null时返回0
     */
    public static int getMonth(String date) {
        return get(toDate(date), Calendar.MONTH);
    }

    /**
     * 根据日期返回天
     *
     * @param date
     * @return date为null时返回0
     */
    public static int getDay(Date date) {
        return get(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据日期返回天
     *
     * @param date
     * @return date为null时返回0
     */
    public static int getDay(String date) {
        return get(toDate(date), Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前小时 (24小时制)
     *
     * @return
     */
    public static int getHour() {
        return get(getNowDate(System.currentTimeMillis()), Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取指定日期时间 的 小时 (24小时制)
     *
     * @param dateTimeStr
     * @return
     */
    public static int getHour(String dateTimeStr) {
        return get(toDateTime(dateTimeStr), Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前分钟 (24小时制)
     *
     * @return
     */
    public static int getMin() {
        return get(getNowDate(System.currentTimeMillis()), Calendar.MINUTE);
    }

    /**
     * 获取指定日期时间的 分钟 (24小时)
     *
     * @param dateTimeStr
     * @return
     */
    public static int getMin(String dateTimeStr) {
        return get(toDateTime(dateTimeStr), Calendar.MINUTE);
    }

    public static int get(Date date, int type) {
        if (date == null) {
            return 0;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(type);
    }

    /**
     * 日期字符串转换成指定的格式
     *
     * @param dateString
     * @param pattern
     * @return
     */
    public static String toPattern(String dateString, String pattern) {
        if (dateString == null || dateString.equals("")) {
            return null;
        }
        if (pattern == null || pattern.equals("")) {
            throw new RuntimeException("toPattern is null");
        }
        Date date = null;
        if (pattern.equals(DateUtil.DATE) || pattern.equals(DateUtil.DATESTR)
                || pattern.equals(DateUtil.DATEMONTHCZ))
            date = toDate(dateString);
        else
            date = toDateTime(dateString);
        return toPattern(date, pattern);
    }

    /**
     * 日期字符串转换成Date 不包含Time
     *
     * @param dateTimeStr
     * @return
     */
    public static Date toDate(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.equals("")) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        try {
            return sdf.parse(dateTimeStr);
        } catch (ParseException e1) {
            return null;
        }
    }

    /**
     * 日期字符串转换成Date 不包含Time
     *
     * @param dateTimeStr
     * @return
     */
    public static Date toDateNoDay(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.equals("")) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_NODAY);
        try {
            return sdf.parse(dateTimeStr);
        } catch (ParseException e1) {
            return null;
        }
    }

    /**
     * 日期字符串转换成Date 包含Time
     *
     * @param dateTimeStr
     * @return
     */
    public static Date toDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.equals("")) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
        try {
            return sdf.parse(dateTimeStr);
        } catch (ParseException e1) {
            return null;
        }
    }

    public static boolean is1Min(long lastTime) {
        return System.currentTimeMillis() - lastTime >= 60 * 1000;
    }

    /**
     * 日期时间字符串转换成时间只包含Time
     *
     * @return
     */
    public static String toTime(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(TIME);
        try {
            return sdf.format(date);
        } catch (Exception e1) {
            return null;
        }
    }

    /**
     * 日期Date转换成指定的格式
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String toPattern(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 比较两个日期 判断DATE1是否在时间date2之前
     *
     * @param DATE1
     * @param DATE2
     * @return 1：DATE1 在 DATE2之后 -1：DATE1 在 DATE2之前 0：日期相等
     */
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat(DATE_TIME);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            return 0;
        }
    }

    public static int compareDate(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            return 0;
        }
    }

    /**
     * 计算times开始经过seconds秒后的日期时间
     *
     * @param startDate
     * @param seconds
     * @return
     */
    public static String getDateAfterTime(String startDate, long seconds) {
        SimpleDateFormat format = new SimpleDateFormat(DATETIME);
        return format.format(toDateTime(startDate).getTime() + seconds * 1000);
    }

    /**
     * @param datestr 日期字符串
     * @param day     相对天数，为正数表示之后，为负数表示之前
     * @return 指定日期字符串n天之前或者之后的日期
     */
    public static String getBeforeAfterDate(String datestr, int day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date olddate = null;
        try {
            df.setLenient(false);
            olddate = new Date(df.parse(datestr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误");
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(olddate);

        int Year = cal.get(Calendar.YEAR);
        int Month = cal.get(Calendar.MONTH);
        int Day = cal.get(Calendar.DAY_OF_MONTH);

        int NewDay = Day + day;

        cal.set(Calendar.YEAR, Year);
        cal.set(Calendar.MONTH, Month);
        cal.set(Calendar.DAY_OF_MONTH, NewDay);

        return df.format(new Date(cal.getTimeInMillis()));
    }

    /**
     * 获取一小时后的时间
     *
     * @return
     */
    public static long getTime() {
        long curr = System.currentTimeMillis();
        curr += 5 * 60 * 1000;
        return curr;
    }

    /**
     * 计算两日期的年份差,date1<date2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int diffYear(String date1, String date2) {
        try {
            Date d = toDate(date1);
            Date d1 = toDate(date2);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            c.setTime(d1);
            int year1 = c.get(Calendar.YEAR);
            int month1 = c.get(Calendar.MONTH);
            if (month1 < month) {
                return Math.abs(year1 - year - 1);
            } else {
                return Math.abs(year1 - year);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 计算两个日期的月份差
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int diffMonth(String date1, String date2) {
        try {
            Date d = toDateNoDay(date1);
            Date d1 = toDateNoDay(date2);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            c.setTime(d1);
            int year1 = c.get(Calendar.YEAR);
            int month1 = c.get(Calendar.MONTH);
            if (year == year1) {// 两个日期相差几个月，即月份差
                return Math.abs(month1 - month);
            } else {// 两个日期相差几个月，即月份差
                return Math.abs(12 * (year1 - year) + month1 - month);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 计算两个日期间隔的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        // return (toCalendar.getTime().getTime() -
        // fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
        return (toCalendar.getTimeInMillis() - fromCalendar.getTimeInMillis())
                / (1000 * 3600 * 24);
    }

    /**
     * 获取d天前/后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBeforeDay(Date d, int day, boolean isWoman) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        if (isWoman) {
            now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        } else {
            now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        }
        return now.getTime();
    }

    /**
     * 实现给定某日期，判断是星期几 <br>
     * date 必须yyyy-MM-dd
     *
     * @return <br>
     */
    public static String getWeekday(String date) {
        if (date == null || "".equals(date) || date.length() == 0) {
            return "";
        }
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdw = new SimpleDateFormat("E");
            Date d = sd.parse(date);
            return sdw.format(d);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 计算某一星期几的日期
     *
     * @param delay 推迟的周数，0本周，-1向前推迟一周，1下周，依次类推
     * @param week  Calendar中的值 例如：Calendar.MONDAY ...等等
     * @return
     */
    public static String getDateByWeek(int delay, int week) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, delay * 7);
        cal.set(Calendar.DAY_OF_WEEK, week);
        return toPattern(cal.getTime(), DATE);
    }

    /**
     * 返回本月第一天日期
     *
     * @return
     */
    public static String getCurrentMonthFirst() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DATE, 1);
        return toPattern(calendar.getTime(), DATE);
    }

    /**
     * 返回本月最后一天日期
     *
     * @return
     */
    public static String getCurrentMonthLast() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        return toPattern(calendar.getTime(), DATE);
    }

    /**
     * 计算两个日期之间的所有日期 (不包含临界点)
     *
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public static List<String> getDateBetween(String dateFrom, String dateTo) {
        List<String> list = new ArrayList<String>();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        if (dateFrom.equals(dateTo)) {
            return list;
        }
        String tmp;
        if (dateFrom.compareTo(dateTo) > 0) { // 确保 dateFrom的日期不晚于dateTo
            tmp = dateFrom;
            dateFrom = dateTo;
            dateTo = tmp;
        }
        tmp = format.format(toDate(dateFrom).getTime() + 3600 * 24 * 1000);
        int num = 0;
        while (tmp.compareTo(dateTo) < 0) {
            list.add(tmp);
            num++;
            tmp = format.format(toDate(tmp).getTime() + 3600 * 24 * 1000);
        }
        if (num == 0)
            return list;
        return list;
    }

    /**
     * 计算两个日期之间所有的时间(每隔60s)
     *
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public static List<String> getTimeBetween(String dateFrom, String dateTo) {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat format = new SimpleDateFormat(DATETIME);
        if (dateFrom.equals(dateTo)) {
            return list;
        }
        String tmp;
        if (dateFrom.compareTo(dateTo) > 0) { // 确保 dateFrom的日期不晚于dateTo
            tmp = dateFrom;
            dateFrom = dateTo;
            dateTo = tmp;
        }
        tmp = format.format(toDate(dateFrom).getTime() + 60 * 1000);
        int num = 0;
        while (tmp.compareTo(dateTo) < 0) {
            list.add(tmp);
            num++;
            tmp = format.format(toDateTime(tmp).getTime() + 60 * 1000);
        }
        if (num == 0)
            return list;
        return list;
    }

    /**
     * 返回当前日期时间
     *
     * @return Date
     */
    public static Date getNowDate(long l) {
        return new Date(l);
    }

    public static String getDatas(long l) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME);
        return sdf.format(getNowDate(l));
    }

    /**
     * yyyy-MM-dd HH:mm:ss"格式返回当前时间
     *
     * @return String
     */
    public static String getNowString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
        return sdf.format(getNowDate(System.currentTimeMillis()));
    }

    /**
     * yyyy-MM-dd"格式返回当前时间
     *
     * @return String
     */
    public static String getNowStrings() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        return sdf.format(getNowDate(System.currentTimeMillis()));
    }

    public static String getData(long time, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(new Date(time));
    }

    /**
     * 根据指定格式返回当前日期时间
     *
     * @return String
     */
    public static String getNowString(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(getNowDate(System.currentTimeMillis()));
    }

    public static String deleteYear(String time) {
        return time.substring(time.indexOf("-") + 1);
    }

    public static String deleteDay(String time) {
        return time.substring(0, time.lastIndexOf("-"));
    }


    /**
     * 获取UTC时间 (取自0001年1月1日午夜12:00以来UTC毫微秒)
     *
     * @return
     */
    public static long getUTCTime() {
        Calendar mCalendar = Calendar.getInstance();
        int zoneOffset = mCalendar.get(Calendar.ZONE_OFFSET);
        int dstOffset = mCalendar.get(Calendar.DST_OFFSET);
        mCalendar.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        return (mCalendar.getTimeInMillis() * 10000) + 621355968000000000L;
    }

    /**
     * 将2016/5/1 20:07:10 格式的日期转成5-1 20:07
     *
     * @param time
     * @return
     */
    public static String changeTime(String time) {
        String t = time.replace(time.substring(0, 5), "");
        String string = t.replace(t.substring(t.length() - 3, t.length()), "");
        return string.replace("/", "-");
    }
}
