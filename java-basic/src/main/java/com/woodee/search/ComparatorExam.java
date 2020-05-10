package com.woodee.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
* 이진 검색
*/
public class ComparatorExam {
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        //문자열을 바환하는 메서드
        public String toString(){
            return name + " " + height + " " +vision;
        }

        //오름차순으로 정렬하기 위한 comparator
        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("김근경", 175, 1.0),
                new PhyscData("우디김", 170, 0.2),
                new PhyscData("김블로", 180, 0.7)
        };

        System.out.print("몇 cm 인 사람을 찾고 있나요 ? : ");
        int height = scanner.nextInt();
        int idx = Arrays.binarySearch(
                x,
                new PhyscData("", height, 0.0),
                PhyscData.HEIGHT_ORDER
        );

        if(idx < 0) {
            System.out.println("요소가 없습니다");
        } else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }


}
