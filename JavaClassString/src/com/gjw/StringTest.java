package com.gjw;

/**
 * 正则表达式学习
 */
public class StringTest {
    public static void main(String[] args) {
        for (String pattern : new String[]{"Rudolph","[rR]udolph","[rR][aeiou][a-z]ol.*"}){
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
