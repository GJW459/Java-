package com.gjw.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 是一个匿名函数=>一段可以传递的代码,将代码向数据一样的进行传递
 */
public class LambdaTest {

    @Test
    public void test1(){

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("i love you");
            }
        };
        runnable.run();
        System.out.println("************");
        //Lambda表达式
        Runnable runnable1=()-> System.out.println("i love me");
        runnable1.run();

    }

    /**
     * Lambda表达式的使用
     * 举例 (o1,o2)-> Integer.compare(o1,o2)
     * 格式:
     *      ->:lambda操作符 或者 箭头操作符
     *      ->:左边 Lambda 形参列表 (其实就是接口中的抽象方法的形参列表)
     *      ->:右边 Lambda体 重写方法的方法体
     *      Lambda表达式的使用 6种情况
     *
     * 本质: 作为接口的实列 接口的实现类的对象=>函数式接口的实现
     * 总结: ->
     * 左边:参数类型可以省略:类型推断
     * 只有一个参数,小括号可以省
     * 右边:正常有大括号包裹,如果Lambda体只有一条执行语句(可能是return 语句),就可以省return 和{}
     */
    @Test
    public void test2(){

        //情况1:无参 无返回值的情况
        Runnable runnable=()-> {System.out.println(" i love you");};
        runnable.run();
        //情况2:Lambda需要一个参数,无返回值
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("你和我的区别是什么?");
        System.out.println("Lambda表达式写法");
        Consumer<String> consumer1=(String s)->{
            System.out.println(s);
        };
        consumer1.accept("我不喜欢你");
        //情况3.:数据类型可以省略,因为可由编译器推断出,称之为类型推断
        Consumer<String> consumer2=(s)->{
            System.out.println(s);
        };
        consumer2.accept("xxxxxxx");
        //情况4,Lambda若只需要一个参数的时候,参数的小括号就可以省略
        Consumer<String> consumer3=s -> {
            System.out.println(s);
        };
        consumer3.accept("hahaha");
        //情况5,Lambda如果需要多个参数的时候,方法体有多句执行语句,且有返回值
        Comparator<Integer> comparator=(o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        System.out.println(comparator.compare(10,20));
        //情况6,当Lambda体只有一条语句的时候,return 与大括号若有,则可以省略
        Comparator<Integer> comparator2=(o1,o2)-> o1.compareTo(o2);
        System.out.println(comparator2.compare(15,20));


    }
}
