package com.gjw.CollectionStudy;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest2 {

    public static void main(String[] args) {

        //字母序排序
        SortedSet<String> set=new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.add("adwadadawdacxcawdawddwa");
        System.out.println(set);
    }
}
