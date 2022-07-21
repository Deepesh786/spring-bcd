package com.learn.consumersupplierpridicats;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class TestConsumer {

    public static void whenNamesPresentConsumeAll(){
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        //cities.forEach(printConsumer);
        cities.forEach((t)->{
            if(t.equals("Sydney"))
                System.out.println("Ohh get it!!!");
        });
    }

    public static void whenNamesPresentUseBothConsumer(){
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }

    public static void main(String[] args) {
        whenNamesPresentConsumeAll();
        System.out.println("________________________");
        whenNamesPresentUseBothConsumer();
        int x=0;

    }
}
