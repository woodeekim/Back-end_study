package com.woodee.algorithm;

import java.util.Scanner;

//재귀 함수 이해하기
public class Recur {
    static void recur(int n) {
        if ( n > 0) {
            recur( n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수 입력");
        int x = scanner.nextInt();

        recur(x);
    }
}
