package com.gjw.annotation;

import org.junit.Test;

/**
 * @author gjw
 * @version 1.0
 *  * 什么是注解（Annotation)? 代码里面的特殊标记 jdk5.0增加了对元数据(MetaData)的支持,也就是Annotation注解
 *  * 这些特殊标记可以在编译和类加载和运行时获取,并执行相应的处理.通过使用注解程序员可以在不改变代码原有逻辑的情况下
 *  * 向源代码中添加一些补充信息
 *  * 框架=注解+反射+设计模式
 */
public class AnnotationTest2 {
    /**
     * 第一种 生成文档的注解
     * @author gjw
     * @version 1.0
     */
    /**
     * 第二种 编译时进行格式检查的注解(JDK内置的三个基本注解)
     * @Overide:重写
     * @Deprecated:表示当前方法已经过时
     * @SuppressWarnings:抑制编译器警告
     */

    /**
     *
     */
    @Test
    public void test(){

    }
}
