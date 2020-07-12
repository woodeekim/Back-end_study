package com.woodee.ect.test.ex03;

public class Test05 {
    public static void main(String[] args) {
        boolean[] checkList = {true, false, false, true, false};

        System.out.println("====before====");
        printArray(checkList);

        for(int i=0; i<checkList.length; i++){
            if(checkList[i]){
                checkList[i] = false;
            } else {
                checkList[i] = true;
            }
        }

        System.out.println("====after====");
        printArray(checkList);
    }

    static void printArray(boolean[] data) {
        for(int i = 0; i<data.length; i++){
            System.out.print(data[i]);

            if(i+1 < data.length){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
