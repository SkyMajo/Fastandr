package fastandr.hotapk.cn.mylibrary.fastandr.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 */
public final class DateUtil {

    /**
     * 秒
     */
    public static final long SECOND = 1000;
    /**
     * 分
     */
    public static final long MINUTE = 60 * SECOND;
    /**
     * 时
     */
    public static final long HOUR = 60 * MINUTE;
    /**
     * 天
     */
    public static final long DAY = 24 * HOUR;

    private static ThreadLocal<SimpleDateFormat> format = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }

        @Override
        public SimpleDateFormat get() {
            SimpleDateFormat format = super.get();
            format.applyPattern("yyyy-MM-dd HH:mm:ss");
            return format;
        }
    };

    /**
     * 当前时间
     *
     * @return
     */
    public static Date now() {
        return new Date(new Date().getTime() / 1000 * 1000);
    }

    /**
     * 当前时间字符串（yyyy-MM-dd HH:mm:ss）
     *
     * @return
     */
    public static String nowStr() {
        return format.get().format(now());
    }

    /**
     * 当前时间字符串
     *
     * @param pattern 格式
     * @return
     */
    public static String nowStr(String pattern) {
        SimpleDateFormat _format = format.get();
        _format.applyPattern(pattern);
        return _format.format(now());
    }

    /**
     * 日期转时间
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format.get().format(date);
    }

    /**
     * 日期转时间
     *
     * @param date
     * @param pattern 格式
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat _format = format.get();
        _format.applyPattern(pattern);
        return _format.format(date);
    }

    /**
     * 字符转日期
     *
     * @param dateStr
     * @return
     */
    public static Date parse(String dateStr) throws Exception {
        return format.get().parse(dateStr);
    }

    /**
     * 字符转日期
     *
     * @param dateStr
     * @param pattern 格式
     * @return
     */
    public static Date parse(String dateStr, String pattern) throws Exception {
        SimpleDateFormat _format = format.get();
        _format.applyPattern(pattern);
        return _format.parse(dateStr);
    }

    /**
     * XXXXX前（3天前）
     *
     * @param date
     * @return
     */
    public static String past(Date date) {
        long temp = now().getTime() - date.getTime();
        if (temp < 0)
            return "";
        else if (temp < MINUTE)
            return temp / SECOND + "秒前";
        else if (temp < HOUR)
            return temp / MINUTE + "分钟前";
        else if (temp < DAY)
            return temp / HOUR + "小时前";
        else
            return temp / DAY + "天前";
    }

    /**
     * 时间段（毫秒）
     *
     * @param d1 时间1
     * @param d2 时间2
     * @return
     */
    public static long betweenMsec(Date d1, Date d2) {
        long l1 = d1.getTime();
        long l2 = d2.getTime();
        return Math.abs(l1 - l2);
    }


    /**
     * 时间段（秒）
     *
     * @param d1 时间1
     * @param d2 时间2
     * @return
     */
    public static Integer betweenSecond(Date d1, Date d2) {
        long l1 = d1.getTime();
        long l2 = d2.getTime();
        long temp = Math.abs(l1 - l2);
        return (int) (temp / SECOND);
    }

    /**
     * 时间段（分）
     *
     * @param d1 时间1
     * @param d2 时间2
     * @return
     */
    public static Integer betweenMinute(Date d1, Date d2) {
        return betweenSecond(d1, d2) / 60;
    }

    /**
     * 时间段（时）
     *
     * @param d1 时间1
     * @param d2 时间2
     * @return
     */
    public static Integer betweenHour(Date d1, Date d2) {
        return betweenMinute(d1, d2) / 60;
    }

    /**
     * 时间段（天）
     *
     * @param d1 时间1
     * @param d2 时间2
     * @return
     */
    public static Integer betweenDay(Date d1, Date d2) {
        return betweenHour(d1, d2) / 24;
    }

    /**
     * 检查时间区间
     *
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static boolean between(Date start, Date end, Date target) {
        long s = start.getTime();
        long e = end.getTime();
        long t = target.getTime();
        return s <= t && e >= t;
    }

    /**
     * 时间集合
     *
     * @param start
     * @param end
     * @return
     */
    public static List<Date> dateList(Date start, Date end) {
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(start);
        int number = betweenDay(start, end);
        Date temp = start;
        for (int i = 0; i < number; i++) {
            temp = dateAdd(temp, 1);
            dates.add(temp);
        }
        dates.add(end);
        return dates;
    }

    /**
     * 时间集合
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> dateListStr(Date start, Date end) {
        return dateListStr(start, end, "yyyy-MM-dd");
    }

    /**
     * 时间集合
     *
     * @param start
     * @param end
     * @param pattern
     * @return
     */
    public static List<String> dateListStr(Date start, Date end, String pattern) {
        ArrayList<String> dates = new ArrayList<>();
        dates.add(format(start, pattern));
        int number = betweenDay(start, end);
        Date temp = start;
        for (int i = 0; i < number; i++) {
            temp = dateAdd(temp, 1);
            dates.add(format(temp, pattern));
        }
        dates.add(format(end, pattern));
        return dates;
    }

    /**
     * 日期运算
     *
     * @param date
     * @param number 正数往后，负数往前
     * @return
     */
    public static Date dateAdd(Date date, int number) {
        return dateAdd(date, number, Calendar.DAY_OF_YEAR);
    }

    /**
     * 日期运算
     *
     * @param date
     * @param number 正数往后，负数往前
     * @param type   Calendar常量
     * @return
     */
    public static Date dateAdd(Date date, int number, int type) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(type, number);
        return c.getTime();
    }

    /**
     * 开始时间是否在结束时间之前
     *
     * @param start
     * @param end
     * @return
     */
    public static boolean front(Date start, Date end) {
        return end.getTime() > start.getTime();
    }

}
