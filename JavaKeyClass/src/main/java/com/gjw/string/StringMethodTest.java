/**
 * FileName: StringMethodTest
 * Author:   郭经伟
 * Date:     2020/3/31 10:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String方法的使用
 */
public class StringMethodTest {

    @Test
    public void test1(){
        String s1="Helloworld";
        System.out.println(s1.length());//char数组的长度
        System.out.println(s1.charAt(0));//获取字符数组的某个字符
        System.out.println(s1.charAt(9));
        String s2="";
        System.out.println(s2.isEmpty());//判断是否为""
        String s3=s1.toLowerCase();//小写
        System.out.println(s3);
        System.out.println(s1);
        String s4="  hello world  ";
        String s5=s4.trim();//去除两段的空格
        System.out.println(s4);
        System.out.println(s5);

    }
    @Test
    public void test2(){
        String s1="helloworld";
        String s2="Helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));//忽略大小写
        String s3="abc";
        String s4=s3.concat("def");//字符串连接
        System.out.println(s4);
        String s5="abc";
        String s6=new String("Abe");
        System.out.println(s5.compareTo(s6));//涉及字符串排序
        String s7="gjw459";
        String s8=s7.substring(2);
        System.out.println(s8);
        s8=s7.substring(2,3);//>=a <b 左闭右开
        System.out.println(s8);
        System.out.println(s7.startsWith("gjw"));
        System.out.println(s7.endsWith("g"));
        //indexof 和lastindexof没找到默认为-1
        //replace 就是把所有的old,替换为new的
        //replace 通过正则表达式替换
        String s9="s_a_v";
        System.out.println(s9.replace("_",","));
        //match(String regex)//正则表达式 当前字符串是否匹配
        //split将字符串通过指定正则表达式分割为指定数组


    }
    @Test
    //String与其他结构之间的转换
    public void test3(){
        //1.String=>基本数据类型,包装类 parseXxx(str)
        //2.基本数据类型,包装类-->String:调用String重载的valueOf(xxx)
        String str1="123";//常量池
        int num=Integer.parseInt(str1);
        String string = String.valueOf(num);
        System.out.println(string);
        String str2=new String("12");//堆
        String str3=str2+"3";//堆
        System.out.println(str1==str2);
        System.out.println(str2==string);


    }
    //String与char之间的转换
    @Test
    public void test4(){

        String str1="abc123";
        char[] chars = str1.toCharArray();
        for (int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
        }
        char [] chars1=new char[]{'a','c','d'};
        String s=new String(chars1);
        System.out.println(s);
    }
    @Test
    //String与字节数组的转换
    public void test5(){

        //编码:String =>字节(底层2进制数,看不懂的2进制数据)
        //解码:编码的逆过程，字节--> 字符串(看不懂的二进制-->看得懂)
        String str1="abc123中国";
        //编码
        byte[] bytes = str1.getBytes();//UTF-8 一个汉字表示三位
        System.out.println(Arrays.toString(bytes));
        try {
            byte[] gbks = str1.getBytes("gbk");//一个汉字表示2位
            System.out.println(Arrays.toString(gbks));
            //解码
            //会出现乱码的原因，编码和解码的格式不一样
            //解码时，必须使用和编码一个的编码方式
            String string = new String(gbks,"gbk");
            System.out.println(string);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //解码
        String string = new String(bytes);
        System.out.println(string);

    }
}
