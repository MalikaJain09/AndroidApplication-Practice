package com.auribises.app4.model;

import java.io.Serializable;

public class Customer implements Serializable {
    public  int id;
    public String name;
    public  String phone;
    public  String email;

    public Customer() {
    }

    public Customer(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return  "Customer Details:\n\n" +
                "ID: " + id +
                "\nName: " + name +
                "\nPhone: " + phone +
                "\nEmail: " + email;
    }
}
