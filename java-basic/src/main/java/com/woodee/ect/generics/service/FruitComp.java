package com.woodee.ect.generics.service;

import com.woodee.ect.generics.dao.Fruit;

import java.util.Comparator;

public class FruitComp implements Comparator<Fruit> {
    @Override
    public int compare(Fruit f1, Fruit f2) {
        return f1.weight - f2.weight;
    }
}
