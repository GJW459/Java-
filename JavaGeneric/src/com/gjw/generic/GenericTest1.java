package com.gjw.generic;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.List;

/**
 * 自定义泛型类,泛型接口,泛型方法
 */
public class GenericTest1 {

    @Test
    public void test(){
        Order order=new Order();//泛型类 T 默认为Object
        order.setOrderT("abb");
        Order orderT1 = (Order) order.getOrderT();
        //定义了泛型类就需要用上类型
        Order<String> order1=new Order<>();
        order1.setOrderT("xxx");
        String orderT = order1.getOrderT();
    }
    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();//继承的时候，指明了泛型类的类型
        //子类在继承带泛型的父类的时候，指明了泛型类的类型，实列化就不用指明泛型类型
        subOrder.setOrderT(1111100);
        Integer orderT = subOrder.getOrderT();
        SubOrder2<String> subOrder2=new SubOrder2<>();
        subOrder2.setOrderT("xxxx");
        String orderT1 = subOrder2.getOrderT();
        //泛型类可能有多个类型=><T,M,E>
        //静态方法中不能使用类的泛型，静态方法的初始化早于对象的创建
        //异常类不能声明为泛型类
        //不能使用T t=new T();
        //泛型方法所属的类是不是泛型类都没有关系
    }
    @Test
    public void test3(){
        //测试泛型方法
        Order<Integer> order=new Order<>();
        Integer[] integers = {1, 2, 3, 4};
        List<Integer> copy = Order.copy(integers);
        System.out.println(copy);
    }
}
