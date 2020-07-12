package com.woodee.ect.test.ex04;

public class Square {
    private int width;
    private int height;

    public Square(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width*height;
    }

    public int getRound() {
        return width*2 + height*2;
    }

    public static void main(String[] args) {
        Square square = new Square(3,2);

        System.out.println("사격형의 넓이-> " + square.getArea() + "제곱cm");
        System.out.println("사격형의 둘레-> " + square.getRound() + "cm");
    }
}
