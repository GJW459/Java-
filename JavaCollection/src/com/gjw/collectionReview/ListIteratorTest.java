package com.gjw.collectionReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 普通的迭代器只能向前遍历
 * ListIterator可以双向移动
 */
public class ListIteratorTest {

    public static void main(String[] args) {

        List<String> myList= Arrays.asList("gjw","xxxxx","abc");
        List<String> list=new ArrayList<>(myList);
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        System.out.println("=====");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
