package util;

import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    public static Date timeStampMaxDate = null;
    public static Date timeStampMinDate = null;
    private static Date dateTimeMinDate = null;
    private static Date dateTimeMaxDate = null;

    private static final String MIN_DATE_STRING = "1000-01-01";
    private static final String MAX_DATE_STRING = "9999-01-01";

    private static final String MIN_TIME_STAMP_STRING = "1970-01-02";
    private static final String MAX_TIME_STAMP_STRING = "2038-01-18";

    static {
        try {
            timeStampMaxDate = parseConDate(MAX_TIME_STAMP_STRING);
            timeStampMinDate = parseConDate(MIN_TIME_STAMP_STRING);
            dateTimeMaxDate = parseConDate(MAX_DATE_STRING);
            dateTimeMinDate = parseConDate(MIN_DATE_STRING);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Date parse_yyyyMMdd(String dateStr) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        return sf.parse(dateStr);
    }

    public static String getChineseAll(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return sf.format(date);
    }

    public static String toConString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(date);
    }

    public static String toYYMMdd(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        return sf.format(date);

    }

    public static Date parseConDate(String dateStr) throws ParseException {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.parse(dateStr);
    }

    public static Date parseMinuteDate(String dateStr) throws ParseException {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sf.parse(dateStr);
    }

    public static Date parseSecondDate(String dateStr) throws ParseException {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.parse(dateStr);
    }


    public static Date getDateStart(String targetDay) {
        try {
            Date date = DateUtil.parseConDate(targetDay);
            return DateUtil.getDateStart(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getDateStart(Date targetDay) {
        if (targetDay == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(targetDay);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getDateEnd(String targetDay) {
        try {
            Date date = DateUtil.parseConDate(targetDay);
            return DateUtil.getDateEnd(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getDateEnd(Date targetDay) {
        if (targetDay == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(targetDay);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    public static Date getBeforeDayStart(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - n);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getAfterDay(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + n);
        return calendar.getTime();
    }

    public static Date getBeforeDay(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - n);
        return calendar.getTime();
    }

    public static Date getTodayStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getTodayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getDatePreDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.DATE, -day);
        return calendar.getTime();
    }

    public static Date getDatePreHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.HOUR_OF_DAY, -hour);
        return calendar.getTime();
    }

    public static Date getDatePreMinutes(int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -minutes);
        return calendar.getTime();
    }

    public static Date getDatePreSecond(int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.SECOND, -seconds);
        return calendar.getTime();
    }

    public static Date getNextDay(Date date) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);

        return calendar.getTime();
    }

    public static boolean equals(Date date1, Date date2) {
        if (date1 == null && date2 == null) {
            return true;
        } else if (date1 != null && date2 == null) {
            return false;
        } else if (date1 == null && date2 != null) {
            return false;
        } else {
            return date1.getTime() == date2.getTime();
        }
    }

    public static Long getTime(Date date) {
        if (date == null) {
            return null;
        }

        return date.getTime();
    }

    public static long getBetweenDays(Date start, Date end) {
        return ChronoUnit.DAYS.between(start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public static Long diffSecondsToNow(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return ChronoUnit.SECONDS.between(localDateTime, LocalDateTime.now());
    }

    public static Long diffYearsToNow(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return ChronoUnit.YEARS.between(localDateTime, LocalDateTime.now());
    }

    public static String getWholeString(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(date);
    }

    public static String getMinuteString(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sf.format(date);
    }

    /**
     * @Description: 毫秒数转 HH:mm:ss 格式时间
     * @Param time 毫秒
     * @Return: java.lang.String
     * @Author: wangzibin
     * @Date: 2021/3/1
     */
    public static String getGapTime(long time) {
        long hours = time / (1000 * 60 * 60);
        long minutes = (time - hours * (1000 * 60 * 60)) / (1000 * 60);
        long second = (time - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / 1000;
        String diffTime = hours < 10 ? "0" + hours : hours + "";
        diffTime = minutes < 10 ? diffTime + ":0" + minutes : diffTime + ":" + minutes;
        diffTime = second < 10 ? diffTime + ":0" + second : diffTime + ":" + second;
        return diffTime;
    }

    /**
     * @Description: 毫秒数转 m/mm:ss 格式时间
     * @Param time 毫秒
     * @Return: java.lang.String
     * @Author: wangzibin
     * @Date: 2021/3/1
     */
    public static String getGapTimeMm(long time) {
        long minutes = time / (1000 * 60);
        long second = (time - minutes * (1000 * 60)) / 1000;
        String diffTime = minutes < 10 ? "0" + minutes : minutes + "";
        diffTime = second < 10 ? diffTime + ":0" + second : diffTime + ":" + second;
        return diffTime;
    }

    public static Date getMaxDate(Date date1, Date date2) {
        if (date1 == null) {
            return date2;
        }
        if (date2 == null) {
            return date1;
        }
        return date1.compareTo(date2) >= 0 ? date1 : date2;
    }

    public static Long diffHoursToNow(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return ChronoUnit.HOURS.between(localDateTime, LocalDateTime.now());
    }

    //由出生日期获得年龄
    public static int getAge(Date birthDay) {
        if (birthDay == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            return 0;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        boolean lowAge = monthBirth == monthNow && dayOfMonthNow < dayOfMonthBirth;

        if (monthNow < monthBirth || lowAge) {
            age--;
        }
        return age;
    }


    public static void main(String[] args) throws Exception {
//        Date date1 = new Date();
//        System.out.println(date1);
//        Thread.sleep(1000);
//        Date date2 = new Date();
//        System.out.println(date2);
        System.out.println(parseMinuteDate("2022-02-02 11:22"));
        System.out.println(getAge(parse_yyyyMMdd("20020228")));
    }


    public static Date getTimeStampMaxDate() {
        if (timeStampMaxDate == null) {
            try {
                timeStampMaxDate = parseConDate(MAX_TIME_STAMP_STRING);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return timeStampMaxDate;
    }

    public static Date getTimeStampMinDate() {
        if (timeStampMinDate == null) {
            try {
                timeStampMinDate = parseConDate(MIN_TIME_STAMP_STRING);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return timeStampMinDate;
    }

    public static Date getDateTimeMaxDate() {
        if (dateTimeMaxDate == null) {
            try {
                dateTimeMaxDate = parseConDate(MAX_DATE_STRING);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dateTimeMaxDate;
    }

    public static Date getDateTimeMinDate() {
        if (dateTimeMinDate == null) {
            try {
                dateTimeMinDate = parseConDate(MIN_DATE_STRING);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dateTimeMinDate;
    }


    public static Long parseDate(String dateStr) {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            return sf.parse(dateStr).getTime();
        } catch (Exception e) {
        }
        return null;
    }

    public static String format(Long timestamp) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(timestamp);
    }

}
