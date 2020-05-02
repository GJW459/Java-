package com.gjw.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用
 * 类型::new
 * 数组引用
 */
public class ConstructorRefTest {

    /**
     * 构造器引用
     * Supplier中的 T get()
     * Employee 中空参构造器
     */
    @Test
    public void test1(){
        Supplier<Employee> employeeSupplier=new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(employeeSupplier.get());
        //Lambda表达式
        Supplier<Employee> employeeSupplier1=()->new Employee();
        System.out.println(employeeSupplier1.get());
        //构造器引用
        Supplier<Employee> employeeSupplier2=Employee::new;
        System.out.println(employeeSupplier2.get());
    }

    /**
     * Function中的R apply(T t)
     */
    @Test
    public void test(){

        //Lambda表达式
        Function<Integer,Employee> function=id->new Employee(id);
        System.out.println(function.apply(15));
        //构造器引用
        Function<Integer,Employee> function1=Employee::new;
        System.out.println(function1.apply(18));
    }

    /**
     * 数组引用 数组看成一个类类型
     */
    @Test
    public void test2(){
        Function<Integer,String[]> function=length->new String[length];
        String[] apply = function.apply(5);
        System.out.println(Arrays.toString(apply));
        //数组引用 把数组看成一个特殊的类 就和构造器引用一致
        Function<Integer,String[]> function1=String[]::new;;
        String[] apply1 = function1.apply(10);
        System.out.println(Arrays.toString(apply1));
    }
}
