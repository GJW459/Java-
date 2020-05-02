package com.gjw.java8;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

    public static List<Employee> getEmployees(){
        List<Employee> list=new ArrayList<>();
        Employee employee1 = new Employee(18, "小李", 3000.0);
        Employee employee2 = new Employee(19, "小明", 4000.0);
        Employee employee3 = new Employee(18, "张三xxx", 5040.0);
        Employee employee4 = new Employee(28, "李四", 5000.0);
        Employee employee5 = new Employee(38, "王五", 7000.0);
        Employee employee6 = new Employee(48, "小郭xxx", 200000.0);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);
        return list;
    }
}
