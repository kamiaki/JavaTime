package com.aki;


import com.aki.service.TimeService;
import com.aki.util.SpringUtil;
import org.joda.time.*;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        // 2
        TimeService timeService = (TimeService) SpringUtil.getSpringBean("timeServiceImpl");

        DateTime dt4 = new DateTime("2012-05-01T00:00:00");
        DateTime dt5 = new DateTime("2012-05-21T13:14:00");
        Period p = new Period(dt4, dt5, PeriodType.hours());
        System.out.println(p.getHours());
        p = new Period(dt4, dt5, PeriodType.days());
        System.out.println(p.getDays());
    }
}
