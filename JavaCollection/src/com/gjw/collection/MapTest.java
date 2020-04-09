/**
 * FileName: MapTest
 * Author:   郭经伟
 * Date:     2020/4/9 15:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import org.junit.Test;
import java.util.*;

/**
 * 当List需要通过name获取一个Person，那就很麻烦，需要遍历List
 * 一个新的数据结构就出来了Map，映射表K-V
 * 通过key快速查找value
 * Map是一种关联数组
 * Map中不存在重复的key，因为放入相同的key，
 * 只会把原有的key-value对应的value给替换掉。
 */
public class MapTest {

    @Test
    public void test1(){

        Person person = new Person("xiao ming", 18);
        Map<String,Person> map=new HashMap<>();
        map.put("XM",person);//XM和person实列映射并关联
        Person person1 = map.get("XM");
        System.out.println(person==person1);
        System.out.println(person1.getAge());
        Person person2 = map.get("bob");
        System.out.println(person2);
    }

    @Test
    //遍历map
    public void test2(){
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);
        //通过keySet返回的Set集合
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
        //同时遍历key value使用entrySet() 获取k v对
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"="+value);
        }
        //Map和List不同的是Map储存的是k-v映射关系,不保证顺序,遍历的顺序是无序的
    }

    /**
     * Map之所以能够通过key直接拿到value，原因是内部使用了空间换时间的方法，
     * 用一个大数组储存所有的value，并且通过key计算出value的索引值，再获取
     * 不必遍历整个数组
     * 在map的内部key的比较是通过key对象的equals方法实现的和List查找元素需要正确
     * 复写equals方法一样
     * 我们经常使用String作为key，因为String已经正确覆写了equals()方法。
     * 但如果我们放入的key是一个自己写的类，就必须保证正确覆写了equals()方法。
     * HashMap是怎么通过key计算出value储存的索引
     * key计算索引的方式就是调用key对象的hashCode()方法，它返回一个int整数。
     * HashMap正是通过这个方法直接定位key对应的value的索引，继而直接返回value。
     */
    /**
     * 为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
     * 作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
     * 如果两个对象相等，则两个对象的hashCode()必须相等；
     * 如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
     */
    @Test
    public void test3(){

        Map<Person,String> map=new HashMap<>();
        map.put(new Person("xm",18),"xixi");
        String string = map.get(new Person("xm", 18));
        System.out.println(string);

    }
}
