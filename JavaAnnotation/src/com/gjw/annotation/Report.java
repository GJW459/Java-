package com.gjw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 把最常用的参数定义为value()，推荐所有参数都尽量设置默认值
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {

    //注解的参数类似无参数方法，
    // 可以用default设定一个默认值（强烈推荐）。
    // 最常用的参数应当命名为value。
    int type() default 0;
    String level() default "info";
    String value() default "";
    /**
     * 元注解
     * 有一些注解可以修饰其他注解，这些注解就称为元注解
     * （meta annotation）。Java标准库已经定义了一些元注解，
     * 我们只需要使用元注解，通常不需要自己去编写元注解
     */
}
