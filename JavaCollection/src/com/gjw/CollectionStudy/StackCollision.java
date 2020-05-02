package com.gjw.CollectionStudy;

public class StackCollision {

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        for (String s : "GJW IS BEST".split(" ")){
            stringStack.push(s);
        }
        while (!stringStack.empty()){
            System.out.println(stringStack.pop());
        }

    }
}
