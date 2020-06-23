package com.woodee.algorithm.array;

import java.util.Scanner;

/*
* 배열 역순
*/
public class ArrayReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : " );
        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i<array.length; i++) {
            System.out.print("array["+i+"] : ");
            array[i] = scanner.nextInt();
        }

        System.out.println("역순");

        reverse(array);

        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    private static void reverse(int[] array) {
        for (int i = 0; i<array.length/2; i++) {
            swap(array, i, array.length-i-1);

        }
    }

    private static void swap(int[] array, int i, int i2) {
        int temp = array[i];
        array[i] = array[i2];
        array[i2] = temp;
    }
}
