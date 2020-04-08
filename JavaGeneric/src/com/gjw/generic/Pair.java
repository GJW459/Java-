/**
 * FileName: Pair
 * Author:   郭经伟
 * Date:     2020/4/8 22:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.generic;

/**
 * 定义泛型类
 * @param <T>
 */
public class Pair<T> {
    private T first;
    private T last;
    public Pair(Class<T> clazz) throws Exception {
       //要实例化T类型，我们必须借助额外的Class<T>参数：
        first = clazz.newInstance();
        last=clazz.newInstance();
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    // 静态泛型方法应该使用其他类型区分:
    //泛型可以同时定义多种类型，例如Map<K, V>。
//    public static <K> Pair<K> create(K first, K last) {
//        return new Pair<K>(first, last);
//    }
}