package com.woodee.ect.generics.dao;

public class Juicer {
    public static Juice makeJuice(FruitBox<? extends Fruit> box){
        String tmp = "";

        for(Fruit fruit : box.getList()) {
            tmp += fruit + " ";
        }
        return new Juice(tmp);
    }
}
