package com.gjw.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类就是为了解决空指针异常
 * Optional<T>是一个容器类,可以保存类型为T的值,代表这个值存在.或者仅仅保存null
 * 表示这个值不存在
 * 如果值存在isPresent方法返回true,调用get方法返回该对象
 *
 * 常用方法: ofNullable(T t)
 * orElse(T t)
 * BootStrap
 */
public class OptionalTest {

    @Test
    public void test1(){
        //Optional.of 不可以为空(参数)
        //Optional.ofNullable 可以为空
        //Optional.empty() 创建一个空的Optional实列
        Girl xx = new Girl("xx");
        Optional<Girl> xx1 = Optional.of(xx);
        System.out.println(xx1);
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o);


    }

    /**
     * 处理空指针异常
     */
    @Test
    public void test2(){

        Girl girl = new Girl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);
        //orElse (T t) 如果当前Optional内部封装的t为非空,就返回内部的t
        //如果内部的t是空的,则返回orElse()方法里面的参数
        Girl xx = girl1.orElse(new Girl("xx"));
        System.out.println(xx);
    }

    /**
     * 使用Optional类获取GirlName
     * @return
     */
    public String getGirlName(Boy boy){
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //此时boy1为非空
        Boy xxx = boy1.orElse(new Boy(new Girl("xxx")));
        Girl girl = xxx.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl sss = girl1.orElse(new Girl("sss"));
        return sss.getName();
    }
    @Test
    public void test3(){
        Boy boy=null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
        boy=new Boy();
        String girlName1 = getGirlName(boy);
        System.out.println(girlName1);
        boy=new Boy(new Girl("cang teacher"));
        String girlName2 = getGirlName(boy);
        System.out.println(girlName2);
    }
}
