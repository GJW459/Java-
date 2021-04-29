package com.gjw.TheThirdStudy;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author 郭经伟
 * @Date 2021/4/3
 *
 * java 8中的日期时间API的测试
 * LocalTime
 * LocalDate
 * LocalDateTime
 * Instance :瞬时
 * DateTimeFormatter
 **/
public class DateTest {



    @Test
    public void test1(){

        // 获得当前的日期和时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        System.out.println(format);
    }

}
