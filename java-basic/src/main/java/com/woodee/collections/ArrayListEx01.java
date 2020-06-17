package com.woodee.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx01 {
    public static void main(String[] args) {
        ArrayList listOne = new ArrayList(10);
        listOne.add(new Integer(5));
        listOne.add(new Integer(4));
        listOne.add(new Integer(2));
        listOne.add(new Integer(0));
        listOne.add(new Integer(1));
        listOne.add(new Integer(3));

        // List subList(int f, int t) fromIndex부터 toIndex사이에 저장된 객체를 반환
        ArrayList listTwo = new ArrayList(listOne.subList(1, 4));
        print(listOne, listTwo);

        // List를 정렬
        Collections.sort(listOne);
        Collections.sort(listTwo);
        print(listOne, listTwo);

        System.out.println("listOne.containsAll(listwo) : " + listOne.containsAll(listTwo));

        listTwo.add(3, "A");
        print(listOne, listTwo);

        listTwo.set(3,"AA");
        print(listOne, listTwo);

        // list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제
        System.out.println("listOne.retainAll(listTwo) : " + listOne.retainAll(listTwo));
        print(listOne, listTwo);

        // list2에서 list1에 포함된 객체들을 삭제한다.
        // 변수 i를 증가시켜가면서 삭제하면, 한 요소가 삭제될 때마다 빈 공간을 채우기 위해 나머지 요소들이 자리이동을 하기 때문에 올바른 결과를 얻을 수 없다.
        for (int i = listTwo.size()-1; i >= 0; i--) {
            if (listOne.contains(listTwo.get(i))){
                listTwo.remove(i);
            }
        }
        print(listOne, listTwo);
    }

    static void print(ArrayList listOne, ArrayList listTwo) {
        System.out.println("listOne : " + listOne);
        System.out.println("listTwo : " + listTwo);
        System.out.println();
    }
}
