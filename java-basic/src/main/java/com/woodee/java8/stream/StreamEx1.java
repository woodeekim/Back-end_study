package com.woodee.java8.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student>  studentStream = Stream.of(
                new Student("가나다",3, 300),
                new Student("아아아",3, 100),
                new Student("자자자",1, 200),
                new Student("하하하",2, 300),
                new Student("마마마",1, 400),
                new Student("브브브",3, 190),
                new Student("키키키",3, 100)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan) // 반별정렬
                                .thenComparing(Comparator.naturalOrder())) //기본정렬
                                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]",name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student student) {
        return student.totalScore - this.totalScore;
    }

}
