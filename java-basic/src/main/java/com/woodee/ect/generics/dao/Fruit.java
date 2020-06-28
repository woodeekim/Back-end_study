package com.woodee.ect.generics.dao;

import com.woodee.ect.generics.Eatable;

public class Fruit implements Eatable {
    public String name;
    public int weight;

    public Fruit(){
    }

    public Fruit(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    public String toString() {
        return name + "(" + weight + ")";
    }
}
