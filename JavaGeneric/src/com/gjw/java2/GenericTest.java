package com.gjw.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型在继承方面的体现
 * 类A是类B的父类,但是G<A>和G<B>不存在任何的关系
 * 类A是B的父类 A<T>是B<T>的父类
 */
public class GenericTest {

    @Test
    public void test(){

        Object object=null;
        String str=null;
        object=str;
        Object[] arr1=null;
        String[] arr2=null;
        arr1=arr2;
    }

    /**
     * 通配符的使用
     * 通配符?
     * 类A是类B的父类,G<A>G<B>是没有关系的，两者的共同父类为G<?>
     */
    @Test
    public void test2(){
        List<Object> list1=null;
        List<String> list2=new ArrayList<>(Arrays.asList("a","b"));
        List<?> list3=null;
        list3=list1;
        list3=list2;//?就相当于Object和String的通用父类
        //添加,像List<?>就不能向内部添加数据，唯一可以加null
        print(list2);
        //获取:读取 允许我们读取 读取的数据类型为Object类型
        Object o = list3.get(0);
    }

    /**
     * 有限制条件的通配符
     * ?extends A <=A A本身或者A的子类
     * ?super A  >=A A本身或者A的父类
     */
    @Test
    public void test3(){
        //?可以理解为(-无穷,+无穷)
        List<? extends Person> list1=null;//可以是Person的子类或者本身 <=Person
        List<?super Person> list2=null;// >=Person
        List<Object> list3=new ArrayList<>();
        List<Person> list4=new ArrayList<>();
        List<Student> list5=new ArrayList<>();
        //list1=list3; 出错
        list1=list4;
        list1=list5;
        list2=list3;
        list2=list4;
        //读取数据
        Person person = list1.get(0);
        Object object = list2.get(0);
        //读写数据
//        list1.add(new Person()) 错误
        list2.add(new Student());
        list2.add(new Person());



    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
