package com.woodee.algorithm.array;

import jdk.internal.misc.VM;

import java.util.Scanner;

// 클래스의 배열
public class PhysicalExamination {
    static final int VMAX = 21; // 시력 분포(0.0에서 0.1단위로 21개)

    static class PhyscData {
        String name; // 이름
        int height; // 키
        double vision; // 시력

        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    // 키의 평균값을 구함
    static double aveHeight(PhyscData[] dat){
        double sum = 0;

        for(int i=0; i<dat.length; i++) {
            sum += dat[i].height;
        }

        return sum / dat.length;
    }

    // 시력 분포를 구함
    static void distVision(PhyscData[] dat, int[] dist){
        int i = 0;

        dist[i] = 0;
        for(i=0; i<dat.length; i++){
            if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
                dist[(int)(dat[i].vision * 10)]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PhyscData[] x = {
          new PhyscData("김근경",175,1.0),
          new PhyscData("김지환",180,0.8),
          new PhyscData("손영준",190,0.3),
          new PhyscData("정동연",160,0.5),
          new PhyscData("황창하",175,0.9),
          new PhyscData("조성무",159,1.2),
          new PhyscData("이영우",179,2.0)
        };
        int[] vdist = new int[VMAX];

        System.out.println("신체검사");
        System.out.println("이름 키 시력");
        System.out.println("==========");
        for(int i=0; i<x.length; i++){
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }

        System.out.printf("\n평균 키: %5.1fcm\n", aveHeight(x));

        distVision(x, vdist);

        System.out.printf("\n시력 분포");
        for(int i=0; i< VMAX; i++) {
            System.out.printf("%3.1f~:%2d명\n", i / 10.0, vdist[i]);
        }


    }
}
