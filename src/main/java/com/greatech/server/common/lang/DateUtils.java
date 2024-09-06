package com.greatech.server.common.lang;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


/**
 * 时间工具类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static final TimeZone GMT8_TIMEZONE = TimeZone.getTimeZone("GMT+8");

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    private static final String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyyMM"};

    public static Date getGMT8Time() {
        return Calendar.getInstance(GMT8_TIMEZONE).getTime();
    }

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2022/08/08
     */
    public static String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20220808
     */
    public static String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * date转换为java8的localDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * localdate转换为date
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 获取当月的第一天
     */
    public static LocalDate getFirstDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     *
     */
    public static String getSeason(Date date) {
        String season = null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = "第一季度";
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = "第二季度";
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = "第三季度";
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = "第四季度";
                break;
            default:
                break;
        }
        return season;
    }

    /**
     *
     */
    public static String getMonth(Date date) {
        LocalDate localDate = dateToLocalDate(date);
        return String.valueOf(localDate.getMonth().getValue());
    }

    /**
     *
     */
    public static Date getEndMonth(List<Date> startEndMonth, String timeItem, String type) {
        if (timeItem == null) {
            return startEndMonth.get(1);
        }
        Date end = startEndMonth.get(1);
        if ("总计".equals(timeItem)) {
            return end;
        }
        String year = timeItem.substring(0, 4);
        Date date;
        if ("按月统计".equals(type)) {
            String month;
            if (timeItem.length() == 7) {
                month = timeItem.substring(5, 6);
            } else {
                month = timeItem.substring(5, 7);
            }
            date = parseDate(year + month);
            return date;
        } else if ("按季度统计".equals(type)) {
            if (timeItem.substring(4).equals("第一季度")) {
                date = parseDate(year + "03");
            } else if (timeItem.substring(4).equals("第二季度")) {
                date = parseDate(year + "06");

            } else if (timeItem.substring(4).equals("第三季度")) {
                date = parseDate(year + "09");
            } else {
                date = parseDate(year + "12");
            }
        } else if ("按半年统计".equals(type)) {
            if (timeItem.substring(4).equals("上半年")) {
                date = parseDate(year + "06");
            } else {
                date = parseDate(year + "12");
            }
        } else {
            date = parseDate(year + "12");
        }
        if (end.compareTo(date) < 0) {
            return end;
        } else {
            return date;
        }
    }


    /**
     *
     */
    public static String getHalfYear(Date date) {
        String halfYear = null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                halfYear = "上半年";
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                halfYear = "下半年";
                break;
            default:
                break;
        }
        return halfYear;
    }

    /**
     *
     */
    public static int getBetweenMonth(List<Date> startEndMonth) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startEndMonth.get(0));
        end.setTime(startEndMonth.get(1));
        int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
        return result + month;
    }

    /**
     *
     */
    public static boolean before(Date time, Date time1) {
        return time.compareTo(time1) < 0;
    }

    /**
     *
     */
    public static Integer getMonthSize(String type) {
        if ("按月统计".equals(type)) {
            return 1;
        } else if ("按季度统计".equals(type)) {
            return 3;
        } else if ("按半年统计".equals(type)) {
            return 6;
        } else {
            return 12;
        }
    }


    /**
     *
     */
    public static Date getStartMonth(Date startDate, String timeItem, String type) {
        if ("总计".equals(timeItem)) {
            return startDate;
        }
        if (timeItem == null) {
            return startDate;
        }
        String year = timeItem.substring(0, 4);
        Date date;
        if ("按月统计".equals(type)) {
            String month;
            if (timeItem.length() == 7) {
                month = timeItem.substring(5, 6);
            } else {
                month = timeItem.substring(5, 7);
            }
            date = parseDate(year + month);
            return date;
        } else if ("按季度统计".equals(type)) {
            if (timeItem.substring(4).equals("第一季度")) {
                date = parseDate(year + "01");
            } else if (timeItem.substring(4).equals("第二季度")) {
                date = parseDate(year + "04");
            } else if (timeItem.substring(4).equals("第三季度")) {
                date = parseDate(year + "07");
            } else {
                date = parseDate(year + "10");
            }
        } else if ("按半年统计".equals(type)) {
            if (timeItem.substring(4).equals("上半年")) {
                date = parseDate(year + "01");
            } else {
                date = parseDate(year + "06");
            }
        } else {
            date = parseDate(year + "01");
        }
        if (startDate.compareTo(date) > 0) {
            return startDate;
        } else {
            return date;
        }
    }
}
