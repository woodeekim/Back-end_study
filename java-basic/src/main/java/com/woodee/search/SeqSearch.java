package com.woodee.search;

import java.util.Scanner;

/*
* 선형검색
*/
public class SeqSearch {
    //요솟수가 n인 배열 a에서 key 와 같은 요소를 선형 검색
    static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        while(true) {
            if (i==n) {
                return -1; //검색 실패(-1을 반환)
            }
            if (a[i] == key) {
                return i; //검색 성공(인덱스를 반환)
            }
            i++;
        }// end while
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x[" + i + "] :");
            x[i] = scanner.nextInt();
        }

        System.out.println("검색할 값 : ");
        int key = scanner.nextInt();
        int idx = seqSearch(x, num, key);

        if(idx==-1){
            System.out.println("그 값의 요소가 없습니다");
        } else {
            System.out.println(key+"는 X[" + idx + "]에 있습니다.");
        }// if~else end
    }
}
