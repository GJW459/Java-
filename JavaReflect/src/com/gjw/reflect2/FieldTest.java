package com.gjw.reflect2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的所有属性结构
 */
public class FieldTest {

    @Test
    public void test1(){

        Class<Person> personClass = Person.class;
        //getFields获取属性结构,只能获取public访问权限修饰的字段,包括父类的public
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("==============");
        //getDeclaredFields获取当前运行时类中的所有属性,不包括父类的属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

    }

    /**
     * 权限修饰符 数据类型 变量名
     */
    @Test
    public void test2(){

        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //数据类型
            Class<?> type = declaredField.getType();
            System.out.println(type);
            //变量名
            System.out.println(declaredField.getName());
        }
    }
}
