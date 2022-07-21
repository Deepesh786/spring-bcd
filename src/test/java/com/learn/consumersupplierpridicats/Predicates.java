package com.learn.consumersupplierpridicats;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {
    public static void testPredicate(){
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartsWithS).forEach(System.out::println);
    }

    public static void testPredicateAndComposition(){
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> startPredicate = str -> str.startsWith("S");
        Predicate<String> startPredicateWithC = str -> str.startsWith("C");
        Predicate<String> lengthPredicate = str -> str.length() >= 5;
        names.stream().filter(startPredicate.and(lengthPredicate).or(startPredicateWithC)).forEach(System.out::println);
    }
    public static void main(String[] args) {
        testPredicate();
        System.out.println("__________");
        testPredicateAndComposition();
    }
}
