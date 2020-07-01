package com.woodee.ect.enumeration;

public class EnumEx01 {
    public static void main(String[] args) {
        DirectionEx01 d1 = DirectionEx01.EAST;
        DirectionEx01 d2 = DirectionEx01.valueOf("WEST");
        DirectionEx01 d3 = Enum.valueOf(DirectionEx01.class, "EAST");

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1==d2 ? " + (d1==d2));
        System.out.println("d1==d2 ? " + (d1==d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3)); // 비교대상이 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수 반환

        switch (d1) {
            case EAST: // DirectionEx01.EAST라고 사용할 수 없음
                System.out.println("EAST"); break;
            case SOUTH:
                System.out.println("SOUTH"); break;
            case NORTH:
                System.out.println("NORTH"); break;
            default:
                System.out.println("Invalid DirectionEx01"); break;
        }

        DirectionEx01[] dArr = DirectionEx01.values();

        for(DirectionEx01 d : dArr){
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        }
    }
}
