package com.woodee.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx04 {
    public static void main(String[] args)
    {
        String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "Z", "D"};

        HashMap map = new HashMap();

        for(int i=0; i<data.length; i++){
            if(map.containsKey(data[i])){
                //아! 처음에는 map에 아무 데이터가 없기 때문에 false를 반환할 거고 else 문을 타서 map에 값을 넣는구나
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i], value.intValue()+1);
            } else {
                map.put(data[i], 1);
            }//if~else
        }//for

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey()+ ":" + printBar('#', value) + " " + value);
        }
    }//main

    public static String printBar(char ch, int value) {
        char[] bar = new char[value];

        for(int i=0; i<bar.length; i++){
            bar[i] = ch;
        }
        return new String(bar); //String(char[] chArr)
    }
}

/*
    HashMap과 같이 해싱을 구현한 컬렉션 클래스들은 저장순서를 유지하지 않는다는 사실을 알 수 있다.
 */
