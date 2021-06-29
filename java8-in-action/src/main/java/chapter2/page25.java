package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class page25 {
    // page 25
    // 行为参数化
}

class Apple {
    public Apple() {

    }

    public Apple(int weight, String color) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private String color;
    private int weight;
}

interface ApplePredicate {
    boolean test(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}

/**
 * 入口类
 */
class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        System.out.println(heavyApples);
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        System.out.println(greenApples);
        // lambda表达式
        List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(result);
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}