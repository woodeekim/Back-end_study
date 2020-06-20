package com.woodee.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx01 {
    public static void main(String[] args) {
        /*
        List 클래스들은 저장순서를 유지하기 때문에 Iterator를 이용해서 읽어 온 결과 역시 저장 순서와 동일하지만
        Set클래스들은 각 요소간의 순서가 유지 되지 않기 때문에 Iterator를 이용해서 저장된 요소들을 읽어 와도 처음에 저장된 순서와 같지 않다.
         */
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        System.out.println("list = " + list);
        System.out.println("list[0] = " + list.get(0));

        Iterator iterator = list.iterator();

        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println("obj = " + obj);
        }
    }
}
