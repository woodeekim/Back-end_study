package com.woodee.ect.test.ex03;

public class Test06 {
    public static void main(String[] args) {
        // 일한 시간
        int[] workTime = {7, 5, 5, 5, 5, 10, 7};
        // 총 급여
        int pay = 0;
        int beforePay = 4200;
        int afterPay = 5700;

        for(int i=0; i<workTime.length; i++){
            if(i<=3){
                pay += workTime[i] * beforePay ;
            } else {
                pay += workTime[i] * afterPay ;
            }
        }
        System.out.println("일주일 간의 총 급여 " + pay + "원");
    }


}
