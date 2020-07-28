package org.woodee.example;

import java.util.Arrays;
import java.util.List;

// 2-1 동작 파라미터화: 프레디케이트로 사과 필터링
public class Ex2_1 {

}

class Apple {
    enum Color { RED, GREEN}
    public Apple(int weight, String color) {
    }


    int weight;
    String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

interface ApplePredicate {
    boolean test (Apple apple);
}

// 무거운 사과 선택
class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}

class FilteringApples {
    }
}
