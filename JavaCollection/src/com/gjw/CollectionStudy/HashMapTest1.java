package com.gjw.CollectionStudy;
import java.util.*;
public class HashMapTest1 {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        Random random=new Random(47);
        for (int i = 0; i < 10000; i++) {
            int i1 = random.nextInt(20);
            Integer integer = map.get(i1);
            map.put(i1,integer==null?1:integer+1);
        }
        System.out.println(map);
    }
}
