package com.gjw.CollectionStudy;

import java.util.*;

/**
 * ArrayList的基本使用
 */
public class ArrayListStudy {
    public static void main(String[] args) {

//        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //ArrayList 类似于一个动态变化大小的数组，适合随机访问，不适合在List中进行insert或者remove，
        // 因为会大量移动数组里面的元素 费时

        Random random=new Random(47);
        List<Integer> list=new ArrayList<>(Arrays.asList(2,3,4,5));
        list.add(1);
        list.add(2);
        System.out.println(list.indexOf(2));
        System.out.println("remove:"+list.remove(1));
        List<Integer> list1 = list.subList(1, 3);//子列表
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("============");
        System.out.println(list.containsAll(list1));
        System.out.println("排序后的顺序");
        Collections.sort(list1);
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        Collections.shuffle(list1);//洗牌
        System.out.println("洗牌后============");
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        boolean empty = list.isEmpty();
        System.out.println(empty);
        list.removeAll(list);
        System.out.println(list.size());
        //ArrayList的contain indexof remove...需要在list中查找元素的都需要覆盖equals方法



    }
}
