package com.learn.consumersupplierpridicats;

import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestSupplier {


     static Function<String,Integer> dp = str -> {

        return Integer.parseInt(str);
    };

    public static void supplier(){
        Supplier<String> doubleSupplier1 = () -> new String("t");
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
    }
    public static void main(String[] args) {
        supplier();
        System.out.println(dp.apply("7"));


    }
}
