/**
 * FileName: Person
 * Author:   郭经伟
 * Date:     2020/4/9 14:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Person){
//            boolean nameEuqals=false;
//            Person person = (Person) obj;
//            //this.name.equals的时候this.name=null 会出现空指针异常
//            if (this.name==null&&person.name==null){
//                nameEuqals=true;
//            }
//            if (this.name!=null){
//                //当不为空的时候再equals比较
//                nameEuqals=this.name.equals(person.name);
//            }
//            return nameEuqals && this.age==person.age;
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Person){
            Person person = (Person) obj;
           //如果Person有好几个引用类型的字段，上面的写法就太复杂了。
            // 要简化引用类型的比较，我们使用Objects.equals()静态方法：
            return Objects.equals(this.name,person.name)&&this.age==person.age;
        }
        return false;
    }

    /**
     * 要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；
     * 一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：
     * 如果equals()返回true，则hashCode()返回值必须相等；
     * 如果equals()返回false，则hashCode()返回值尽量不要相等。
     * 实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name,this.age);
    }

    @Override
    public int compareTo(Person o) {
        if (this.age==o.age){
            return 0;
        }

        return this.age>o.age?1:-1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
