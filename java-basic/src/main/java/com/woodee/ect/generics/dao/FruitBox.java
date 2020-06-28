package com.woodee.ect.generics.dao;

import com.woodee.ect.generics.Eatable;

public class FruitBox<T extends Fruit & Eatable> extends Box<T> {

}
