package com.gjw;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * java 8中的日期时间API的测试
 * LocalTime
 * LocalDate
 * LocalDateTime
 * Instant：瞬时
 * DateTimeFormatter
 */
public class DateTest {

    @Test
    public void test1(){
        //获取当前的日期和时间
        LocalDate localDate=LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        System.out.println(format);
        //指定日期和时间 of() :没有偏移量
        //LocalDateTime 这个类使用的评率更高
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 30, 10, 20);
        System.out.println(localDateTime1);
        //getXXX()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getYear());
        // 不可变性 withXXX设置相关属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime2.getDayOfMonth());
        System.out.println(localDateTime.getDayOfMonth());


    }
    @Test
    public void test2(){
        // Instant：瞬时 时间戳 类似Date类
        Instant instant = Instant.now();
        System.out.println(instant);//本初子午线的时间
        //本地的时间 根据时期添加偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        long l = instant.toEpochMilli();//毫秒数 从1970到现在的毫秒数
        System.out.println(l);

    }
    @Test
    public void test3(){
        //对日期格式化
        //标准格式
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化 日期->字符串
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);
        //解析 字符串->日期
        //本地化相关的格式
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format1 = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(format1);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format2 = dateTimeFormatter2.format(LocalDate.now());
        System.out.println(format2);
        //自定义格式化 主要
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format3 = dateTimeFormatter3.format(LocalDateTime.now());
        System.out.println(format3);
        //解析
        TemporalAccessor parse = dateTimeFormatter3.parse(format3);
        System.out.println(parse);

    }

}
