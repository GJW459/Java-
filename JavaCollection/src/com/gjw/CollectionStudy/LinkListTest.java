package com.gjw.CollectionStudy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * remove和Insert更加高效
 * LinkedList还添加了用作栈和队列和双端队列的方法
 */
public class LinkListTest {
    public static void main(String[] args) {
        List<String> myList= Arrays.asList("gjw","xxxxx","abc");
        LinkedList<String> list=new LinkedList<>(myList);
        System.out.println(list.getFirst());
        System.out.println(list.element());
        System.out.println(list.peek());
        System.out.println(list.remove());
        System.out.println(list.poll());
        System.out.println(list.removeFirst());

    }
}
