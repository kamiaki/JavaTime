package com.aki.service;

public interface TimeService {
    /**
     * 相关类详解
     */
    void timeClassTest();

    /**
     * 静态工厂方法(用类名去调用)。
     */
    void ofTest();

    /**
     * 静态工厂方法，关注于解析(用类名去调用)。
     */
    void parseTEst();

    /**
     * 静态工厂方法，用当前时间创建实例(用类名去调用)
     */
    void nowTest();

    /**
     * 获取某些东西的值。
     */
    void getTest();

    /**
     * 检查某些东西的是否是true。
     */
    void isTest();

    /**
     * 返回一个部分状态改变了的时间日期对象拷贝(单独一个with方法,参数为TemporalAdjusters类型)
     */
    void withTest();

    /**
     * 返回一个时间增加了的、时间日期对象拷贝(如果参数是负数也能够有minus方法的效果)
     */
    void plusTest();

    /**
     * 返回一个时间减少了的、时间日期对象拷贝
     */
    void minusTest();

    /**
     * 把当前时间日期对象转换成另外一个，可能会损失部分状态.
     */
    void toTest();

    /**
     * 把这个对象与另一个对象组合起来，例如： date.atTime(time)。
     */
    void atTest();

    /**
     * 根据某一个DateTimeFormatter格式化为字符串
     */
    void formatTest();

}
