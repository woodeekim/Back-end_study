package com.woodee.ect.generics;


import com.woodee.ect.generics.dao.Apple;
import com.woodee.ect.generics.dao.Box;
import com.woodee.ect.generics.dao.Toy;

public class FruitBoxEx01 {
    public static void main(String[] args) {
        Box<com.woodee.ect.generics.dao.Fruit> fruitBox = new Box<com.woodee.ect.generics.dao.Fruit>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Toy> toyBox = new Box<Toy>();

        fruitBox.add(new com.woodee.ect.generics.dao.Fruit());
        fruitBox.add(new Apple());
        System.out.println(fruitBox);

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println(appleBox);

        toyBox.add(new Toy());
        System.out.println(toyBox);
    }
}

