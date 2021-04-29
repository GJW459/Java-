package com.gjw.java8.secondStudy;

import com.gjw.java8.Employee;
import com.gjw.java8.EmployeeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author 郭经伟
 * @Date 2021/4/3
 * <p>
 * Java8新特性
 * 1.函数式接口
 * 2.Lambada表达式
 * 3.方法引用和构造器引用
 * 4.Stream API
 * 5.接口的增强 静态方法 默认方法
 * 6.Optional类
 * 7.新的日期和时间API
 **/
public class Java8Test2 {


    /**
     * Lambda表达式 是一个匿名函数=> 一段可以传递的代码，将代码向数据一样进行传递
     */
    @Test
    public void test1() {

        //右边是一个匿名实现类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("you are SB");
            }
        };
        runnable.run();
        System.out.println("******");
        //使用Lambda表达式
        Runnable runnable1 = () -> System.out.println("you are SB");
        runnable1.run();
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

        //情况1 无参无返回
        Runnable runnable2 = () -> System.out.println("i love you");
        runnable2.run();
        //情况2 有一参数 无返回
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("你和我的区别是什么?");
        System.out.println("lambda的写法");
        Consumer<String> consumer1 = (String s) -> System.out.println(s);
        consumer1.accept("我不喜欢你");

        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
        System.out.println(comparator.compare(10, 20));
        Comparator<Integer> comparator1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparator1.compare(15, 20));
    }

    /**
     * 函数式接口
     */
    @Test
    public void test2() {

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

        // 使用消费性函数式接口
        // 原来的写法
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("去天上人间消费:" + aDouble + "元");
            }
        });
        //lambda写法
        happyTime(400, money -> System.out.println("去书店花费" + money));
        System.out.println("************");


        // 使用断定型接口

        List<String> list = Arrays.asList("北京", "天津", "上海", "南京", "东京");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);
        List<String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2);
    }

    private void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    private List<String> filterString(List<String> list, Predicate<String> pre) {
        List<String> arrayList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }

    /**
     * stream API的使用
     */
    @Test
    public void test3() {
        /**
         * java8两个重要的改变:1.Lambda表达式 2. StreamAPI
         * StreamAPI:把真正的函数式编程风格引入java ,java类库最好的补充 java.util.stream包下
         * 简化代码
         * StreamAPI 可以对集合的数据进行操作 类似于SQL对于数据库进行查询
         *
         * 为啥用StreamAPI
         * 实际开发中,项目中大部分的数据源来自于Oracle,Mysql,但是现在还有NoSql MongoDB和Redis,而这些
         * NoSql的数据就交给java处理
         * Stream和Collection的区别 :Collection是一种静态的内存数据结构,而Stream是有关计算的,面向CPU的,通过CPU实现计算
         * Stream不会存储数据
         * 不会改变源对象
         * 延迟执行
         *
         * Stream 的操作三个步骤
         * 1.创建Stream 一个数据源 如:集合,数组,获取一个流
         * 2.中间操作 一个中间操作链,对数据源的数据进行处理 过滤,映射
         * 3.终止操作(终端操作)
         * 一旦执行终止操作,就执行中间操作链,并产生结构,之后,不会再被使用
         */

        //创建一个Stream方式一：通过集合

        // Collection接口创建Stream
        List<String> list = Arrays.asList("张三", "李四", "王五", "小郭", "小明");
        //顺序流 按照容器中的顺序进行操作
        Stream<String> stream = list.stream();
        //并行流 同时对所有流进行操做
        Stream<String> stream1 = list.parallelStream();


    }

    /**
     * 筛选 和 切片
     */
    @Test
    public void test4() {

        List<Employee> employees = EmployeeUtils.getEmployees();
        //filter(Predicate p)接受 Lambda从流中排除某些元素
        Stream<Employee> stream = employees.stream();
        //查询员工中工资高于7000的
        stream.filter(employee -> employee.getSalary() > 7000).forEach(employee -> System.out.println(employee));
        System.out.println("*******");
        //limit截断流
        employees.stream().limit(3).forEach(employee -> System.out.println(employee));
        // skip(n)跳过元素
        employees.stream().skip(4).forEach(employee -> System.out.println(employee));
        // distinct 筛选 通过流所生成元素的hashcode 和 equals去重复
        employees.add(new Employee(13,"xx",1000.0));
        employees.add(new Employee(13,"xx",1000.0));
        employees.add(new Employee(13,"xx",1000.0));
        employees.add(new Employee(13,"xx",1000.0));
        employees.add(new Employee(13,"xx",1000.0));
        System.out.println("**********");
        System.out.println(employees);
        System.out.println("********");
        employees.stream().distinct().forEach(System.out::println);



    }

    /**
     * 映射
     * 由自变量得到因变量
     */
    @Test
    public void test5(){

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //由自变量得到因变量
        list.stream().map(str->str.toUpperCase()).forEach(str-> System.out.println(str));
        //获得员工名字长度大于3的名字
        List<Employee> employees = EmployeeUtils.getEmployees();
        employees.stream().map(employee -> employee.getName()).filter(name->name.length()>3).forEach(employee-> System.out.println(employee));

    }

    /**
     * 排序
     */
    @Test
    public void test6(){

        List<Integer> list = Arrays.asList(1, 0, -1, 20, -20, 30);
        //sort()自然排序
        list.stream().sorted().forEach(i-> System.out.println(i));
        //sort(Comparator)定制排序
        List<Employee> employees = EmployeeUtils.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
    }


    /**
     * 终止操作
     * 匹配和查找
     */
    public void test7(){
        List<Employee> employees = EmployeeUtils.getEmployees();
        // 是否所有员工年龄都大于18
        boolean flag = employees.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(flag);
        
    }
}
