/**
 * FileName: GenericTest
 * Author:   郭经伟
 * Date:     2020/4/8 21:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 如果不使用泛型
 * 比如ArrayList，不适应泛型，在获取值的时候必须转型
 * 为了解决新的问题，我们必须把ArrayList变成一种模板：ArrayList<T>
 * T代表任意类型 实际上就是Object类型
 */
public class GenericTest {

    //泛型接口 Comparable<T>
    @Test
    public void test1() {
        // 创建可以存储String的ArrayList:
        ArrayList<String> strList = new ArrayList<String>();
        // 创建可以存储Float的ArrayList:
        ArrayList<Float> floatList = new ArrayList<Float>();
        //要特别注意：不能把ArrayList<Integer>向上转型为ArrayList<Number>或List<Number>。
        //因为  ArrayList<Integer>和ArrayList<Number>两者完全没有继承关系。
        List<String> list=new ArrayList<>();
        list.add("hello");
        list.add("world");
        //无需强转就能获得
        String string = list.get(0);
        String string1 = list.get(1);
        System.out.println(string);
        System.out.println(string1);

    }

    @Test
    //泛型接口
    public void test2(){

        Person[] peoples =new Person[] {
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        Arrays.sort(peoples);
        System.out.println(Arrays.toString(peoples));
        //Arrays.sort(Object[])可以对任意数组进行排序，
        // 但待排序的元素必须实现Comparable<T>这个泛型接口：
        //运行程序，我们会得到ClassCastException，即无法将Person转型为Comparable。
        // 我们修改代码，让Person实现Comparable<T>接口：


    }
    //擦拭法

    /**
     * 泛型是一种类似”模板代码“的技术，不同语言的泛型实现方式不一定相同。
     * Java语言的泛型实现方式是擦拭法（Type Erasure）。
     * 所谓擦拭法是指，虚拟机对泛型其实一无所知，所有的工作都是编译器做的。
     * 编译器把类型<T>视为Object；
     * 编译器根据<T>实现安全的强制转型。
     * 泛型局限
     * 局限一：<T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型：
     * 局限二：无法取得带泛型的Class。
     * 局限三：无法判断带泛型的Class：
     * 擦拭法决定了泛型<T>：
     * 不能是基本类型，例如：int；
     * 不能获取带泛型类型的Class，例如：Pair<String>.class；
     * 不能判断带泛型类型的类型，例如：x instanceof Pair<String>；
     * 不能实例化T类型，例如：new T()。
     * 泛型方法要防止重复定义方法，例如：public boolean equals(T obj)；
     * 子类可以获取父类的泛型类型<T>
     * 局限四：不能实例化T类型：
     */
    @Test
    public void test3() throws Exception{

        //要实例化T类型，我们必须借助额外的Class<T>参数：
        Pair<String> stringPair = new Pair<>(String.class);
        //因为传入了Class<String>的实例，所以我们借助String.class就可以实例化String类型。
        //在继承了泛型类型的情况下，子类可以获取父类的泛型类型,获取父类的泛型类型代码比较复杂：


    }
}
