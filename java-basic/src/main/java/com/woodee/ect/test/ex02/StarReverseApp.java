package com.woodee.ect.test.ex02;

public class StarReverseApp {
    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            for(int j=10; j>i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
