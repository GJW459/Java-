package com.gjw.TheSecondStudy;

import java.util.Date;

public class OldDateStudy {

    public static void main(String[] args) {
        //老牌的Date类被弃用的方法太多了,所以也可以弃用了,使用java8的LocalDateTime
        Date rightNow = new Date();
        System.out.println("当前的时刻:"+rightNow);
        System.out.println("当前的年份:"+rightNow.getYear());
        System.out.println("当前的月份:"+rightNow.getMonth());

    }
}
