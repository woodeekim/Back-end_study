package com.woodee.collections;

import java.util.*;

public class HashMapEx02 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("김자바", 90);
        map.put("김자바", 100);
        map.put("이자바", 100);
        map.put("강자바", 80);
        map.put("안자바", 90);

        /*
            entrySet()
            - HashMap에 저장된 키와 값을 엔트리(키와 값의 결합)의 형태로 Set에 저장해서 반환
            - map 에서는 바로 iterator()를 못쓴다.
         */
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println("이름 : " + entry.getKey() + ", 점수 : " + entry.getValue());
        }

        /*
            keySet()
            - HashMap에 저장된 모든 키가 저장된 Set을 반환
         */
        set = map.keySet();
        System.out.println("참가자 명단 : " + set);

        /*
            Collection 인터페이스
            - List와 Set의 조상이다.
            - 컬렉션을 다루는데 필요한 메서드들이 있다.(읽기, 쓰기, 삭제 등)
         */
        Collection values = map.values(); //values() 메서드의 리턴값이 Collection
        System.out.println("values = " + values);
        // values = [90, 100, 80, 100] 이기 때문에 컬렉션 배열의 요소들을 각각 하나로 빼기 위해서는 iterator() 메서드를 이용
        iterator = values.iterator(); // iterator() 메서드의 리턴값은 Iterator

        int total = 0;

        while (iterator.hasNext()){
            Integer i = (Integer)iterator.next();
            total += i.intValue();
        }

        System.out.println("총점 : " + total);
        System.out.println("평균 : " + (float)total/set.size());
        // Collections는 클래스다
        System.out.println("최고 점수: " + Collections.max(values));
        System.out.println("최저 점수: " + Collections.min(values));
    }

}
