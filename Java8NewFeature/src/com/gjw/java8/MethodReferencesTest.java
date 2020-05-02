package com.gjw.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * 当传递给Lambda体的操作,已经有实现的方法了,可以使用方法引用
 * 方法引用可以看做Lambda表达式的深层次的表达,也就是Lambda表达式
 *
 * 方法引用的使用
 * 1.使用的情景:当传递给Lambda体的操作,已经有实现的方法了,可以使用方法引用
 *
 * 使用格式 类(或者对象)::方法名
 * 分为以下三种情况
 * 对象:: 非静态方法
 * 类 :: 静态方法
 * 类 :: 非静态方法
 *
 * 方法引用的使用要求:要求接口中的抽象方法的形参列表和返回值类型与方法引用的形参列表和返回值相同 针对于前两个
 */
public class MethodReferencesTest {

    /**
     * 情况1: 对象:: 实列方法
     * Consumer中的void accept(T t)方法
     * PrintStream中的void println(T t)方法
     */
    @Test
    public void test1(){
        //Lambda表达式
        Consumer<String> consumer=str-> System.out.println(str);
        consumer.accept("北京");
        //方法引用
        PrintStream out = System.out;
        Consumer<String> consumer1=out::print;
        consumer1.accept("beijing");

    }

    /**
     * Supplier中的T get();
     * Employee中的String getName();
     */
    @Test
    public void test2(){

        Employee employee = new Employee();
        employee.setAge(18);
        employee.setName("张三");
        employee.setSalary(15000.0);
        //Lambda表达式
        Supplier<String> stringSupplier=()->employee.getName();
        System.out.println(stringSupplier.get());
        //方法引用
        Supplier<String> supplier=employee::getName;
        System.out.println(supplier.get());
    }

    /**
     * 情况2: 类::静态放方法名
     */
    @Test
    public void test3(){
        //Lambda表达式
        Comparator<Integer> comparator=((o1, o2) -> Integer.compare(o1,o2));
        System.out.println(comparator.compare(25,10));
        //方法引用
        Comparator<Integer> comparator1=Integer::compareTo;
        System.out.println(comparator1.compare(20,20));
    }

    /**
     * Function在的R apply(T t)
     * Math中的Long round(Double d)
     */
    @Test
    public void test4(){
        //原来的写法
        Function<Double,Long> function=new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(function.apply(1000.5));
        //Lambda表达式
        Function<Double,Long> function1=m->Math.round(m);
        System.out.println(function1.apply(999.5));
        //方法引用
        Function<Double,Long> function2=Math::round;
        System.out.println(function2.apply(999.1));
    }

    /**
     * 情况3:类:实列方法
     * Comparator中的int compare(T t1,T t2)
     * String 中的int t1.compareTo(t2)
     */
    @Test
    public void test5(){

        //Lambda表达式
        Comparator<String> comparator=(s1,s2)->s1.compareTo(s2);
        System.out.println(comparator.compare("abc","abd"));
        //方法引用 这种清除 第一个参数是作为方法的调用者存在 用类写
        Comparator<String> comparator1=String::compareTo;
        System.out.println(comparator1.compare("sdad","sdadw"));
    }

    /**
     * BiPredicate中的 boolean test(T t1,T t2)
     * String中的 s1.equal(s2)
     */
    @Test
    public void test6(){
        //Lambda表达式
        BiPredicate<String,String> predicate=(s1,s2)->s1.equals(s2);
        System.out.println(predicate.test("aa","aa"));
        //方法引用
        BiPredicate<String,String> predicate1=String::equals;
        System.out.println(predicate1.test("ss","ss"));
    }

    /**
     * Function中的R apply(T t)
     * Employee 中的String getName
     */
    @Test
    public void test7(){

        Employee employee = new Employee();
        employee.setSalary(11111.0);
        employee.setName("嘻嘻嘻");
        employee.setAge(18);
        //Lambda表达式
        Function<Employee,String> employeeStringFunction=e->e.getName();
        System.out.println(employeeStringFunction.apply(employee));
        //方法引用
        Function<Employee,String> employeeStringFunction1=Employee::getName;
        System.out.println(employeeStringFunction1.apply(employee));
    }

}
