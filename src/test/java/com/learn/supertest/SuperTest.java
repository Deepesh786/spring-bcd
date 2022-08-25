package com.learn.supertest;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

class Fruit{

    public String toString(){
        return  "I am a fruit!!";
    }
}

class Apple extends Fruit{

    public String toString(){
        return "I am a apple!!!";
    }
}

class AsianApple extends Apple {
    @Override
    public String toString() {
        return "I am an AsianApple !!";
    }
}

public class SuperTest {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());

        List<? super Apple> basket = apples;

        basket.add(new Apple());
        basket.add(new AsianApple());
        //basket.add(new Fruit());

    }
}
