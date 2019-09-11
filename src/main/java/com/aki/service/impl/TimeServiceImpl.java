package com.aki.service.impl;

import com.aki.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.*;
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
}
