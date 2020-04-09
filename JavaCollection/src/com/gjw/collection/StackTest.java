/**
 * FileName: StackTest
 * Author:   郭经伟
 * Date:     2020/4/9 17:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import org.junit.Test;

import java.util.Stack;

/**
 * 栈：先进后出 队列 先进先出
 * 栈（Stack）是一种后进先出（LIFO：Last In First Out）的数据结构。
 * Stack只有入栈和出栈的操作：
 * 把元素压栈：push(E)；
 * 把栈顶的元素“弹出”：pop(E)；
 * 取栈顶元素但不弹出：peek(E)。
 * 在Java中，我们用Deque可以实现Stack的功能：
 * 把元素压栈：push(E)/addFirst(E)；
 * 把栈顶的元素“弹出”：pop(E)/removeFirst()；
 * 取栈顶元素但不弹出：peek(E)/peekFirst()。
 */
public class StackTest {

    @Test
    public void test1(){
        //测试栈
        Stack<String> stack=new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
