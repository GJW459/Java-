package com.gjw.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class StreamAPITest {

    /**
     * 创建Stream方式一:通过集合
     */
    @Test
    public void test1(){
        /**
         * default Stream<E> stream() {
         *         return StreamSupport.stream(spliterator(), false);
         *     }//返回一个顺序流
         *
         * default Stream<E> parallelStream() {
         *         return StreamSupport.stream(spliterator(), true);
         *     }//返回一个并行流
         */

        // 方式1.Collection接口创建Stream
        List<String> list = Arrays.asList("张三", "李四", "王五", "小郭", "小明");
        //顺序流 按照容器中的顺序进行操作
        Stream<String> stream = list.stream();
        //并行流 同时对所有进行操作
        Stream<String> stringStream = list.parallelStream();
        //方式2.通过数组创建Stream流 Arrays
        Stream<String> stream1 = Arrays.stream(new String[]{"张三", "李四", "王五", "小郭", "小明"});
        //方式3.通过Stream的of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        //方式4.创建无限流 迭代 帮我们造数据
        //遍历前10个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);



    }

    /**
     * Stream的中间操作
     * 1.筛选和切片
     */
    @Test
    public void test2(){
        List<Employee> employees = EmployeeUtils.getEmployees();
        //filter(Predicate p)-接收 Lambda 从流中排除某些元素
        Stream<Employee> stream = employees.stream();
        //查询员工中工资高于7000的
        stream.filter(e->e.getSalary()>7000).forEach(System.out::println);
        System.out.println();
        //limit(n) 截断流,使其元素不超过给定数量
        employees.stream().limit(3).forEach(System.out::println);
        //skip(n)跳过元素,返回一个扔掉了前n个元素的流。若流中元素不足n个,则返回一个空流,与limit(n)互补
        employees.stream().skip(4).forEach(System.out::println);
        //distinct --筛选 ,通过流所生成元素的hashCode()和equals去除重复元素
        employees.add(new Employee(13,"xx",1000.0));
        employees.add(new Employee(13,"xx",1000.0));
        employees.add(new Employee(13,"xx",1000.0));
        employees.add(new Employee(13,"xx",1000.0));
        employees.add(new Employee(13,"xx",1000.0));
        System.out.println(employees);
        employees.stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射
     */
    @Test
    public void test3(){
        //map(Function f) 接收一个函数作为参数,将元素转换成其他形式或提取信息,该函数会被应用到每个元素上
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //自变量 得到 因变量
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        //获取员工姓名长度大于3员工的姓名
        List<Employee> employees = EmployeeUtils.getEmployees();
        employees.stream().map(Employee::getName).filter(name->name.length()>3).forEach(System.out::println);
        //flatMap(Function f)  -接收一个函数作为参数,将流中的每个值都换为另一个流,然后把所有流连成一个流
        //map 类似于 list.add flatMap 类似于 list.addAll
        //举例map
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest::fromStringToStream);
        streamStream.forEach(s->s.forEach(System.out::println));
        System.out.println("============");
        //举例flatMap
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest::fromStringToStream);
        characterStream.forEach(System.out::println);


    }
    //将字符串中的多个字符构成的集合转换为对应的stream实列
    public static Stream<Character> fromStringToStream(String string){
        List<Character> characters=new ArrayList<>();
        for (char c : string.toCharArray()) {
            characters.add(c);
        }
        return characters.stream();
    }

    /**
     * 3.排序
     */
    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(1, 0, -1, 20, -20, 30);
        //sort()自然排序
        list.stream().sorted().forEach(System.out::println);
        //sort(Comparator) 定制排序
        //如 Employee对象要想排序 需要 实现那两种接口
        List<Employee> employees = EmployeeUtils.getEmployees();
        employees.stream().sorted(((o1, o2) -> {
            int compare = Integer.compare(o1.getAge(), o2.getAge());
            return compare!=0?compare:Double.compare(o1.getSalary(),o2.getSalary());
        })).forEach(System.out::println);
    }

    /**
     * 终止操作
     * 1-匹配和查找
     */
    @Test
    public void test5(){
        List<Employee> employees = EmployeeUtils.getEmployees();
        //allMatch(Predicate p) -检查是否匹配所有元素
        //练习:是否所有员工的年龄都大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
        //anyMatch(Predicate p) 检查是否至少匹配一个元素
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);
        //noneMatch: 检查是否没有匹配元素
        boolean b2 = employees.stream().noneMatch(e -> e.getName().contains("郭"));
        System.out.println(b2);
        //findFirst 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //findAny 返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        //count 返回一个流中的元素个数
        long count = employees.stream().count();
        System.out.println(count);
        long count1 = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count1);
        //max 返回流中的最大值
        //返回员工中的最高工资
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> max = doubleStream.max(Double::compareTo);
        System.out.println(max);
        //返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e1.getSalary()));
        System.out.println(min);
        //ForEach 内部迭代 Stream API使用内部迭代
        employees.stream().forEach(System.out::println);
        //Collection 外部迭代
        employees.forEach(System.out::println);

    }

    /**
     * 2.归约
     */
    @Test
    public void test6(){
        //reduce(T identity,BinaryOperator) - 可以将流中的元素反复结合起来,得到一个值,返回T
        //练习1-10的自然数和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        //reduce(BinaryOperator) -可以将流中的元素反复结合起来,得到一个值.返回Optional<T>
        //练习:计算公司所有员工工资的总和
        List<Employee> employees = EmployeeUtils.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        System.out.println(reduce1);
    }

    /**
     * 3.收集
     */
    @Test
    public void test7(){
        //collect(Collector c) Collectors有很多静态方法
        //练习工资大于6000的员工
        List<Employee> employees = EmployeeUtils.getEmployees();
        List<Employee> collect = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println();
        Set<Employee> collect1 = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}
