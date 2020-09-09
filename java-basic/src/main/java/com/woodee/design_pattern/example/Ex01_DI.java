package com.woodee.design_pattern.example;

import java.util.Date;

/*
 * 다음 예제로 알 수 있는 것
 * - Member 클래스의 생성자가 private일 경우 강한 결합은 에러가 발생하는 곳이 생긴다.
 * - 약한 결합은 에러가 발생하지 않는다.
 *      - 이미 만들어져 있는 걸 주입 받기 때문에 만들어 질 지 안 만들어 질 지 걱정안해도 된다.
 * - 이처럼 약한 결합을 사용하는 프로그래밍은 다른 클래스의 변화에 보다 더 안전하고 유연하게 대처할 수 있다.
 * */
public class Ex01_DI {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("강한 결합인 Date : "+date);
    }

    public static void getDate(Date d) {
        Date date = d;
        System.out.println("약한 결합인 Date : " + date);
    }

    public static void memberUse1() {
        // 강한 결합 : 직접 생성
        Member m1 = new Member();
    }

    public static void memberUse2(Member m) {
        // 약한 결합 : 생성된 것을 주입 받음 - 의존 주입
        Member m2 = m;
    }
}

// Member를 사용한다는 의미는 Member의 기능에 의존한다 라는 의미다
class Member {
    String name;
    String nickname;
    //private  Member (){}
    public  Member (){}
}

