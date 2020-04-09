/**
 * FileName: DequeTest
 * Author:   郭经伟
 * Date:     2020/4/9 17:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 如果把条件放松一下，允许两头都进，两头都出，这种队列叫双端队列（Double Ended Queue），学名Deque。
 * Java集合提供了接口Deque来实现一个双端队列，它的功能是：
 * 既可以添加到队尾，也可以添加到队首；
 * 既可以从队首获取，又可以从队尾获取。
 * Deque实现了一个双端队列（Double Ended Queue），它可以：
 * 将元素添加到队尾或队首：addLast()/offerLast()/addFirst()/offerFirst()；
 * 从队首／队尾获取元素并删除：removeFirst()/pollFirst()/removeLast()/pollLast()；
 * 从队首／队尾获取元素但不删除：getFirst()/peekFirst()/getLast()/peekLast()；
 * 总是调用xxxFirst()/xxxLast()以便与Queue的方法区分开；
 * 避免把null添加到队列。
 */
public class DequeTest {

    @Test
    public void test1(){
        Deque<String> deque=new LinkedList<>();
        deque.offerLast("abv");
        deque.offerLast("bc");
        deque.offerLast("fg");
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
    }
}
