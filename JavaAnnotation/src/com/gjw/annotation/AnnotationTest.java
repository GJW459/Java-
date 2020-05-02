/**
 * FileName: AnnotationTest
 * Author:   郭经伟
 * Date:     2020/4/8 21:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.annotation;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 什么是注解（Annotation)? 代码里面的特殊标记 jdk5.0增加了对元数据(MetaData)的支持,也就是Annotation注解
 * 这些特殊标记可以在编译和类加载和运行时获取,并执行相应的处理.通过使用注解程序员可以在不改变代码原有逻辑的情况下
 * 框架=注解+反射+设计模式
 * 添加一些补充信息
 * 注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释”：
 * 注释会被编译器直接忽略，注解则可以被编译器打包进入class文件，
 * 因此，注解是一种用作标注的“元数据”。
 * 注解的作用
 * 从JVM的角度看，注解本身对代码逻辑没有任何影响，如何使用注解完全由工具决定。
 *
 * Java的注解可以分为三类：
 * 第一类是由编译器使用的注解，例如：
 * @Override：让编译器检查该方法是否正确地实现了覆写；
 * @SuppressWarnings：告诉编译器忽略此处代码产生的警告。
 * 这类注解不会被编译进入.class文件，它们在编译后就被编译器扔掉了。
 * 第二类是由工具处理.class文件使用的注解，比如有些工具会在加载class的时候，对class做动态修改，实现一些特殊的功能。这类注解会被编译进入.class文件，但加载结束后并不会存在于内存中。这类注解只被一些底层库使用，一般我们不必自己处理。
 * 第三类是在程序运行期能够读取的注解，它们在加载后一直存在于JVM中，这也是最常用的注解。例如，一个配置了@PostConstruct的方法会在调用构造方法后自动被调用（这是Java代码读取该注解实现的功能，JVM并不会识别该注解）。
 * 定义一个注解时，还可以定义配置参数。配置参数可以包括：
 * 所有基本类型；
 * String；
 * 枚举类型；
 * 基本类型、String以及枚举的数组。
 * 因为配置参数必须是常量，所以，上述限制保证了注解在定义时就已经确定了每个参数的值。
 * 注解的配置参数可以有默认值，缺少某个配置参数时将使用默认值。
 * 此外，大部分注解会有一个名为value的配置参数，对此参数赋值，可以只写常量，相当于省略了value参数。
 */
@Report(level = "debug")
public class AnnotationTest {
    public void hello(@NotNull String name, @NotNull String prefix) {
    }
    //java 反射获取Annotation
    @Test
    public void test1() throws Exception {


        //这个类上是否有Report注解
         if (AnnotationTest.class.isAnnotationPresent(Report.class)){
            Report annotation = AnnotationTest.class.getAnnotation(Report.class);
            String level = annotation.level();
            System.out.println(level);
        }
        Method hello = AnnotationTest.class.getMethod("hello", String.class, String.class);
        //获得方法参数的所有注解
        Annotation[][] parameterAnnotations = hello.getParameterAnnotations();
        //获得第一个参数的所有注解
        Annotation[] parameterAnnotation = parameterAnnotations[0];
        for (Annotation annotation : parameterAnnotation) {
            if (annotation instanceof NotNull){
                System.out.println(annotation);
            }
        }


    }

}
