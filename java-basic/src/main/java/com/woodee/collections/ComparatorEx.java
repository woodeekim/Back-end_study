package com.woodee.collections;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        /*
        Arrays.sort()는 배열을 정렬할 때 Comparator를 지정해주지 않으면
        Comparable을 구현한 클랙스의 객체에 구현된 메소드에 따라 정렬된다.
         */
        Arrays.sort(strArr);
        System.out.println("strArr" + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분안함
        System.out.println("strArr" + Arrays.toString(strArr));

        // 기본 정렬외에 다른 기준으로 정렬하고 싶으면 Comparator 를 구현한 클래스를 이용해야 한다.
        Arrays.sort(strArr, new Descending());
        System.out.println("strArr" + Arrays.toString(strArr));
    }
}

class Descending implements Comparator {
    public Descending() {
    }

    @Override
    public int compare(Object o1, Object o2) {
        if( o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable c1 = (Comparable)o1; // compara()의 매개변수가 Object 타입이기 때문에 compareTo()를 바로 호출 할 수 없으므로 Comparable로 형변환을 해야한다.
            Comparable c2 = (Comparable)o2;
            return c2.compareTo(c1);
        }
        return -1;
    }
}

