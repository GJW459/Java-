/**
 * FileName: QueueTest
 * Author:   郭经伟
 * Date:     2020/4/9 16:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 队列（Queue）是一种经常使用的集合。Queue实际上是实现了一个先进先出（FIFO：First In First Out）的有序表。它和List的区别在于，List可以在任意位置添加和删除元素，而Queue只有两个操作：
 * 把元素添加到队列末尾；
 * 从队列头部取出元素。
 */
public class QueueTest {

    @Test
    public void test1(){

        //最好不要插入null
        Queue<String> queue=new LinkedList<>();
        queue.offer("abc");
        queue.offer("def");
        queue.offer("jkl");
        //获取对头，并删除 poll方法
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());//最后为null
        //获取对头，不删除对头元素
        Queue<String> queue1=new LinkedList<>();
        queue1.offer("abc");
        queue1.offer("def");
        queue1.offer("jkl");
        System.out.println("=========");
        System.out.println(queue1.peek());
        System.out.println(queue1.peek());
        System.out.println(queue1.peek());
        System.out.println(queue1.peek());
        System.out.println(queue1.peek());
        /**
         * 队列Queue实现了一个先进先出（FIFO）的数据结构：
         * 通过add()/offer()方法将元素添加到队尾；
         * 通过remove()/poll()从队首获取元素并删除；
         * 通过element()/peek()从队首获取元素但不删除。
         * 要避免把null添加到队列。
         */

    }
    //PriorityQueue
    /**
     * 这个时候，我们发现，要实现“VIP插队”的业务，用Queue就不行了，因为Queue会严格按FIFO的原则取出队首元素。我们需要的是优先队列：PriorityQueue。
     * PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。
     * 要使用PriorityQueue，我们就必须给每个元素定义“优先级”
     */
    @Test
    public void test2(){
        //放入PriorityQueue的元素，必须实现Comparable接口，PriorityQueue会根据元素的排序顺序决定出队的优先级
        /**
         * public int compare(Object o1, Object o2)
         * 本来的顺序就是知参数的先后顺序o1、o2；
         * 如果保持这个顺序就返回-1，交道换顺回序就返回1，什么都不做就返回0；
         * 所以 升序答的话 如果o1<o2，就返回-1。
         */
        Queue<User> users=new PriorityQueue<>(new UserCompratar());
        users.offer(new User("A","A2"));
        users.offer(new User("B","A1"));
        users.offer(new User("C","V1"));
        System.out.println(users.poll());
        System.out.println(users.poll());
        System.out.println(users.poll());
        System.out.println(users.poll());
    }
}
