package com.aki.service.impl;

import com.aki.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

@Service(value = "timeServiceImpl")
public class TimeServiceImpl implements TimeService {

    @Override
    public void timeClassTest() {
        //只存储了日期和时间，如：2017-03-21T14:02:43.455。
        // (后面的.455表示毫秒值的最后三位,使用.withNano(0)可把毫秒值设为0)
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(new StringBuffer("localDateTime: ").append(localDateTime));

        //只存储了日期，如：2017-03-21。
        LocalDate localDate = LocalDate.now();
        System.out.println(new StringBuffer("localDate: ").append(localDate));

        //只存储了时间，如：14:02:43.455。
        // (后面的.455表示毫秒值的最后三位,使用.withNano(0)可把毫秒值设为0)
        LocalTime localTime = LocalTime.now();
        System.out.println(new StringBuffer("localTime: ").append(localTime));

        //只表示年份。
        Year year = Year.now();
        System.out.println(new StringBuffer("year: ").append(year));

        //只表示月份。
        Month month = Month.from(LocalDate.now());
        System.out.println(new StringBuffer("month: ").append(month));

        //只表示年月。
        YearMonth yearMonth = YearMonth.now();
        System.out.println(new StringBuffer("yearMonth: ").append(yearMonth));

        //只表示月日。
        MonthDay monthDay = MonthDay.now();
        System.out.println(new StringBuffer("monthDay: ").append(monthDay));

        //只存储星期的一天。
        DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
        System.out.println(new StringBuffer("dayOfWeek: ").append(dayOfWeek));

        //相当于java.util的Date
        Instant instant = Instant.now();
        System.out.println(new StringBuffer("instant: ").append(instant));

        //它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间
        //当前时区的时刻
        Clock clock = Clock.systemDefaultZone();
        System.out.println(new StringBuffer("clock: ").append(clock));

        //可以得到特定时区的日期/时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(new StringBuffer("zonedDateTime: ").append(zonedDateTime));

        //是用来计算两个日期的时间差
        LocalDateTime start = LocalDateTime.of(2017, 1, 1, 1, 1);
        LocalDateTime end = LocalDateTime.of(2017, 2, 1, 1, 1);
        Duration result = Duration.between(start, end);
        System.out.println(new StringBuffer("result: ").append(result));
        System.out.println(result.toDays()); //31
        System.out.println(result.toHours()); //744
        System.out.println(result.toMinutes()); //44640
        System.out.println(result.toMillis()); //2678400000
        System.out.println(result.toNanos()); //2678400000000000
    }

    /**
     * 静态工厂方法(用类名去调用)。
     */
    @Override
    public void ofTest() {
        LocalDate localDate2 = LocalDate.of(2017, 4, 1);
        System.out.println(localDate2);

        LocalDate localDate3 = LocalDate.of(2017, 3, 25);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        System.out.println(monthDay);

        LocalDateTime dt1 = LocalDateTime.of(2017, Month.APRIL, 18, 13, 45, 20);
        System.out.println(dt1);

        LocalDate date = LocalDate.of(2014, 02, 26);
        LocalTime time = LocalTime.of(12, 23, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println(dt2);

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId);
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime); //2017-04-12T22:05:22.500+08:00[Asia/Shanghai]

        YearMonth yearMonth2 = YearMonth.of(2016, 2);
        System.out.println(yearMonth2); //2016-02

        ZoneOffset zoneOffset = ZoneOffset.of("-05:00");
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, zoneOffset);
        System.out.println(offsetDateTime); //2014-03-18T13:45-05:00
    }

    /**
     * 静态工厂方法，关注于解析(用类名去调用)。
     */
    @Override
    public void parseTEst() {
        //也就是说 自己规定格式解析
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH=mm=ss");
        LocalDateTime dt = LocalDateTime.parse("2017-12-03 10=15=00", pattern);
        System.out.println(dt);
        System.out.println(dt.format(pattern));

        //按照正规格式进行解析
        LocalTime localTime = LocalTime.parse("10:09:20");
        LocalDate localDate = LocalDate.parse("2019-06-19");
        LocalDateTime localDateTime = LocalDateTime.parse("2019-06-19T10:09:30");
        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);

        String dateTime = "2017年12月30日 13点20分30秒";
        DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点mm分ss秒");
        TemporalAccessor parse = pattern2.parse(dateTime);
        LocalDateTime ldt1 = LocalDateTime.from(parse);
        System.out.println("LocalDateTime：" + ldt1);

        LocalDate localDate1 = LocalDate.parse("20111203", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate1); //2011-12-03
        LocalDate localDate2 = LocalDate.parse("2017-03-17", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localDate2); //2017-03-17
    }

    /**
     * 静态工厂方法，用当前时间创建实例(用类名去调用)
     */
    @Override
    public void nowTest() {
        //关注与年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);  //2017-06-26

        LocalTime time = LocalTime.now();
        System.out.println(time); //22:30:01.512
        System.out.println(time.getHour()); //22,时
        System.out.println(time.getMinute()); //30，分
        System.out.println(time.getSecond());  //01，秒

        Instant instant = Instant.now();
        System.out.println(instant);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2017-04-12T22:05:22.500

        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth); //2017-06
        System.out.println(yearMonth.lengthOfMonth());  //当月有多少天,30
        System.out.println(yearMonth.isLeapYear()); //是否是闰年,false
    }

    /**
     * 获取某些东西的值。
     */
    @Override
    public void getTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        //19 今天是当前月份的第几天
        int dayOfMonth = localDateTime.getDayOfMonth();
        //170 今天是今年的第几天
        int dayOfYear = localDateTime.getDayOfYear();
        //WEDNESDAY 今天是周几
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        //3 今天是本周第几天
        int dayofWeek = dayOfWeek.getValue();
        System.out.println(dayOfMonth);
        System.out.println(dayOfYear);
        System.out.println(dayOfWeek);
        System.out.println(dayofWeek);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour()); //24小时制
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano()); //毫秒值的后三位作为前三位后面补6个零
    }

    /**
     * 检查某些东西的是否是true。
     */
    @Override
    public void isTest() {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.parse("2014-01-01");
        System.out.println(now.isEqual(now)); //判断时间和什么时间相等
        System.out.println(now.isAfter(localDate)); //当前时间是否在参数中的时间之后
        System.out.println(now.isBefore(localDate));//当前时间是否在参数中的时间之前
        //判断当前年份是否闰年
        LocalDate time = LocalDate.now();
        System.out.println("isLeapYear :" + time.isLeapYear());
    }

    /**
     * 返回一个部分状态改变了的时间日期对象拷贝(单独一个with方法,参数为TemporalAdjusters类型)
     */
    @Override
    public void withTest() {
        LocalDateTime today = LocalDateTime.now();
        //获得一个时间的副本，将day设置成自己制定的时间,不改变月份，只改变日期
        LocalDateTime d1 = today.withDayOfMonth(1);
        System.out.println(d1);

        LocalDate now = LocalDate.now();
        //当前月份的第一天的日期,2017-03-01
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()));
        //下一个月的第一天的日期,2017-04-01
        System.out.println(now.with(TemporalAdjusters.firstDayOfNextMonth()));
        //当前月份的最后一天,2017-03-31 --再也不用计算是28，29，30还是31
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));

        //使用with方法设置月份
        LocalDateTime time = LocalDateTime.of(2017, 1, 1, 1, 1, 1);
        LocalDateTime changeTime = time.withMonth(12);
        System.out.println(changeTime); //2017-12-01T01:01:01

        //使用.withNano(0)可把毫秒值设为0
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
        System.out.println(localDateTime);
    }

    /**
     * 返回一个时间增加了的、时间日期对象拷贝(如果参数是负数也能够有minus方法的效果)
     */
    @Override
    public void plusTest() {
        //2019-06-20T10:25:30.846 获取当前时间1天后的时间
        LocalDateTime nextDateTime = LocalDateTime.now().plusDays(1);
        System.out.println(nextDateTime);
        //2019-06-19T10:49:20.996 获取当前时间20分钟后的时间
        LocalDateTime afterMinuteTime = LocalDateTime.now().plusMinutes(20);
        System.out.println(afterMinuteTime);

        //改变时间后会返回一个新的实例nextYearTime
        LocalDateTime nextYearTime = LocalDateTime.now().plusYears(1);
        System.out.println(nextDateTime);
    }

    /**
     * 返回一个时间减少了的、时间日期对象拷贝
     */
    @Override
    public void minusTest() {
        //2019-06-18T10:25:30.846 获取当前时间前1天时间
        LocalDateTime beforeDateTime = LocalDateTime.now().minusDays(1);
        System.out.println(beforeDateTime);
        //2019-06-19T08:27:30.400 获取当前时间的2小时之前的时间
        LocalDateTime beforeHourTime = LocalDateTime.now().minusHours(2);
        System.out.println(beforeHourTime);

        //使用minus方法减年份
        LocalDateTime time = LocalDateTime.of(2017, 1, 1, 1, 1, 1);
        LocalDateTime lastYearTime = time.minusYears(1);
        System.out.println(lastYearTime); //2016-01-01T01:01:01

        LocalDate localDate = LocalDate.now();
        //当前时间的二个月之前
        LocalDate localDate3 = localDate.minus(2, ChronoUnit.MONTHS);
        System.out.println(localDate3);//2017-04-27
    }

    /**
     * 把当前时间日期对象转换成另外一个，可能会损失部分状态.
     */
    @Override
    public void toTest() {
        LocalDateTime dt1 = LocalDateTime.of(2017, Month.APRIL, 18, 13, 45, 20);
        System.out.println(dt1);
        LocalDate date1 = dt1.toLocalDate(); //通过LocalDateTime获得LocalDate
        LocalTime time1 = dt1.toLocalTime(); //通过LocalDateTime获得LocalTime
        System.out.println("date1=======" + date1 + "time1====" + time1);

        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(instant);

        //18066 获取从1970年以来的天数：toEpochDay
        long days = LocalDate.now().toEpochDay();
        //565 获取两个时间的天数差
        long day = LocalDate.now().toEpochDay() - LocalDate.parse("2017-12-01").toEpochDay();
        System.out.println(days);
        System.out.println(day);

        Instant now = Instant.now();
        System.out.println(now.toEpochMilli());//获取当前时间的毫秒值

        //此类用来计算两同类型日期的时间差,看演示:
        LocalDateTime start = LocalDateTime.of(2017, 1, 1, 1, 1);
        LocalDateTime end = LocalDateTime.of(2017, 2, 1, 1, 1);
        Duration result = Duration.between(start, end);
        System.out.println(result.toDays()); //31
        System.out.println(result.toHours()); //744
        System.out.println(result.toMinutes()); //44640
        System.out.println(result.toMillis()); //2678400000
        System.out.println(result.toNanos()); //2678400000000000
    }

    /**
     * 把这个对象与另一个对象组合起来，例如： date.atTime(time)。
     */
    @Override
    public void atTest() {
        LocalDateTime now = LocalDateTime.now();
        ZoneId systemDefault = ZoneId.systemDefault();
        Instant instant = now.atZone(systemDefault).toInstant();
        System.out.println(instant); //1490163685578

        LocalDate date = LocalDate.of(2014, 02, 26);
        LocalTime time = LocalTime.of(12, 23, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println(dt2);

        //LocalDate结合LocalTime成一个LocalDateTime
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        System.out.println(dt3); //2014-02-26T13:45:20

        //LocalDate结合LocalTime成一个LocalDateTime
        LocalDateTime dt4 = date.atTime(time);
        System.out.println(dt4); //2014-02-26T12:23:20

        //LocalTime结合LocalDate成LocalDateTime
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt5); //2014-02-26T12:23:20
    }

    /**
     * 根据某一个DateTimeFormatter格式化为字符串
     */
    @Override
    public void formatTest() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-@@MM-@@dd HH:mm:ss");
        String formatdate = localDateTime.format(formatter);
        System.out.println(formatdate);

        LocalDate localDate = LocalDate.of(2017, 3, 17);
        //BASIC_ISO_DATE格式，20111203
        String str = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(str);
        //DateTimeFormatter.ISO_LOCAL_DATE 格式 2017-03-17
        String str2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(str2);
        //定义
        String str3 = localDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(str3);


        // 1.新建一个DateTimeFormatter对象（有静态对象，也可以自己创建[自己创建是调用ofPattern方法]）
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINA);
        // 2.调用该对象的format方法，参数是需要格式化的LocalDateTime对象。
        String format = pattern.format(LocalDateTime.now());
        System.out.println("时间是：" + format);
    }

    /**
     * 从某个时间获取
     */
    @Override
    public void fromTest() {
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2014, 3, 25));
        System.out.println(monthDay2); //--03-25

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点mm分ss秒");
        TemporalAccessor parse = pattern.parse("2017年12月30日 13点20分30秒");
        LocalDateTime ldt1 = LocalDateTime.from(parse);
        System.out.println("LocalDateTime：" + ldt1);
    }
}
