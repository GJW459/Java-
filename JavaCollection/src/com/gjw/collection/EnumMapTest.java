/**
 * FileName: EnumMapTest
 * Author:   郭经伟
 * Date:     2020/4/9 15:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.*;

/**
 * 枚举Map
 * key类型为枚举类型
 * 内部以一个非常紧凑的数组存储value
 * 不需要计算hashCode不但效率高,而且没有额外的空间浪费
 */
public class EnumMapTest {

    @Test
    public void test1(){

        Map<DayOfWeek,String> map=new java.util.EnumMap<DayOfWeek, String>(DayOfWeek.class);
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.FRIDAY));
    }
}
