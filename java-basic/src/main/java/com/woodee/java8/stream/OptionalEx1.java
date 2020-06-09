package com.woodee.java8.stream;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalEx1 {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr=" + optStr.get());
        System.out.println("optInt=" + optInt.get());
        // optStr=abcde
        // optInt=5

        int result1 = Optional.of("123")
                        .filter(x -> x.length() > 0)
                        .map(Integer::parseInt).get();
        int result2 = Optional.of("")
                        .filter(x -> x.length() > 0)
                        .map(Integer::parseInt).orElse(-1);
        System.out.println("result1=" + result1);
        System.out.println("result2=" + result2);
        // result1=123
        // result2=-1

        Optional.of("456").map(Integer::parseInt)
                            .ifPresent(x -> System.out.printf("result3=%d%n",x));
        OptionalInt optInt1 = OptionalInt.of(0); // 0을 저장
        OptionalInt optInt2 = OptionalInt.empty(); // 빈 객체를 생성
        System.out.println(optInt1.isPresent()); // true
        System.out.println(optInt2.isPresent()); // false
        System.out.println(optInt1.getAsInt()); // 0
        //System.out.println(optInt2.getAsInt()); // NoSuchElementException
        System.out.println(optInt1.equals(optInt2)); // false

        Optional<String> opt = Optional.ofNullable(null); //null을 저장
        Optional<String> opt2 = Optional.empty(); // 빈 객체를 생성
        System.out.println(opt.equals(opt2)); // true

        int result3 = optStrToInt(Optional.of("123"), 0);
        int result4 = optStrToInt(Optional.of(""), 0);
        System.out.println(result3); // 123
        System.out.println(result4); // 0
    }

    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).get();
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
