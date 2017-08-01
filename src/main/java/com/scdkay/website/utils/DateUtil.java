package com.scdkay.website.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 时间工具类
 * Created by liurui on 2017/7/10.
 */
public class DateUtil {

    /**
     * 本地化
     */
    public static final Locale LOCALE_CN = Locale.CHINA;

    /**
     * 得到当前日期时间的字符串。
     *
     * @param format 日期格式，如yyyy-MM-dd HH:mm:ss
     * @return 当前日期字符串
     */
    public static String currentDate(String format) {
        String currentDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, LOCALE_CN);
            Calendar calendar = Calendar.getInstance();
            currentDate = sdf.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentDate;
    }

    /**
     * 获取当前时间的Long型
     *
     * @param format 格式
     * @return 返回long
     */
    public static long currentTime(String format) {
        String currentDate = currentDate(format);
        return dateFormat(currentDate, format).getTime();
    }

    /**
     * 将字符串转换成指定格式日期
     *
     * @param dateStr 字符串
     * @param format  格式 如果格式为null，默认格式：yyyy-MM-dd
     * @return 日期
     */
    public static Date dateFormat(String dateStr, String format) {
        return dateFormat(dateStr, format, TimeZone.getTimeZone("GMT+8"));
    }

    /**
     * 将字符串转换成指定格式日期
     *
     * @param dateStr  字符串
     * @param format   格式 如果格式为null，默认格式：yyyy-MM-dd
     * @param timeZone 时区
     * @return 日期
     */
    public static Date dateFormat(String dateStr,
                                  String format,
                                  TimeZone timeZone) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format, LOCALE_CN);
        sdf.setTimeZone(timeZone);
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取milliseconds表示的日期的字符串
     *
     * @param milliseconds 日期的milliseconds
     * @param format       格式化字符串，如"yyyy-MM-dd HH:mm:ss"
     * @return String 日期的字符串表示
     */
    public static String dateFormat(long milliseconds, String format) {
        return dateFormat(milliseconds, format, TimeZone.getTimeZone("GMT+8"));
    }

    /**
     * 获取milliseconds表示的日期的字符串
     *
     * @param milliseconds 日期的milliseconds
     * @param format       格式化字符串，如"yyyy-MM-dd HH:mm:ss"
     * @param timeZone     时区
     * @return String 日期的字符串表示
     */
    public static String dateFormat(long milliseconds,
                                    String format,
                                    TimeZone timeZone) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, LOCALE_CN);
            sdf.setTimeZone(timeZone);
            Date date = new Date(milliseconds);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前时间所在当前周的周开始和结束时间
     *
     * @return 开始和结束时间
     */
    public static long[] getTimeForWeekStartEnd() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        c.setTimeInMillis(c.getTimeInMillis() / 1000 * 1000); // 去掉毫秒
        c.set(Calendar.SECOND, 0); // 去掉秒
        c.set(Calendar.MINUTE, 0); // 去掉分
        c.set(Calendar.HOUR, 0);
        // 获取当前毫秒值
        long curTime = c.getTimeInMillis();
        // 获取当天的星期数
        int week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (week == 0) // 周日
            week = 7;
        long day = 24 * 60 * 60 * 1000; // 一天毫秒数
        // 计算所剩天数
        long futTime = (7 - week) * day;
        // 计算已经消耗天数
        long alrTime = (week - 1) * day;
        long[] result = new long[2];
        result[0] = curTime - alrTime;
        result[1] = curTime + futTime;
        return result;
    }

    /**
     * 获取当天的开始时间
     *
     * @return 开始和结束时间
     */
    public static long[] getTimeForDayStartEnd() {
        long[] result = new long[2];
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        c.setTimeInMillis(c.getTimeInMillis() / 1000 * 1000); // 去掉毫秒
        c.set(Calendar.SECOND, 0); // 去掉秒
        c.set(Calendar.MINUTE, 0); // 去掉分
        c.set(Calendar.HOUR, 0);
        // 获取当前毫秒值
        result[0] = c.getTimeInMillis();
        result[1] = result[0] + 24 * 60 * 60 * 1000;
        return result;
    }

    public static String convertTime(String srcTime, TimeZone timeZone) {
        if (StringUtil.isEmpty(srcTime))
            return "";
        return convertTime(srcTime, timeZone, "yyyy-MM-dd");
    }

    /**
     * UTC时间转换
     *
     * @param srcTime  时间
     * @param timezone 时区
     * @return 时间字符串 转换
     */
    public static String convertTime(String srcTime,
                                     TimeZone timezone,
                                     String format) {
        if (StringUtil.isEmpty(srcTime))
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS",
                Locale.CHINA);
        SimpleDateFormat dspFmt = new SimpleDateFormat(format, Locale.CHINA);
        String convertTime;
        Date result_date;
        long result_time;
        // 如果传入参数异常，使用本地时间
        if (null == srcTime)
            result_time = System.currentTimeMillis();
        else {
            try { // 将输入时间字串转换为UTC时间
                sdf.setTimeZone(TimeZone.getTimeZone("GMT00:00"));
                result_date = sdf.parse(srcTime);
                result_time = result_date.getTime();
            } catch (Exception e) { // 出现异常时，使用本地时间
                result_time = System.currentTimeMillis();
                dspFmt.setTimeZone(TimeZone.getDefault());
                convertTime = dspFmt.format(result_time);
                return convertTime;
            }
        }
        // 设定时区
        dspFmt.setTimeZone(timezone);
        convertTime = dspFmt.format(result_time);
        return convertTime;
    }
}