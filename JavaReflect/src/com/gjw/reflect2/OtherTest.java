package com.gjw.reflect2;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test(){
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * 获取带泛型的父类
     */
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
        //获取泛型类型
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }

    /**
     * 获取运行时类的接口
     */
    @Test
    public void test3(){

        Class<?>[] interfaces = Person.class.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Class<?>[] interfaces1 = Person.class.getSuperclass().getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
        //获取包
        Package aPackage = Person.class.getPackage();
        System.out.println(aPackage);
    }
}
