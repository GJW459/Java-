package com.gjw;

import java.util.Arrays;

/**
 * 枚举 也是一种类型 当需要定义一组常量时，应该使用枚举类 类的对象只有有限个，确定的=>枚举类 有限个
 * 如：性别 星期 线程状态
 * 枚举类的使用 当一个类的对象有限个时 称之为枚举类
 * 如果一个枚举类只有一个对象的使用 可以当做单例模式的实现方式
 * jdk5.0 前 得自己定义枚举类
 * jdk5.0 后 有enum关键字
 * 常用方法
 * 枚举类实现接口
 */
public class enumtest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        Sex male = Sex.MALE;
        System.out.println(Sex.class.getSuperclass());//默认继承于
        System.out.println(male);
        Sex[] values = Sex.values();
        System.out.println(Arrays.toString(values));
        Thread.State blocked = Thread.State.BLOCKED;//线程状态枚举类
        System.out.println(blocked);
        Thread.State[] values1 = Thread.State.values();
        System.out.println(Arrays.toString(values1));
        Sex female = Sex.valueOf("FEMALE");//根据提供的objName返回枚举类中的对象 没有就会抛出异常
        System.out.println(female);
        Sex male1 = Sex.MALE;
        male1.gotoWC();
    }
}
//自定义枚举类
class Season{

    //声明属性
    private final String seasonName;
    private final String seasonDesc;

    //私有化构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    //提供枚举类的多个方法
    public static final Season SPRING=new Season("春天","春暖花开");
    public static final Season SUMMBER=new Season("夏天","sss");
    public static final Season AUTUMN=new Season("秋天","aa");
    public static final Season WINTER=new Season("冬天","aa");
    //获取属性值

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
