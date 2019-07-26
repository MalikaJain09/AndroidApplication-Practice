package com.auribises.app4;

import java.io.Serializable;

public class Person implements Serializable {
   public String name;
    public String phone;
    public String age;
    public Person() {

    }
    public Person(String name, String phone, String age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
