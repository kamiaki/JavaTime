package com.aki.service.impl;

import com.aki.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service(value = "timeServiceImpl")
public class TimeServiceImpl implements TimeService {

    @Override
    public void timeClassTest() {
        //只存储了日期和时间，如：2017-03-21T14:02:43.455。
        // (后面的.455表示毫秒值的最后三位,使用.withNano(0)可把毫秒值设为0)
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(new StringBuffer("localDateTime: ").append(localDateTime));

        LocalDate localDate = LocalDate.now();
        System.out.println(new StringBuffer("localDate: ").append(localDate));

    }
}
