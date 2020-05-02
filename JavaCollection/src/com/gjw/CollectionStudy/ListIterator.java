package com.gjw.CollectionStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 普通的迭代器只能向前移动，ListIterator用于各种List的访问,而且可以
 * 双向移动，还可以获得前一个元素和后一个元素的索引
 */
public class ListIterator {
    public static void main(String[] args) {

        List<String> myList= Arrays.asList("gjw","xxxxx","abc");
        List<String> list=new ArrayList<>(myList);
        java.util.ListIterator<String> stringListIterator = list.listIterator(1);

        while (stringListIterator.hasPrevious()){
            System.out.println(stringListIterator.previous());
        }
        System.out.println("=====");
        while (stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }
    }
}
