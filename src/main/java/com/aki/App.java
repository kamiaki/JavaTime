package com.aki;


import com.aki.service.TimeService;
import com.aki.util.SpringUtil;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        TimeService timeService = (TimeService) SpringUtil.getSpringBean("timeServiceImpl");
        timeService.sayHello();

    }
}
