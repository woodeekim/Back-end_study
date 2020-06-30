package com.woodee.ect.enums;

enum Direction { EAST, SOUTH, WEST, NORTH}

public class EnumEx01 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1==d2 ? " + (d1==d2));
        System.out.println("d1==d2 ? " + (d1==d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3)); // 비교대상이 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수 반환

        switch (d1) {
            case EAST: // Direction.EAST라고 사용할 수 없음
                System.out.println("EAST"); break;
            case SOUTH:
                System.out.println("SOUTH"); break;
            case NORTH:
                System.out.println("NORTH"); break;
            default:
                System.out.println("Invalid Direction"); break;
        }

        Direction[] dArr = Direction.values();

        for(Direction d : dArr){
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        }
    }
}
