package com.gjw.collectionReview;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap 哈希查找 + 树
 */
public class HashMapTest {

    @Test
    public void test1()
    {
        Person person1 = new Person();
        person1.setNum(1);
        person1.setName("郭经纬");
        person1.setAge(12);
        Person person2 = new Person();
        person2.setNum(2);
        person2.setName("郭经纬459");
        person2.setAge(13);
        Person person3 = new Person();
        person3.setNum(1);
        person3.setName("郭经纬");
        person3.setAge(12);
        HashMap<Person,String> map = new HashMap<>();
        map.put(person1,"one");
        map.put(person2,"two");
        System.out.println(map.get(person3));
        //遍历
        Set<Person> set = map.keySet();
        for (Person person:set)
        {
            String s = map.get(person);
            System.out.println(person+"="+s);
        }
        for (Map.Entry<Person,String> entry:map.entrySet())
        {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }
}
