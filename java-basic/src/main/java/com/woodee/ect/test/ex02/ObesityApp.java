package com.woodee.ect.test.ex02;

public class ObesityApp {
    private double myHeight = 175;
    private double myWeight = 80;
    private double standardWeight = 0;
    private double obesity = 0;

    public double getMyHeight() {
        return myHeight;
    }

    public void setMyHeight(double myHeight) {
        this.myHeight = myHeight;
    }

    public double getMyWeight() {
        return myWeight;
    }

    public void setMyWeight(double myWeight) {
        this.myWeight = myWeight;
    }

    // 표준체중
    public double findStandardWeight(double height){
        if(height<=150){
            standardWeight = height-110;
        } else {
            standardWeight = (height-110)*0.9;
        }
        return standardWeight;
    }

    // 비만도
    public double findObesity(double weight, double standardWeight){
        obesity = (weight-standardWeight)/standardWeight * 100;
        return obesity;
    }

    public String checkObesity(double obesity){
        if(obesity <= 20){
            return "정상입니다. (안심)";
        } else if(obesity > 20 && obesity <= 30) {
            return "정도비만입니다. (주의)";
        } else if(obesity > 30 && obesity <= 50) {
            return "중등도비만입니다. (위험)";
        } else {
            return "고도미반입니다. (매우위험)";
        }
    }

    public static void main(String[] args) {
        ObesityApp obesityApp = new ObesityApp();

        double height = obesityApp.getMyHeight();
        double weight = obesityApp.getMyWeight();

        double standardWeight = obesityApp.findStandardWeight(height);
        double obesity = obesityApp.findObesity(weight, standardWeight);

        System.out.println(obesityApp.checkObesity(obesity));
    }
}
