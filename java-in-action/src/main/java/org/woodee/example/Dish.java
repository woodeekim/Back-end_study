package org.woodee.example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dish {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french", false, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season", false, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH)
        );

        // 4.4.1 중간 연산 예제
        List<String> names = menu.stream()
                                    .filter(dish -> {
                                        System.out.println("filtering: " + dish.getName());
                                        return dish.getCalories() > 300;
                                    })
                                    .map(dish -> {
                                        System.out.println("mapping: " + dish.getName());
                                        return dish.getName();
                                    })
                                    .limit(3)
                                    .collect(Collectors.toList());
        System.out.println(names);

    }
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type { MEAT, FISH, OTHER}
}
