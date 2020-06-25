package com.woodee.collections;

import java.util.*;
//static 으로 추가

public class CollectionsEx01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);

        Collections.addAll(list,1,2,3,4,5);
        System.out.println(list);

        Collections.rotate(list, 2); // 오른쪽으로 두 칸씩 이동
        System.out.println(list);

        Collections.swap(list, 0, 2); // 첫 번째와 세번째를 교환
        System.out.println(list);

        Collections.shuffle(list); // 저장된 요소의 위치를 임의로 변경

        Collections.sort(list); // 정렬
        System.out.println(list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);

        int idx = Collections.binarySearch(list, 3); // 3이 저장된 위치(index)를 반환
        System.out.println("index"+idx);

        System.out.println("max"+Collections.max(list));
        System.out.println("min"+Collections.min(list));
        System.out.println(Collections.max(list,Comparator.reverseOrder()));

        Collections.fill(list, 9); // list를 9로 채운다.
        System.out.println(list);

        // list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단 결과는 변경불가
        List newList = Collections.nCopies(list.size(),2);
        System.out.println(newList);

        // 공통 요소가 없으면 true
        System.out.println(Collections.disjoint(list, newList));

        Collections.copy(list, newList); // list 를 newList 로
        System.out.println("newList"+newList);
        System.out.println("list" + list);

        Collections.replaceAll(list, 2, 1); // list의 값인 2를 1로
        System.out.println("replace" + list);

        Enumeration enumeration = Collections.enumeration(list);
        ArrayList list2 = Collections.list(enumeration);

        System.out.println("list2" + list2);

    }
}
