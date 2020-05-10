package com.woodee.array;

import java.util.Scanner;

/*
* 두 배열이 같은가를 판단
* */
public class ArrayEqual {
    static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }// end if

        for(int i=0; i<a.length; i++) {
            if(a[i] != b[i]){
                return false;
            }
        }//end for

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열 a의 요솟수 : ");

        int firstNumber = scanner.nextInt();

        int[] a = new int[firstNumber];

        for(int i=0; i<firstNumber; i++){
            System.out.print("a["+i+"] : ");
            a[i] = scanner.nextInt();
        }

        System.out.print("배열 b의 요솟수");
        int secondNumber = scanner.nextInt();

        int[] b = new int[secondNumber];

        for(int i=0; i<secondNumber; i++) {
            System.out.print("b["+i+"] : ");
            b[i] = scanner.nextInt();
        }

        System.out.println("배열 a와 b는" + (equals(a,b) ? "같습니다" : "같지 않습니다"));
    }

}
