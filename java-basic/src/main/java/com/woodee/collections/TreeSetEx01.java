package com.woodee.collections;

import java.util.TreeSet;

public class TreeSetEx01 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc"); set.add("alien");   set.add("bat");
        set.add("car"); set.add("Car");   set.add("disc");
        set.add("dance"); set.add("dZZZZ");   set.add("dzzzz");
        set.add("flower"); set.add("elevator");   set.add("fan");

        System.out.println(set);
        /*
        subSet()을 이용해서 범위검색할 때 시작범위는 포함되지만 끝 범위는 포함되지 않으므로 result에는 c로 시작하는 단어까지만
        검색결과에 포함되어 있다.
         */
        System.out.println("range search : from " + from + " to " + to);
        System.out.println("result1 : " + set.subSet(from, to));
        System.out.println("result2 : " + set.subSet(from, to + "zzz"));
    }

}
