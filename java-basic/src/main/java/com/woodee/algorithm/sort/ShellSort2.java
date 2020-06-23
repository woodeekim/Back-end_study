package com.woodee.algorithm.sort;

import java.util.Scanner;

public class ShellSort2 {

    // 쉘 정렬(버전 2)

    static void shellSort(int[] a, int n) {
        int h;
        for ( h = 1; h < n / 9; h = h * 3 + 1);

        for ( ; h > 0; h /= 3) {
            for ( int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j+h] = a[j];
                }
                a[j+h] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("쉘 버전2");
        System.out.print("요솟수");
        int nx = scanner.nextInt();
        int[] x= new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i +  "]:");
            x[i] = scanner.nextInt();
        }

        shellSort(x, nx);
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]" + x[i]);
        }
    }
}
