package com.woodee.array;

import java.util.Scanner;

/*
* 배열요소의 최댓값을 구하는 메소드 구현
*/
public class ArrayMax {
    public static int maxOf(int[] numberArray){
        int max = numberArray[0];
        for(int i = 1; i < numberArray.length; i++ ){
            if(numberArray[i] > max){
                max = numberArray[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("키를 입력해 제일 큰 사람을 찾습니다.");
        System.out.println("사람 수 입력");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] height = new int[number];
        for(int i=0; i<height.length; i++){
            System.out.print("키 입력");
            height[0] = scanner.nextInt();
        }
        System.out.println("제일 큰 키는" + maxOf(height) + " 입니다.");
    }
}
