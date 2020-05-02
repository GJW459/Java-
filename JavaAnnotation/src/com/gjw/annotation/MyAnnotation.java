package com.gjw.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * 1.注解声明@interface
 * 2.定义内部成员,通过使用value定义
 * 3.可以用default定义属性的默认值
 * 4.自定义这届没有成员的时候，表名是一个标识作用
 * 如果注解有成员，需要指明注解的成员值
 * 自定义的注解必须配上注解的信息处理流程也就是使用反射才有意义
 * 元数据:修饰当前数据的数据 如 String name="gjw"; String name就是元数据
 * 4.jdk提供的四种元注解 修饰其他注解的注解 @Retention 定义注解的生命周期 @Target 可以修饰在哪些上面
 * @Documented 所修饰的注解会被javadoc解析，并保留下来
 * @Inherited 被他修饰的注解将具有继承性
 * jdk8.0注解的新特性
 * 可重复注解,类型注解
 * 可重复注解 可以重复定义多个
 * 1.在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 * 2.MyAnnotation的Target和Retention和MyAnnotations相同
 * 类型注解:作为类型 Target add Type_Parameter
 */
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)//表明运行时保留
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {

    String value() default "";
}
