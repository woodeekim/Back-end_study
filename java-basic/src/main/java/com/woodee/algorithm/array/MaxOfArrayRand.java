package com.woodee.algorithm.array;

import java.util.Random;
import java.util.Scanner;

/*
* 난수 사용해 배열의 요솟값 설정하기
* */
public class MaxOfArrayRand {
    //배열을 받아 최댓값을 리턴
    static int maxOf(int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }//end if
        }// end for
        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다");
        System.out.println("사람 수 : ");
        int num = scanner.nextInt();

        int[] height = new int[num];

        System.out.println("키 값은 아래와 같습니다");
        for(int i = 0; i<height.length; i++) {
            height[i] = 170 + random.nextInt(20);
            System.out.println("height["+i+"] : " + height[i]);
        }//end for

        System.out.println("최댓값은 " + maxOf(height) + "입니다");
    }
}
