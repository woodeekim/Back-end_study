package com.woodee.ect.test.ex03;

public class Test04 {
    static int compareArray(int[] arr1, int[] arr2){
        int result=0;
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    result++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 9, 4, 2, 3};
        int[] arr2 = {5, 8, 6, 3, 1};

        System.out.println("일치하는 데이터는 총 " + compareArray(arr1, arr2) + "개 입니다.");
    }
}
