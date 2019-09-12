package com.aki.service;

public interface JodaTime {

    /**
     * 创建时间类
     */
    void createJoda();

    /**
     * 获取年月日点分秒 类方法
     */
    void getDateAndTime();

    /**
     * 星期的特殊处理
     */
    void week();

    /**
     * 与JDK日期对象的转换
     */
    void jdk();


    /**
     * 日期前后推算
     */
    void pull();


    /**
     * 取特殊日期
     */
    void specialDate();

    /**
     * 时区
     */
    void zone();

    /**
     * 计算区间
     */
    void CalculationZone();

    /**
     * 日期比较
     */
    void Comparison();

    /**
     * 格式化输出
     */
    void format();
}
