package com.woodee.collections;

import java.util.*;

//  HashSet Lotto
public class HashSetEx02 {
    public static void main(String[] args) {
        Set set = new HashSet();
        for(int i=0; set.size()<6; i++){
            System.out.println(set.size());
            int num = (int)(Math.random()*45)+1;
            set.add(new Integer(num));
        }

        List list = new LinkedList(set);
        System.out.println("list = " + list);
        // 컬렉션 관련 메서드를 사용하려면 Collections 클래스를 이용해야 한다.
        Collections.sort(list);
        System.out.println("list = " + list);
    }
}
