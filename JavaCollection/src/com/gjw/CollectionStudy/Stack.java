package com.gjw.CollectionStudy;

import java.util.LinkedList;

/**
 * 栈 前进后出的数据结构
 */
public class Stack<T> {
    //可以通过LinkList实现栈
    private LinkedList<T> linkedList=new LinkedList<>();
    /**
     * 1.getFirst()和element()完全一样返回列表的第一个元素
     * 2.removeFirst()和remove()移除并返回列表的头
     * 3.addFirst()插入列表尾部
     * 4.removeLast()移除并返回列表的最后一个元素
     */

    /**
     * 入栈
     * @param v
     */
    public void push(T v){
        linkedList.addFirst(v);
    }
    public T peek(){
        return linkedList.getFirst();
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
       return linkedList.removeFirst();
    }
    public boolean empty(){
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
