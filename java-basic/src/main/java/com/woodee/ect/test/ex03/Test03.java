package com.woodee.ect.test.ex03;

public class Test03 {
    public static void main(String[] args) {
        int[] arr = {1, 9, 4, 2, 5,3};
        arr = printArray(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println("arr["+i+"]="+arr[i]);
        }
    }
    static int[] printArray(int[] arr){
        //arr.length/2 = 3
        int[] temp = new int[arr.length];
        int[] reverseArray = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            temp[i] = arr[arr.length-1-i];
            reverseArray[i] = temp[i];
        }

        return reverseArray;
    }

}
