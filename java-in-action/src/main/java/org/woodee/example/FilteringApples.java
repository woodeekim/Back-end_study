package org.woodee.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2-1 동작 파라미터화: 프레디케이트로 사과 필터링
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,Color.GREEN),
                                              new Apple(155,Color.GREEN),
                                              new Apple(120, Color.RED),
                                              new Apple(50, Color.RED));
        // filterApplesㅇ메서드의 두번째 인자에 사과의 어떤 동작을 할 지 넣어준다
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenPredicate());
        List<Apple> lightRedApples = filterApples(inventory, new ApplesLightAndRedPredicate());

        System.out.println("[150 이상인 사과만 필터링]");
        for (Apple apple : heavyApples) {
            System.out.println(apple);
        }

        System.out.println("[녹색 사과만 필터링]");
        for (Apple apple : greenApples) {
            System.out.println(apple);
        }

        System.out.println("[50이하의 빨간 사과만 필터링]");
        for (Apple apple : lightRedApples) {
            System.out.println(apple);
        }
    }
    // 사과 필터 메서드
    /*
        - filterApple메서드의 두번째 파라미터인 ApplePredicate 인터페이스로 받기 때문에
          앞으로 어떤 요구사항이 들어와도 요구사항에 해당하는 새로운 클래스만 만들면 유연하게 대처할 수 있다.
    */
    static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (p.test(apple)){
               result.add(apple);
            }
        }
        return result;
    }
}

enum Color { RED, GREEN}
class Apple {
    private int weight;
    private Color color;

    Apple(int weight, Color color){
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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
        return apple.getWeight() > 150;
    }
}
// 녹색 사과 선택
class AppleGreenPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
// 작은 사과(50 이하)와 레드 사과 선택
class ApplesLightAndRedPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() <= 50 && Color.RED.equals(apple.getColor());
    }
}
