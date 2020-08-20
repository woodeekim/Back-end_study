package org.woodee.part02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainExample {
    public static void main(String[] args) {
        /*
            1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리
            2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
            3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
            4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
            5. 밀라노에 거래자가 있는가?
            6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
            7. 전체 트랜잭션 중 최댓값은 얼마인가?
            8. 전체 트랜잭션 중 최솟값은 얼마인가?
        */
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions= Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> list1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("1.");
        list1.forEach(System.out::println);

        List<String> list2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("2.");
        System.out.println(list2);

        List<String> list3 = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(t -> t.getTrader().getName()).collect(Collectors.toList());
        System.out.println("3.");
        System.out.println(list3);
        //수정
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader) // 트랜잭션의 모든 거래자 추출
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        List<String> list4 = transactions.stream().map(p -> p.getTrader().getName()).sorted().collect(Collectors.toList());
        System.out.println("4.");
        System.out.println(list4);

        //수정
        String reduce = transactions.stream()
                .map(p -> p.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(reduce);


        boolean anyMatch = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("5.");
        System.out.println(anyMatch);

        Integer sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .reduce(0, (a, b) -> a + b);
        System.out.println("6.");
        System.out.println(sum);

        //수정
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Optional<Integer> hightestValue = transactions.stream()
                .map(Transaction::getValue) // 각 트랜잭션의 값 추출
                .reduce(Integer::max);
        System.out.println("7.");
        System.out.println(hightestValue);

        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(smallestTransaction);

        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("8.");
        System.out.println(min);

    }
}
