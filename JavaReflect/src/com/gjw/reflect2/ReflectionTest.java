package com.gjw.reflect2;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类的指定结构,属性,方法,构造器
 */
public class ReflectionTest {


    @Test
    public void testField() throws Exception {

        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        //获取的public的属性
        Field id = personClass.getField("id");
        //设置当前属性的值 参数1 对象 参数二 设置多少
        id.set(person,1001);
        //获取属性值 获取那个对象的属性值
        int i = (int) id.get(person);
        System.out.println(i);

        //上面的方式,都不爱用

    }
    @Test
    public void testField2() throws Exception{
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        //获取指定变量名的属性
        Field name = personClass.getDeclaredField("name");
        //需要设置为true 保证当前属性可以访问的
        name.setAccessible(true);
        //private修饰的字段
        name.set(person,"张三");
        System.out.println(name.get(person));

    }

    @Test
    public void testMethod() throws Exception{

        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        //获取非静态方法  第一个参数 方法名 第二个参数 形参列表
        Method show = personClass.getDeclaredMethod("show", String.class);
        //保证当前的方法可访问
        show.setAccessible(true);
        //调用方法 参数1:方法的调用者参数2:实参
        String nation=((String) show.invoke(person, "CHN"));
        //调用静态方法
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果返回类型为void 则返回为null 这里invoke的参数可以是null
        Object invoke = showDesc.invoke(Person.class);
        System.out.println(invoke);
    }

    @Test
    public void testConstructor() throws Exception{
        Class<Person> personClass = Person.class;
        //获取指定构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        //调用构造器 创建运行时类的对象
        Person person=declaredConstructor.newInstance("Tom");
        System.out.println(person);
    }
}
