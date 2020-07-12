package com.woodee.ect.test.ex03;

public class Test02 {
    public static void main(String[] args) {
        // 배열의 복사에는 얕은 복사와 깊은 복사가 있음
        int[] arr = {1, 9, 4, 2, 5};
        int[] copy = new int[arr.length]; // new int[5];
        for(int i=0; i<copy.length; i++){
            copy[i] = arr[i];
            System.out.println("copy["+i+"]="+copy[i]);
        }

    }
}
