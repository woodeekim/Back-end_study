package com.woodee.ect.enumeration;

public class EnumEx02 {
    public static void main(String[] args) {
        for(DirectionEx02 d : DirectionEx02.values()){
            System.out.printf("%s=%d%n", d.name(), d.getValue());
        }

        DirectionEx02 d1 = DirectionEx02.EAST;
        DirectionEx02 d2 = DirectionEx02.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());

        System.out.println(DirectionEx02.EAST.rotate(1));
        System.out.println(DirectionEx02.EAST.rotate(2));
        System.out.println(DirectionEx02.EAST.rotate(-1));
        System.out.println(DirectionEx02.EAST.rotate(-2));
    }
}
