package com.aki.service.impl;

import com.aki.service.JodaTime;
import org.joda.time.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JodaTimeImpl implements JodaTime {
    @Override
    public void createJoda() {
        //方法一：取系统点间
        DateTime dt1 = new DateTime();
        //方法二：通过java.util.Date对象生成
        DateTime dt2 = new DateTime(new Date());
        //方法三：指定年月日点分秒生成(参数依次是：年,月,日,时,分,秒,毫秒)
        DateTime dt3 = new DateTime(2012, 5, 20, 13, 14, 0, 0);
        //方法四：ISO8601形式生成
        DateTime dt4 = new DateTime("2012-05-20");
        DateTime dt5 = new DateTime("2012-05-20T13:14:00");
        //只需要年月日的时候
        LocalDate localDate = new LocalDate(2009, 9, 6);// September 6, 2009
        //只需要时分秒毫秒的时候
        LocalTime localTime = new LocalTime(13, 30, 26, 0);// 1:30:26PM

        //其他构造函数，可使用不同的构造函数快速获取DateTime对象
//        DateTime(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour)
//        DateTime(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, int secondOfMinute)
//        DateTime(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, int secondOfMinute, int millisOfSecond)
//        DateTime(long instant)
//        DateTime(Object instant)

        //还有一种方法就是使用静态方法来获取DateTime对象
//        now()                                           返回获取当前DateTime
//        parse(String str, DateTimeFormatter formatter)  返回指定String值的DateTime
    }

    @Override
    public void getDateAndTime() {
        DateTime dt = new DateTime();
        //年
        int year = dt.getYear();
        //月
        int month = dt.getMonthOfYear();
        //日
        int day = dt.getDayOfMonth();
        //星期
        int week = dt.getDayOfWeek();
        //点
        int hour = dt.getHourOfDay();
        //分
        int min = dt.getMinuteOfHour();
        //秒
        int sec = dt.getSecondOfMinute();
        //毫秒
        int msec = dt.getMillisOfSecond();

        //        DateTime中的常用属性值获取方法
        //        getCenturyOfEra()               返回世纪单位(int)
        //        getYearOfCentury()              返回世纪年份(int)
        //        getYear()                       返回年(int)
        //        getWeekyear()                   返回对应年中周数(int)
        //        getMonthOfYear()                返回对应年的月数(int)
        //        getDayOfYear()                  返回对应年中天数(int)
        //        getDayOfMonth()                 返回对应月份中天数(int)
        //        getDayOfWeek()                  返回对应星期中天数(int)
        //        getHourOfDay()                  返回对应天中的小时(int)
        //        getMinuteOfDay()                返回对应天中的分钟数(int)
        //        getMinuteOfHour()               返回对应小时中的分钟数(int)
        //        getSecondOfDay()                返回对应天中的秒数(int)
        //        getSecondOfMinute()             返回对应分钟中的秒数(int)
        //        getMillis()                     返回毫秒数(int)
        //        getMillisOfDay()                返回对应天中的毫秒(int)
        //        getMillisOfSecond()             返回对应秒中的毫秒(int)
        //        getHourOfDay()                  返回对应天中的小时(int)
        //        toString(String pattern)        返回一个规定格式的String

        //        DateTime中的常用方法
        //        1. plus/minus开头的方法（比如：plusDay, minusMonths）：用来返回在DateTime实例上增加或减少一段时间后的实例
        //        plus(long duration)             增加指定毫秒数并返回
        //        plusYears(int years)            增加指定年份并返回
        //        plusMonths(int months)          增加指定月份并返回
        //        plusWeeks(int weeks)            增加指定星期并返回
        //        plusDays(int days)              增加指定天数并返回
        //        plusHours(int hours)            增加指定小时并返回
        //        plusMinutes(int minutes)        增加指定分钟并返回
        //        plusSeconds(int seconds)        增加指定秒数并返回
        //        plusMillis(int millis)          增加指定毫秒并返回
        //       与之相反的是minus前缀的 plus是增加 minus是减少
        //
        //        2. with开头的方法：用来返回在DateTime实例更新指定日期单位后的实例
        //        withCenturyOfEra(int centuryOfEra)  更新时间世纪单位并返回
        //        withYearOfCentury(int yearOfCentury)更新世纪年并返回
        //        withYear(int year)              更新时间年并返回
        //        withWeekyear(int weekyear)      更新时间周数并返回
        //        withMonthOfYear(int monthOfYear)更新时间月份并返回
        //        withDayOfYear(int dayOfYear)    更新时间天数并返回
        //        withDayOfMonth(int dayOfMonth)  更新时间天数并返回
        //        withDayOfWeek(int dayOfWeek)    更新时间天数并返回
        //        withHourOfDay(int hour)         更新时间小时并返回
        //        withMinuteOfHour(int minute)    更新时间分钟并返回
        //        withSecondOfMinute(int second)  更新时间秒数并返回
        //        withMillisOfSecond(int millis)  更新时间毫秒并返回
        //        withMillisOfDay(int millis)     更新时间毫秒并返回
        //        withTimeAtStartOfDay()          获取当天最早时间
        //
        //        3. 判断DateTime对象大小状态的一些操作方法
        //        compareTo(DateTime d)           比较两时间大小 时间大于指定时间返回 1 时间小于指定时间返回-1 相等返回0
        //        equals(DateTime d)              比较两时间是否相等
        //        isAfter(long instant)           判断时间是否大于指定时间
        //        isAfterNow()                    判断时间是否大于当前时间
        //        isBefore(long instant)          判断时间是否小于指定时间
        //        isBeforeNow()                   判断时间是否小于当前时间
        //        isEqual(long instant)           判断时间是否等于指定时间
        //        isEqualNow()                    判断时间是否等于当前时间
        //
        //        4. jdk date互转
        //        DateTime dt = new DateTime(new Date()); jdk的date转换为DateTime
        //        Date jdkDate = dt.toDate()      转换为jdk的date

        //        Property
        //        除了基本get方法之外，jodatime为每一个时间类创建一个内部静态类，叫Property，便于访问实例中的各个字段，使Joda Time功能更加丰富。
        //        centuryOfEra()
        //        yearOfCentury()
        //        yearOfEra()
        //        year()
        //        weekyear()
        //        weekOfWeekyear()
        //        monthOfYear()
        //        dayOfYear()
        //        dayOfMonth()
        //        dayOfWeek()
        //        hourOfDay()
        //        minuteOfDay()
        //        minuteOfHour()
        //        secondOfDay()
        //        secondOfMinute()
        //        millisOfDay()
        //        millisOfSecond()
        //        方法
        //        addToCopy(int value)            日期属性增加value并返回datetime
        //        setCopy(int value)              日期属性替换成value并返回datetime
        //        withMaximumValue()              返回日期属性最大值的datetime
        //        withMinimumValue()              返回日期属性最小值的datetime
        //        roundFloorCopy()                返回日期属性最小值的datetime
        //        roundCeilingCopy()              返回日期属性最大值的datetime
        //        get()                           返回日期属性值int类型
        //        getAsString()                   返回日期属性值String类型
        //        getAsShortText()                返回日期属性值String类型简写
        //        getAsText()                     返回日期本地属性值String类型，如“星期五”
        //        isLeap()                        判断是闰年闰月的方法
        //        getMaximumValue                 获取属性值的最大值返回int
        //        getMinimumValue                 获取属性值的最小值返回int

        //LocalDate的使用
        LocalDate ld = new LocalDate();

        //        其他构造器
        //        LocalDate(int year, int monthOfYear, int dayOfMonth)
        //        LocalDate(long instant)
        //          其他拓展方法
        //        daysBetween(ReadableInstant start, ReadableInstant end)     获取两日期相差的天数
        //        hoursBetween(ReadableInstant start, ReadableInstant end)    获取两日期相差的小时数
        //        minutesBetween(ReadableInstant start, ReadableInstant end)  获取两日期相差的分钟数
        //        monthsBetween(ReadableInstant start, ReadableInstant end)   获取两日期相差的月数
        //        secondsBetween(ReadableInstant start, ReadableInstant end)  获取两日期相差的秒数
        //        weeksBetween(ReadableInstant start, ReadableInstant end)    获取两日期相差的周数
        //        yearsBetween(ReadableInstant start, ReadableInstant end)    获取两日期相差的年数
        ////             demo
        //        LocalDate start = new LocalDate();
        //        LocalDate end = new LocalDate().minusDays(1);
        //        System.out.println(Days.daysBetween(start, end).getDays());
    }

    @Override
    public void week() {
        DateTime dt = new DateTime();
        //星期
        switch (dt.getDayOfWeek()) {
            case DateTimeConstants.SUNDAY:
                System.out.println("星期日");
                break;
            case DateTimeConstants.MONDAY:
                System.out.println("星期一");
                break;
            case DateTimeConstants.TUESDAY:
                System.out.println("星期二");
                break;
            case DateTimeConstants.WEDNESDAY:
                System.out.println("星期三");
                break;
            case DateTimeConstants.THURSDAY:
                System.out.println("星期四");
                break;
            case DateTimeConstants.FRIDAY:
                System.out.println("星期五");
                break;
            case DateTimeConstants.SATURDAY:
                System.out.println("星期六");
                break;
        }
    }

    @Override
    public void jdk() {
        DateTime dt = new DateTime();

        //转换成java.util.Date对象
        Date d1 = new Date(dt.getMillis());
        Date d2 = dt.toDate();

        //转换成java.util.Calendar对象
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(dt.getMillis());
        Calendar c2 = dt.toCalendar(Locale.getDefault());
    }

    @Override
    public void pull() {
        DateTime dt = new DateTime();

        //昨天
        DateTime yesterday = dt.minusDays(1);
        //明天
        DateTime tomorrow = dt.plusDays(1);
        //1个月前
        DateTime before1month = dt.minusMonths(1);
        //3个月后
        DateTime after3month = dt.plusMonths(3);
        //2年前
        DateTime before2year = dt.minusYears(2);
        //5年后
        DateTime after5year = dt.plusYears(5);
    }

    @Override
    public void specialDate() {
        DateTime dt = new DateTime();
        //月末日期
        DateTime lastday = dt.dayOfMonth().withMaximumValue();
        //90天后那周的周一
        DateTime firstday = dt.plusDays(90).dayOfWeek().withMinimumValue();
    }

    @Override
    public void zone() {
        //默认设置为日本时间
        DateTimeZone.setDefault(DateTimeZone.forID("Asia/Tokyo"));
        DateTime dt1 = new DateTime();
        //伦敦时间
        DateTime dt2 = new DateTime(DateTimeZone.forID("Europe/London"));
    }

    @Override
    public void CalculationZone() {
        DateTime begin = new DateTime("2012-02-01");
        DateTime end = new DateTime("2012-05-01");

        //计算区间毫秒数
        Duration d = new Duration(begin, end);
        long time = d.getMillis();

        //计算区间天数
        Period p = new Period(begin, end, PeriodType.days());
        int days = p.getDays();

        //计算特定日期是否在该区间内
        Interval i = new Interval(begin, end);
        boolean contained = i.contains(new DateTime("2012-03-01"));
    }

    @Override
    public void Comparison() {
        DateTime d1 = new DateTime("2012-02-01");
        DateTime d2 = new DateTime("2012-05-01");

        //和系统时间比
        boolean b1 = d1.isAfterNow();
        boolean b2 = d1.isBeforeNow();
        boolean b3 = d1.isEqualNow();

        //和其他日期比
        boolean f1 = d1.isAfter(d2);
        boolean f2 = d1.isBefore(d2);
        boolean f3 = d1.isEqual(d2);
    }

    @Override
    public void format() {
        DateTime dateTime = new DateTime();

        String s1 = dateTime.toString("yyyy/MM/dd hh:mm:ss.SSSa");
        String s2 = dateTime.toString("yyyy-MM-dd HH:mm:ss");
        String s3 = dateTime.toString("EEEE dd MMMM, yyyy HH:mm:ssa");
        String s4 = dateTime.toString("yyyy/MM/dd HH:mm ZZZZ");
        String s5 = dateTime.toString("yyyy/MM/dd HH:mm Z");
    }
}
