package com.gjw.collectionReview;

import java.util.*;

/**
 * 迭代器测试 迭代器统一对容器进行访问
 */
public class IteratorTest {

    public static void display(Iterator<String> iterator)
    {
        System.out.println("开始");
        while (iterator.hasNext())
        {
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("结束");
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("gjw", "zy", "gsh", "gx");

        List<String> list1 = new ArrayList<>(list);
        List<String> list2 = new LinkedList<>(list);
        Set<String> set=new HashSet<>(list);
        TreeSet<String> treeSet = new TreeSet<>(list);
        IteratorTest.display(list1.iterator());
        IteratorTest.display(list2.iterator());
        IteratorTest.display(set.iterator());
        IteratorTest.display(treeSet.iterator());
    }
}
