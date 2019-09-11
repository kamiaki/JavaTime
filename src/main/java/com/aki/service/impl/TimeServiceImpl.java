package com.aki.service.impl;

import com.aki.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.WeekFields;

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

        LocalDate localDate1 = LocalDate.parse("20111203",DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate1); //2011-12-03
        LocalDate localDate2 = LocalDate.parse("2017-03-17",DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localDate2); //2017-03-17
    }

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

    @Override
    public void withTest() {

    }

    @Override
    public void plusTest() {

    }

    @Override
    public void minusTest() {

    }

    @Override
    public void toTest() {

    }

    @Override
    public void atTest() {

    }

    @Override
    public void formatTest() {

    }
}
