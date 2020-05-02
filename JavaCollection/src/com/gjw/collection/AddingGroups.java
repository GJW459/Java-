package com.gjw.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 添加一组元素
 */
public class AddingGroups {

    public static void main(String[] args) {
        //Arrays.asList可以把一个数组和用逗号分隔开的元素列表转化成List
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        //Collections.addAll()接收一个Collection对象以及一个数组或者逗号分隔的列表
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection,moreInts);
        for (Integer integer : collection) {
            System.out.println(integer);
        }
    }
}
