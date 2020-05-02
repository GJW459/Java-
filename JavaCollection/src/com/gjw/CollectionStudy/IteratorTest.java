package com.gjw.CollectionStudy;

import java.util.*;

/**
 * 迭代器测试:迭代器统一了对容器的访问
 */
public class IteratorTest {

    public static void display(Iterator<String> iterator ){
        //遍历迭代器
        System.out.println("开始");
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("结束");
    }
    public static void main(String[] args) {

        List<String> myList=Arrays.asList("gjw","xxxxx","abc");

        List<String> list=new ArrayList<>(myList);
        List<String> list2=new LinkedList<>(myList);
        HashSet<String> hashSet=new HashSet<>(myList);
        TreeSet<String> treeSet=new TreeSet<>(myList);
        //获取迭代器 统一遍历容器
        //普通的迭代器只能向前移动不能向后移动
        IteratorTest.display(list.iterator());
        IteratorTest.display(list2.iterator());
        IteratorTest.display(hashSet.iterator());
        IteratorTest.display(treeSet.iterator());
    }
}
