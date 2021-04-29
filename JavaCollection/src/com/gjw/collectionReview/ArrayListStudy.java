package com.gjw.collectionReview;


import java.util.*;

/**
 * ArrayList 对应的就是数据结构中的线性表 顺序表
 * 底层为数组 动态扩展顺序表的大小
 */
public class ArrayListStudy {

    public static void main(String[] args) {

        Random random = new Random(47);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6));
        list1.add(1);
        list1.add(2);
        System.out.println(list1.indexOf(2));//元素2所在的索引
        System.out.println("remove:"+list1.remove(1));
        for (Integer data : list1)
        {
            System.out.println(data);
        }
        System.out.println("=============");
        Person person1 = new Person();
        person1.setAge(12);
        person1.setName("郭经纬");
        person1.setNum(1);
        Person person2 = new Person();
        person2.setAge(13);
        person2.setName("郭经纬1");
        person2.setNum(2);
        Person person3 = new Person();
        person3.setAge(12);
        person3.setName("郭经纬2");
        person3.setNum(12);
        ArrayList<Person> people = new ArrayList<>(Arrays.asList(person1, person2, person3));
        System.out.println(people.get(1));
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("=============");

        Collections.sort(list1);
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        Collections.shuffle(list1);
        System.out.println("洗牌后============");
        for (Integer integer : list1) {
            System.out.println(integer);
        }
    }
}
