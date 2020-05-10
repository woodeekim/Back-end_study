package com.woodee.search;

import java.util.Arrays;
import java.util.Scanner;

/*
* 기본 자료형 배열에서 binarySearch 메서드로 검색하기
*/
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요");

        System.out.print("x[0] :");
        x[0] = scanner.nextInt();

        for(int i = 1; i<num; i++){
            do {
                System.out.print("x[" + i + "] :" );
                x[i] = scanner.nextInt();
            }while (x[i] < x[i-1]); //바로 앞의 요소보다 작으면 다시 입력
        }//for end

        System.out.print("검색할 값 : ");
        int key = scanner.nextInt();

        int idx = Arrays.binarySearch(x, key); //배열 x에서 키값이 key인 요소를 검색

        if(idx<0){
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(key+"는 x[" + idx + "]에 있습니다.");
        }
    }
}
