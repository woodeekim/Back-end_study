package com.woodee.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {
    public static void main(String[] args) {
        Student[] students = {
          new Student("가나다", 3, 300),      
          new Student("김자바", 2, 200),      
          new Student("김우디", 2, 100),      
          new Student("우디킴", 1, 150),      
          new Student("무디김", 3, 200),      
          new Student("김무디", 3, 290),      
        };

        // 학생 이름만 뽑아서 List<String>에 저장
        List<String> names = Stream.of(students).map(Student::getName)
                                                .collect(Collectors.toList());
        System.out.println(names);

        // 스트림을 배열로 변환
        Student[] studentArray = Stream.of(students).toArray(Student[]::new);
        for (Student s : studentArray) {
            System.out.println(s);
        }

        // 스트림을 Map<String, Student> 로 변환, 학생 이름이 Key
        Map<String, Student> studentMap = Stream.of(students).collect(Collectors.toMap(s -> s.getName(), p->p));
        for (String name : studentMap.keySet()) {
            System.out.println(name + "=" + studentMap.get(name));
        }

        Long count = Stream.of(students).count();
        Integer totalScore = Stream.of(students).collect(Collectors.summingInt(Student::getTotalScore)); // mapToInt(Student::getTotalScore).sum()
        System.out.println("count : " + count);
        System.out.println("totalScore : " + totalScore);
        totalScore = Stream.of(students).collect(Collectors.reducing(0,Student::getTotalScore,Integer::sum)); // map(Student::getTotalScore).reduce(0, Integer::sum)
        System.out.println("totalScore : " + totalScore);

        // Comparator 는 기본 정렬과는 다르게 정렬하고 싶을 때 이용하는 클래스
        Optional<Student> topStudent = Stream.of(students).collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore))); // max(Comparator.comparingInt(Student::getTotalScore))
        System.out.println("topStudent=" + topStudent.get());

        IntSummaryStatistics stat = Stream.of(students).collect(Collectors.summarizingInt(Student::getTotalScore));
        System.out.println("stat" + stat);
        // -> statIntSummaryStatistics{count=6, sum=1240, min=100, average=206.666667, max=300}

        String studentName = Stream.of(students).map(Student::getName).collect(Collectors.joining(",", "{", "}"));
        System.out.println("studentName = " + studentName);

    }
}
