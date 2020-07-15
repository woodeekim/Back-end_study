package com.woodee.collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx01 {
    public static void main(String[] args) {
        Object[] objects = {"1", 1, "2","2","3","3","4","4","4"};
        Set set = new HashSet();

        for (int i=0; i<objects.length; i++) {
            set.add(objects[i]); // HashSet에 Obejct배열의 요소를 저장
        }
        System.out.println(set);
    }
}
