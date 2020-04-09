/**
 * FileName: TheeMapTest
 * Author:   郭经伟
 * Date:     2020/4/9 16:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import org.junit.Test;
import java.util.*;

/**
 * 还有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。
 * 注意到SortedMap是接口，它的实现类是TreeMap
 * 使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，
 * 因此可以直接作为Key使用。作为Value的对象则没有任何要求。
 */
public class TheeMapTest {

    @Test
    public void test1(){

        Map<Person,Integer> map=new TreeMap<>();
        map.put(new Person("XM",18),1);
        map.put(new Person("XL",22),2);
        map.put(new Person("XG",20),3);
        Set<Person> people = map.keySet();
        for (Person person : people) {
            System.out.println(person);
        }
    }

}
