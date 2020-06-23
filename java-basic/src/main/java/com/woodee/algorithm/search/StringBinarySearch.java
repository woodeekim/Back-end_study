package com.woodee.algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

/*
* 문자열의 배열에서 검색
*/
public class StringBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] x = {
                "abtract", "assert", "boolean", "break", "byte",
                "case", "catch", "char", "class", "const", "continue"
        };

        System.out.println("원하는 키워드를 입력하세요 : ");

        String key = scanner.next();

        int idx = Arrays.binarySearch(x, key);

        if(idx < 0) {
            System.out.println("해당 키워드가 없습니다.");
        } else {
            System.out.println("해당 키워드는 x[" + idx + "]에 있습니다." );
        }
    }
}
