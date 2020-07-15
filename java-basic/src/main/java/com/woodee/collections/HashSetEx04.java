package com.woodee.collections;

import java.util.HashSet;

public class HashSetEx04 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

         /*
        -HashSet의 add 메서드는 새로운 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별하기 위해
         추가하려고는 요소의 equals()와 hashCode()를 호출하기 때문에 목적에 맞게 오버라이딩해야 한다.
        */

        set.add("abc");
        set.add("abc");
        set.add(new Person("David",10));
        set.add(new Person("David",10));
        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
