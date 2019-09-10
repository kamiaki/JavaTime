package com.aki.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
    private static final String appPath = "applicationContext.xml";

    public static Object getSpringBean(String beanName){
        ApplicationContext context = new ClassPathXmlApplicationContext(appPath);
        Object bean = context.getBean(beanName);
        return bean;
    }
}
