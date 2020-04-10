/**
 * FileName: Person
 * Author:   郭经伟
 * Date:     2020/4/10 21:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.io;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = -7408697401927996347L;
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
