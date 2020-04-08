/**
 * FileName: StringBufferBuilderTest
 * Author:   郭经伟
 * Date:     2020/3/31 11:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.string;

import org.junit.Test;

public class StringBufferBuilderTest {
    /**
     * String StringBuffer StingBuilder三者的异同
     * String是不可变的字符序列 底层用char数组存储
     * StringBuffer:可变的字符序列：线程安全的，效率低 用char存储
     * StringBuilder: 线程不安全的，效率高JDK5.0 底层用char储存
     *
     * 源码分析
     * String str=new String()//new char[0]
     * String str1=new String("abc")//new char[]{'a','b','c'};
     * StringBuffer sb1=new StringBuffer();//char[] value=new char[16];底层创建了一个长度为16的字符数组
     * sb1.append('a');//value[0]='a';
     * StringBuffer sb2=new StringBuffer("abv")//new char[16+3]
     * length:totalCount,不是16
     * 扩容问题:如果添加的数据底层数组装不下了，就需要扩容数组
     * 默认情况下，扩容为原来的两倍加2，同时将原来的数组中的元素copy到新的数组
     * 建议用new StringBuffer(int capacity) new StringBuilder(int capacity)
     * 总结：
     * 方法
     * 增：append
     * 删：delete
     * 改：setCharAt
     * 插：insert
     * 查：charAt
     * 三者效率
     * StringBuilder>StringBuffer>String
     */
    @Test
    public void test1(){
        StringBuffer sb1=new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
    }
}
