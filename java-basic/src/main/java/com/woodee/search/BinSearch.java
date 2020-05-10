package com.woodee.search;

import java.util.Scanner;

/*
* 이진 검색
*/
public class BinSearch {
    //요솟수가 n인 배열 a에서 key 와 같은 요소를 이진 검색합니다.
    static int binSearch(int[] a, int n, int key) {
        int startIndex = 0;
        int endIndex = n - 1;


        do {
            int midIndex = (startIndex + endIndex) / 2;
            if (a[midIndex] == key) {
                return midIndex; //검색 성공
            } else if (a[midIndex] < key) {
                startIndex = midIndex + 1; //검색 범위를 뒤쪽 절반으로 좁힘
            } else {
                endIndex = midIndex - 1;
            }//if~else if~else end
        }while (startIndex <= endIndex) ;
            return -1; //검색 실패
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력");

        System.out.print("x[0] : "); //첫 요소 입력
        x[0] = scanner.nextInt();

        for(int i = 1; i<num; i++){
            do {
                System.out.print("x["+i+"] :");
                x[i] = scanner.nextInt();
            } while (x[i] < x[i-1]);//do~while end\
        }
        System.out.print("검색할 값");
        int key = scanner.nextInt();

        int idx = binSearch(x, num, key);

        if(idx==-1){
            System.out.println("그 값의 요소가 없습니다");
        }else{
            System.out.println(key + "는 x["+idx+"]에 있습니다.");
        }
    }
}
