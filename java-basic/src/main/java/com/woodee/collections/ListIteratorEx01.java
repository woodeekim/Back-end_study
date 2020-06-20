package com.woodee.collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorEx01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        ListIterator iterator = list.listIterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next()); // 순방향으로 진행하면서 읽어온다.
        }
        System.out.println();

        while(iterator.hasPrevious()) {
            System.out.print(iterator.previous()); // 역방향으로 진행하면서 읽어온다.
        }
        System.out.println();

    }
}
