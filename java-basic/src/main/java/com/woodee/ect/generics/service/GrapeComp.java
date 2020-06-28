package com.woodee.ect.generics.service;

import com.woodee.ect.generics.dao.Grape;

import java.util.Comparator;

public class GrapeComp implements Comparator<Grape> {
    @Override
    public int compare(Grape g1, Grape g2) {
        return g2.weight - g1.weight;
    }
}
