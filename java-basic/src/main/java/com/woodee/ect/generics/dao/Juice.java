package com.woodee.ect.generics.dao;

public class Juice {
    String name;

    public Juice(String name) {
        this.name = name + "Juice";
    }

    public String toString(){
        return name;
    }
}
