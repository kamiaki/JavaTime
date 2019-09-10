package com.aki.service.impl;

import com.aki.service.TimeService;
import org.springframework.stereotype.Service;

@Service(value = "timeServiceImpl")
public class TimeServiceImpl implements TimeService {
    @Override
    public void sayHello() {
        System.out.println("say hello!");
    }


    
}
