package com.gjw;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

/**
 * @author 郭经伟
 * @Date 2021/4/29
 * 流主要是用于计算 数组 文件 集合 函数。。
 **/
public class StreamAPIStudy {


    /**
     * 生成流
     */
    public void createStream() throws IOException {

        /**
         * 列表生成流
         */
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = integers.stream();
        int[] intArr = new int[]{1, 2, 3, 4, 5};
        /**
         * 数组生成流
         * 生成的是数值流
         * 使用数值流可以避免计算过程中装箱和拆箱 提高性能
         * Stream API提供了mapToInt、mapToDouble、mapToLong
         * 三种方式将对象流【即Stream<T>】转换成对应的数值流，
         * 同时提供了boxed方法将数值流转换为对象流
         */
        IntStream intStream = Arrays.stream(intArr);
        Stream<Integer> boxed = intStream.boxed();
        /**
         * 通过值生成流
         * 通过Stream的of方法生成流，通过Stream的empty方法可以生成一个空流
         */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        /**
         * 通过文件生成流
         * 通过Files.line方法得到一个流，并且得到的每个流是给定文件中的一行
         */
        Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());

        /**
         * 通过函数生成流 提供了 iterate和generate 两个静态方法从函数中生成流
         * iterate方法接受两个参数，第一个为初始化值，第二个为进行的函数操作，
         * 因为iterator生成的流为无限流，
         * 通过limit方法对流进行了截断，只生成5个偶数
         */
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(5);
        /**
         * generate方法接受一个参数，方法参数类型为Supplier<T>，由它为流提供值。
         * generate生成的流也是无限流，因此通过limit对流进行了截断
         */
        Stream<Double> doubleStream = Stream.generate(Math::random).limit(5);

    }

    public void StreamOperation() {

        /**
         * 流的操作类型主要分为两种
         * 中间操作 一个流可以后面跟随零个或多个中间操作。
         * 其目的主要是打开流，做出某种程度的数据映射/过滤，
         * 然后返回一个新的流，交给下一个操作使用。
         * 这类操作都是惰性化的，仅仅调用到这类方法，
         * 并没有真正开始流的遍历，真正的遍历需等到终端操作时，
         * 常见的中间操作有下面即将介绍的filter、map等
         * 终端操作 一个流有且只能有一个终端操作，
         * 当这个操作执行后，流就被关闭了，
         * 无法再被操作，因此一个流只能被遍历一次，
         * 若想在遍历需要通过源数据在生成流。
         * 终端操作的执行，才会真正开始流的遍历。
         * 如下面即将介绍的count、collect等
         */

        /**
         * 中间操作
         */
        // filter筛选
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = integerList.stream().filter(i -> i > 3);
        // distinct去除重复元素
        List<Integer> integerList1 = Arrays.asList(1, 1, 2, 3, 4, 5);
        Stream<Integer> stream1 = integerList1.stream().distinct();
        // limit 返回指定流个数
        List<Integer> integers = Arrays.asList(1, 1, 2, 3, 4, 5);
        // 通过limit方法指定返回流的个数，limit的参数值必须>=0 否则将会抛出异常
        Stream<Integer> limit = integers.stream().limit(3);
        // skip跳过流中的元素
        List<Integer> integers1 = Arrays.asList(1, 1, 2, 3, 4, 5);
        //  2, 3, 4, 5 =>output
        Stream<Integer> stream2 = integers1.stream().skip(2);
        // map流映射
        List<String> list = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        // 这里是 string=>string长度的映射
        list.stream().map(s -> s.length());
        // flatMap流转换
        // 将一个流中的每个值都转换为另一个流
        List<String> strings = Arrays.asList("Hello", "World");
        List<String> stringList = strings.stream()
                .map(w -> w.split(" "))
                .flatMap(strings1 -> Arrays.stream(strings1))
                .distinct()
                .collect(Collectors.toList());
        //元素匹配
        //allMatch匹配所有
        List<Integer> integers2 = Arrays.asList(1, 2, 3, 4, 5);
        if (integers2.stream().allMatch(i->i>3)){
            System.out.println("值都大于3");
        }
        //anyMatch匹配其中一个 返回第一个满足的数 也就是4
        if (integers2.stream().anyMatch(i->i>3)){
            System.out.println("存在大于3的值");
        }
        //noneMatch全部不匹配
        if (integers2.stream().noneMatch(i->i>3)){
            System.out.println("值都小于3");
        }
    }


    public void StreamTerminal(){
        // 统计流中元素个数
        // 通过count
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        long result = integers.stream().count();
        // 通过count方法统计出流中元素个数
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Long result2 = integerList.stream().collect(counting());
        // 查找
        Optional<Integer> integer = integerList.stream().filter(i -> i > 3).findFirst();
        // findAny随机查找一个


        // reduce将流中的元素组合起来
        // 对集合求和 java8之前
        int sum=0;
        for (int i:integerList){
            sum+=i;
        }
        // jdk8
        /**
         * reduce接受两个参数，一个初始值这里是0，
         * 一个BinaryOperator<T> accumulator
         * 来将两个元素结合起来产生一个新值，
         * 另外reduce方法还有一个没有初始化值的重载方法
         */
        integerList.stream().reduce(0,(a,b)->(a+b));
        // 获取流中最小最大值
//        Optional<Integer> min = menu.stream().map(Dish::getCalories).min(Integer::compareTo);
//        Optional<Integer> max = menu.stream().map(Dish::getCalories).max(Integer::compareTo);

        // 使用foreach变量
        integerList.forEach(i-> System.out.println(i));
        // 返回集合
        /**
         * List<String> strings = menu.stream().map(Dish::getName).collect(toList());
         * Set<String> sets = menu.stream().map(Dish::getName).collect(toSet());
         */
        // 通过joining拼接流中的元素
        // String result = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        // 进阶通过groupingBy进行分组
        // Map<Type, List<Dish>> result = dishList.stream().collect(groupingBy(Dish::getType));
        /**
         * 在collect方法中传入groupingBy进行分组，
         * 其中groupingBy的方法参数为分类函数。
         * 还可以通过嵌套使用groupingBy进行多级分类
         * Map<Type, List<Dish>> result = menu.stream().collect(groupingBy(Dish::getType,
         *         groupingBy(dish -> {
         *             if (dish.getCalories() <= 400) return CaloricLevel.DIET;
         *                 else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
         *                 else return CaloricLevel.FAT;
         *         })));
         */
        // 进阶通过partitioningBy进行分区
        // 分区是特殊的分组，它分类依据是true和false，所以返回的结果最多可以分为两组
        // Map<Boolean, List<Dish>> result = menu.stream().collect(partitioningBy(Dish :: isVegetarian))

    }



    @Test
    public void test1(){
        List<String> strings = Arrays.asList("Hello", "World");
        List<String> stringList = strings.stream()
                .map(w -> w.split(" "))
                .flatMap(strings1 -> Arrays.stream(strings1))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(s-> System.out.println(s));
    }
}
