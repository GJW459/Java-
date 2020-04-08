/**
 * FileName: ClassTest
 * Author:   郭经伟
 * Date:     2020/4/8 20:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 除了int等基本类型外，Java的其他类型全部都是class（包括interface）。例如：
 *
 * String
 * Object
 * Runnable
 * Exception
 * ...
 */
public class ClassTest {

    /**
     * 复习一下java 内部类
     * 在 Java 中，可以将一个类定义在另一个类里面或者一个方法里面，
     *  这样的类称为内部类。广泛意义上的内部类一般来说包括这四种：成员内部类、局部内部类、匿名内部类和静态内部类
     */

    class Person{

        private Integer id=10;
        private String name;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void eat(){
            System.out.println(this.name+"在吃饭");
        }
    }
    @Test
    //获取Class类对象的三种方式
    public void test1() throws ClassNotFoundException {
        //1 ,静态变量
        Class personClass = Person.class;
        //方式二,实列变量的getClass方法
        Person person=new Person();
        Class<? extends Person> aClass = person.getClass();
        //方式三,通过Class类的静态方法
        Class<?> aClass1 = Class.forName("java.util.Arrays");
        System.out.println(personClass);
        System.out.println(aClass);
        System.out.println(aClass1);

    }
    @Test
    // Class实例比较和instanceof的区别
    public void test2(){
        Integer integer=new Integer(123);
        boolean b1 = integer instanceof Integer;
        boolean b2 = integer instanceof Number;//true因为是Integer的子类
        boolean b3 = integer.getClass() == Integer.class;//true，应为getClass返回的就是Integer,class
//        boolean b4 = integer.getClass() == Number.class;//false, 因为Integer,class!=Number.class
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }

    @Test
    //获取Class的字段和方法
    public void test3() throws Exception {
        Person person=new Person();
        Class<? extends Person> aClass = person.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.getName().equals("id")){
                System.out.println(field.get(person));
            }

        }
        Method eat = aClass.getMethod("eat");
        Method setName = aClass.getMethod("setName", String.class);
        setName.invoke(person,"小明");
        eat.invoke(person,null);

    }
    @Test
    //获得继承关系
    public void test4(){

        //获得Integer类的父类
        Class<Integer> integerClass = Integer.class;
        Class<? super Integer> superclass = integerClass.getSuperclass();
        System.out.println(superclass);
        Class<? super Integer> object = superclass.getSuperclass();
        System.out.println(object);
    }
    @Test
    //获得接口
    public void test5(){
        Class<Integer> integerClass = Integer.class;
        Class<?>[] interfaces = integerClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //如果是两个Class实例，要判断一个向上转型是否成立
        boolean assignableFrom = Integer.class.isAssignableFrom(Integer.class);
        //object=?
        boolean object = Object.class.isAssignableFrom(Integer.class);
        boolean assignableFrom1 = Integer.class.isAssignableFrom(Number.class);//失败Number是父类
        System.out.println(assignableFrom);
        System.out.println(object);
        System.out.println(assignableFrom1);
    }
}
