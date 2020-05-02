package com.gjw.CollectionStudy;

import java.util.Stack;

/**
 * 测试栈
 */
public class StackTest2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "GJW IS BEST".split(" ")){
            stack.push(s);//入栈
        }
        while (!stack.isEmpty()){

            //出栈
            System.out.println(stack.pop());
        }
    }
}
