/**
 * FileName: ListTest
 * Author:   郭经伟
 * Date:     2020/4/8 22:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//java集合
//容器:List:有序的列表,插入有序，遍历有序

/**
 * 在List中查找元素时，List的实现类通过元素的equals()方法比较两个元素是否相等，
 * 因此，放入的元素必须正确覆写equals()方法，Java标准库提供的String、Integer等已经覆写了equals()方法；
 * 编写equals()方法可借助Objects.equals()判断。
 * 如果不在List中查找元素，就不必覆写equals()方法。
 */
public class ListTest {

    @Test
    public void test1(){

        List<String> list=new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("apple");//运行添加重复元素
        System.out.println(list.size());
    }
    @Test
    public void test2(){
        //list还运行添加null
        List<String> list=new ArrayList<>();
        list.add("apple");
        list.add(null);
        String string = list.get(1);
        System.out.println(string);

    }
    //创建List 遍历List
    @Test
    public void test3(){

        Integer [] numbers=new Integer[]{1,2,5};
        List<Integer> list =new ArrayList<>();
        for (Integer number : numbers) {
            list.add(number);
        }
        //遍历List 通过索引
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            System.out.println(integer);
        }
        //但这种方式并不推荐，一是代码复杂，二是因为get(int)方法只有ArrayList的实现是高效的
        // 换成LinkedList后，索引越大，访问速度越慢。
        //用迭代器遍历
        for (Iterator<Integer> iterator = list.iterator();iterator.hasNext();){
            Integer next = iterator.next();
            System.out.println(next);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer next = it.next();
            System.out.println(next);
        }


    }

    //list<=>Array
    @Test
    public void test4(){
        List<String> list=new ArrayList<>();
        list.add("apple");
        list.add("peal");
        list.add("banana");
        //少,会丢失类型信息
        Object[] objects = list.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
        //第二种较多，指明类型 转化的数组类型
        String[] strings = list.toArray(new String[3]);
        for (String string : strings) {
            System.out.println(string);
        }
        //List是按索引顺序访问的长度可变的有序表，优先使用ArrayList而不是LinkedList；


    }
    @Test
    public void test5(){
        //List内部并不是通过==判断两个元素是否相等，
        // 而是使用equals()方法判断两个元素是否相等
        /**
         * 要正确使用List的contains()、indexOf()这些方法，放入的实例必须正确覆写equals()方法，否则，放进去的实例，查找不到。
         * 我们之所以能正常放入String、Integer这些对象，是因为Java标准库定义的这些类已经正确实现了equals()方法。
         */
        List<Person> personList=new ArrayList<>();
        personList.add(new Person("XIAO MING",18));
        personList.add(new Person("XIAO HONG",18));
        personList.add(new Person("BOB",18));
        System.out.println(personList.contains(new Person("BOB",18)));//false
        System.out.println(personList.indexOf(new Person("BOB",18)));//-1
        //为什么会出现上面的结果呢，因为没有重写equals方法

    }
}
