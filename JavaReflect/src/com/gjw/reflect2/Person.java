package com.gjw.reflect2;

import com.gjw.reflect2.Creature;
import com.gjw.reflect2.MyAnnotation;
import com.gjw.reflect2.MyInterface;

@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;
    public Person(){

    }
    @MyAnnotation("abc")
    private Person(String name){
        this.name=name;
    }
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是:"+nation);
        return nation;
    }
    public String display(String insterests){
        return insterests;
    }
    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {

    }
    private static void showDesc(){
        System.out.println("大傻逼");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
