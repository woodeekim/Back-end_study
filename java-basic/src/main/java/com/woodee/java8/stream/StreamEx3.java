package com.woodee.java8.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("김우디",3,300),
                new Student("가나다",1,200),
                new Student("하하하",2,100),
                new Student("김자바",2,100),
                new Student("소자바",3,190)
        };

        Stream<Student> studentStream = Stream.of(stuArr);

        studentStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        studentStream = Stream.of(stuArr); // 한번 닫힌 스트림은 사용할 수 없기 때문에 스트림을 다시 생성한다.
        IntStream stuScoreStream = studentStream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count=" + stat.getCount());
        System.out.println("sum=" + stat.getCount());
        System.out.printf("average=%.2f%n", stat.getAverage());
        System.out.println("min" + stat.getMin());
        System.out.println("max" + stat.getMax());
    }
}

