package com.gjw.enumReview;

import java.util.Arrays;

/**
 * 枚举 也是一种特殊的类 当需要定义一组常量的时候，应该使用枚举类
 * 类的对象只有有限个的时候=>可以使用枚举
 * 比如Sex类 只有两个类型 男性还是女性
 * 如果一个枚举类只有一个对象的使用 可以作为单例模式的实现方式
 * jdk5.0 前 得自己定义枚举类
 * jdk5.0 后 有enum关键字
 * 常用方法
 * 枚举类实现接口
 */
public class EnumTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        Sex male = Sex.MALE;
        System.out.println(Sex.class.getSuperclass());
        System.out.println(male);
        Sex[] values = Sex.values();
        System.out.println(Arrays.toString(values));
        Thread.State blocked = Thread.State.BLOCKED;
        System.out.println(blocked);
        Thread.State[] states = Thread.State.values();
        System.out.println(Arrays.toString(states));
        Sex female = Sex.valueOf("FEMALE");
        System.out.println(female);
        Sex male1 = Sex.MALE;
        male1.gotoWC();
    }
}
// 自定义枚举类
class Season{

    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    // 提供枚举类的多个方法
    public static final Season SPRING=new Season("春天","春暖花开");
    public static final Season SUMMER=new Season("夏天","sss");
    public static final Season AUTUMN=new Season("秋天","aa");
    public static final Season WINTER=new Season("冬天","aa");

    //获得属性值

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}