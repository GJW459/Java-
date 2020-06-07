package com.gjw.TheSecondStudy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Java8DateStudy {
    public static void main(String[] args) {
        //1.获取当前时间
        LocalDateTime rightNow = LocalDateTime.now();
        System.out.println("当前的时刻:" + rightNow);
        System.out.println("当前的年份:"+rightNow.getYear());
        System.out.println("当前的月份:"+rightNow.getMonth());
        System.out.println("当前的日份:"+rightNow.getDayOfMonth());
        System.out.println("当前时:"+rightNow.getHour());
        System.out.println("当前分:"+rightNow.getMinute());
        System.out.println("当前秒:"+rightNow.getSecond());
        //2.构建一个指定年月日的时间
        LocalDateTime time = LocalDateTime.of(2020, 2, 2, 12, 05);
        System.out.println(time);
        //3.修改日期
        LocalDateTime now = LocalDateTime.now();
        now=now.minusYears(2);//减少两年
        now=now.plusYears(2);//增加两年
        now=now.withYear(2008);//修改年份
        now=now.withHour(13);//修改小时
        System.out.println(now);
        //4.格式化日期
        LocalDateTime now1 = LocalDateTime.now();
        String result1 = now1.format(DateTimeFormatter.ISO_DATE);
        String result2 = now1.format(DateTimeFormatter.BASIC_ISO_DATE);
        String result3 = now1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("格式化后的日期(基本样式1):"+result1);
        System.out.println("格式化后的日期(基本样式2):"+result2);
        System.out.println("自定义的格式化日期:"+result3);
        //5.时间反解析 提供一个字符串 解析成LocalDateTime
        LocalDateTime parse = LocalDateTime.parse("2020--01--02 11:12", DateTimeFormatter.ofPattern("yyyy--MM--dd HH:mm"));
        System.out.println("反解析后的时间:"+parse);
        //线程安全的问题 惯用的Date类是可变类 多线程环境下共享Date变量的时候,需要程序员来保证线程安全
        /**
         * 首先回顾一下 不可变类和可变类
         * 可变类:当获得一个实例引用的时候,可以通过这个引用改变实例的内容
         * 不可变类:当你获得这个类的一个实例引用时，你不可以改变这个实例的内容。不可变类的实例一但创建，其内在成员变量的值就不能被修改
         * 不可变类是线程安全的类
         * 日期格式化的选择 SimpleDateFormat 本身就是线程不安全的
         * 所以选择DateTimeFormatter 线程安全的
         */


    }
}
