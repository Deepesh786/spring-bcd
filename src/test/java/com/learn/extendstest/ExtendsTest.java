package com.learn.extendstest;


import java.util.ArrayList;
import java.util.List;

class Fruit {
    @Override
    public String toString() {
        return "I am a Fruit !!";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "I am an Apple !!";
    }
}

class AsianApple extends Apple {
    @Override
    public String toString() {
        return "I am an AsianApple !!";
    }
}

public class ExtendsTest {

    public static void main(String[] args) {

        List<Fruit> apple = new ArrayList<>();
        apple.add(new Apple());

        List<? extends Fruit> basket = new ArrayList<>();

        for(Fruit fruit : basket) {
            System.out.println(fruit);

        }
        //basket.add(new AsianApple());
        //basket.add(new Apple());
        //basket.add(new Fruit());

    }
}
