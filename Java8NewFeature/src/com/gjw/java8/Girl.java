package com.gjw.java8;

public class Girl {

    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
