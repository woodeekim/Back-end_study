package com.woodee.ect.test.ex03;

public class Test01 {
    public static void main(String[] args) {
        for(int i=1; i<=101; i++){
            if(i%3 == 0 && i%5 == 0){
                System.out.println(i);
            }
        }
    }
}
