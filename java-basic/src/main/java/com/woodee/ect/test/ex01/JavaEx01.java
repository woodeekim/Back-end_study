package com.woodee.ect.test.ex01;

import java.util.Calendar;
import java.util.Scanner;

public class JavaEx01 {
    Calendar calendar = Calendar.getInstance();
    int nowYear = calendar.get(calendar.YEAR);

    public int showAge(int year){
        return (nowYear-year)+1;
    }

    public int showYear(int age){
        return (nowYear-age);
    }

    public static void main(String[] args) {
        JavaEx01 test = new JavaEx01();
        Scanner scanner = new Scanner(System.in);

        System.out.println("태어난 년도를 입력하세요.");
        int year = scanner.nextInt();
        System.out.println(test.showAge(year)+"세 입니다.");

        System.out.println("나이를 입력하세요");
        int age = scanner.nextInt();
        System.out.println(test.showAge(age) + "년생 입니다.");
    }
}
