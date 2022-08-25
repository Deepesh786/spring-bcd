package com.learn.serialization;

import java.io.Serializable;

public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String mobile;

    public Employee(int id, String name,String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }


  /*  @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }*/
}
