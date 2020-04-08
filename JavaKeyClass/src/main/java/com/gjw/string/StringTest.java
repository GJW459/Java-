/**
 * FileName: StringTest
 * Author:   郭经伟
 * Date:     2020/3/30 20:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.string;

import org.junit.Test;

/**
 * String的使用
 */
public class StringTest {
    /**
     * 1.String字符串:使用一对""引起来表示
     * 2.String声明为final的，不可被继承
     * String实现了Serializable接口：表示字符串可以被序列化
     * 实现了Comparable接口：表示String可以比较大小
     * 3.String内部定义了final char[] value用于存储字符串数据
     * 4.String：代表一个不可变的字符序列，不可变性
     * 体现：1.当对字符串重新赋值的时候，需要重新制定内存区域赋值，不能使用原有的value进行赋值
     *      2.当对字符串进行连接操作的时候，也需要在内存区域重新赋值
     *      3.当调用String的replace()方法修改指定的字符和字符串时，也需要重新赋值
     * 5.通过字面量方式(区别于new)给一个字符串赋值，此时的字符传值声明在字符串常量池中
     * 6.字符串常量池中是不会存储相同内容的字符串的
     */
    @Test
    public void test1(){
        String s1="abc";//字面量
        s1="hello";
        String s2="abc";
        System.out.println(s1 == s2);//比较s1和s2的地址值
        System.out.println(s1);
        System.out.println(s2);
        //相当于this.value=new char[0]
        String s3=new String();
        //this.value=original.values;
        String s4=new String(s1);
        System.out.println(s4);
        s4="xxx";
        System.out.println(s4);
        //相当于this.value=Arrays.copyof(value,value.length)
        String s5=new String(new char[]{'a','b'});
    }

    /**
     * String的实例化方式：
     * 方式一：通过字面量定义的方式 =>保存的地址值在方法区的常量池中
     * 方式二：通过new+构造器的方式 =>保存的地址值在堆中
     */
    @Test
    public void test2(){

    }

    /**
     * 结论：
     * 1.常量与常量的拼接在常量池，且常量池中不会存在相同内容的常量
     * 2.只要其中一个是变量，结果就在堆中
     */
    @Test
    public void test3(){
        String s1="javaee";
        String s2="hadoop";
        String s3="javaeehadoop";
        String s4="javaee"+"hadoop";
        String s5=s1+s2;
        String s6=s1+"hadoop";
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s3==s6);
        System.out.println(s5==s6);

    }
}
