package com.woodee.java8.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class StreamEx7 {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("김자바", true,1,1,300),
                new Student2("박자바", true,1,1,250),
                new Student2("이자바", false,1,1,200),
                new Student2("마자바", false,1,2,150),
                new Student2("하자바", false,1,2,100),
                new Student2("로자바", true,1,2,50),
                new Student2("조자바", true,1,3,100),
                new Student2("키자바", false,1,3,150),
                new Student2("크자바", false,1,3,300),

                new Student2("라자바", true,2,1,300),
                new Student2("타자바", true,2,1,250),
                new Student2("피자바", false,2,1,200),
                new Student2("조자바", true,2,2,150),
                new Student2("주자바", true,2,2,100),
                new Student2("문자바", false,2,2,50),
                new Student2("몬자바", true,2,3,100),
                new Student2("바자바", false,2,3,150),
                new Student2("버자바", true,2,3,200),
        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
                                                        .collect(partitioningBy(Student2::isMale));
        System.out.println(stuBySex); // {false=[~~], true=[~~]} 이렇게 담긴다. Map 은 key,value 이기 때문에 제네릭 안을 잘 살피자.
        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(true);

        System.out.println(maleStudent);

        for ( Student2 male : maleStudent) {
            System.out.println(male);
        }

        for ( Student2 female : femaleStudent) {
            System.out.println(female);
        }

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수) %n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale, counting()));
        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여학생 수 : " + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale, maxBy(Comparator.comparingInt(Student2::getScore))));
        System.out.println("남학생 1등 : " + topScoreBySex.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale, collectingAndThen(
                        maxBy(Comparator.comparingInt(Student2::getScore)),Optional::get)
                ));

        System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex2.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점이하)%n");
        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex =
                Stream.of(stuArr).collect(partitioningBy(Student2::isMale,partitioningBy(s -> s.getScore() <= 100))
                );
        System.out.println(failedStuBySex);

        List<Student2> faildMaleStu = failedStuBySex.get(true).get(true);
        List<Student2> faildFemaleStu = failedStuBySex.get(false).get(true);

        for (Student2 male : faildMaleStu) {
            System.out.println(male);
        }

        for (Student2 female : faildFemaleStu) {
            System.out.println(female);
        }
    }

}

class Student2 {
    String name;
    Boolean isMale; // 성별
    int hak; // 학년
    int ban; // 반
    int score;

    public Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getHak() {
        return hak;
    }

    public void setHak(int hak) {
        this.hak = hak;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return String.format("[%s, %s, %d학년, %d반, %3d점]", name,isMale ? "남" : "여", hak, ban, score);
    }

    enum Level {
        HIGH, MID, LOW // 성적을 상, 중, 하 세 단계로 분류
    }
}
