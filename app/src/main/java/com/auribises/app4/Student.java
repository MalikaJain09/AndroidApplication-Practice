package com.auribises.app4;

import java.io.Serializable;

public class Student implements Serializable {

    public String rollNo;
    public String name;
    public String branch;
    public String semester;
    public String email;
    public String phone;
    public String mothersName;
    public String fathersName ;
    public String permanetAddress;
    public String gender;
    public float rating;
    public String city;

    public Student()  {
    }



    public Student(String date, String rollNo, String name,String gender, String branch, String semester, String email, String phone, String mothersName, String fathersName, String permanetAddress, String city, String state, float rating) {

        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.semester = semester;
        this.email = email;
        this.phone = phone;
        this.mothersName = mothersName;
        this.fathersName = fathersName;
        this.permanetAddress = permanetAddress;
        this.gender=gender;
        this.rating = rating;
        this.city =city;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", rollNo='" + rollNo + '\'' +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", semester='" + semester + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", mothersName='" + mothersName + '\'' +
                ", fathersName=" + fathersName +
                ", permanetAddress='" + permanetAddress + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", rating=" + rating +
                '}';
    }
}
