package com.woodee.algorithm;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수 입력");
        int x = scanner.nextInt();

        System.out.println("x" + "팩토리얼은 " + factorial(x));
    }
}
