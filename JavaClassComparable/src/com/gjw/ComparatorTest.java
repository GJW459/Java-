package com.gjw;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较运算符 (关系运算符) : == >= > < <= instanceof=>这个是比较的对象类型是否相同
 * 普通的java对象可以比较大小 正常情况下不能比较大小 通过使用两个接口 Comparable Comparator
 *
 * Comparable接口的使用 使用的举例 String
 */
public class ComparatorTest {

    /**
     * Comparable的使用举例 自然排序
     * 像String 包装类 实现了Comparable接口 重写了compareTo方法 从小到大的排序
     * 重写了compareTo方法的规则
     * 如果当前对象的this大于形参的obj 返回正整数 反之返回负数 相等返回0 升序 反之降序
     * 自定义类可以实现comparable类 重写其方法排序
     *
     */
    @Test
    public void test(){

        String[] strings = {"AA", "DD", "CC"}; //String实现了Comparable接口 所以可以比较大小
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

    }

    /**
     * Goods进行排序
     */
    @Test
    public void test2(){
        Goods[] goods = new Goods[5];
        goods[0]=new Goods("XIAOMI",34);
        goods[1]=new Goods("HUAWEI",43);
        goods[2]=new Goods("LEXIAO",12);
        goods[3]=new Goods("ABV",65);
        goods[4]=new Goods("AB",65);
        Arrays.sort(goods);
        for (Goods good : goods) {
            System.out.println(good);
        }

    }
    /**
     * 实现Comparator接口 定制排序
     * JDK中的代码无法修改，也就是代码无法修改 可以使用定值排序
     * 重写方法 规则和之前的一样
     */
    @Test
    public void test3(){
        String[] strings = {"AA", "DD", "CC"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return -o1.compareTo(o2);//降序
            }
        });
        System.out.println(Arrays.toString(strings));
    }
}
