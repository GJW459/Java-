package com.gjw.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 函数式接口:一个接口只声明了一个抽象方法,那么接口就是函数式接口
 * 函数式接口的实列就是Lambda表达式
 * java.util.function 定义了丰富的函数式接口
 * 匿名实现类现在都可以用Lambda表达式来完成
 * @FunctionalInterface
 * public interface Runnable {
 * public abstract void run();
 * }
 *
 * Java内置四大核心函数式接口
 * Consumer<T> 参数类型T 返回类型void 消费型接口 对类型为T的对象进行操作,包含方法:accept(T t)
 * Supplier<T> 参数类型无 返回类型T 供给型接口 返回类型为T的对象,包含方法T get()
 * Function<T,R> 参数类型T 返回类型R 函数型接口 对类型为T的进行操作,返回类型为R的对象 R apply(T t)
 * Predicate<T> 参数类型T 返回类型 boolean 断定型接口 确定类型为T的对象是否满足某种约束,并返回boolean值 boolean test(T t)
 */
public class FunctionInterfaceTest {

    private void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    private List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> arrayList=new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                arrayList.add(s);
            }
        }
        return arrayList;

    }
    @Test
    public void test1(){

        //原来的写法
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("去天上人间花费"+aDouble+"元");
            }
        });
        //Lambda表达式
        happyTime(400,money->System.out.print("去书店花费"+money+"元"));
    }
    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京", "天津", "上海", "南京", "东京");
        //原始的写法
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);
        //Lambda表达式
        List<String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2);
    }
}
