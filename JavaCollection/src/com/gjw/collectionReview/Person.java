package com.gjw.collectionReview;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private Integer age;
    private Integer num;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", num=" + num +
                '}';
    }

    /**
     * 实现类Comparable类就可以实现类与类之间的比较
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person o) {
        if (this.age==o.age)
        {
            return 0;
        }
        else
        {
            return this.age>o.age?1:-1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(num, person.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, num);
    }
}
