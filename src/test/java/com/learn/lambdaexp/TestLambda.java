package com.learn.lambdaexp;

import static java.lang.System.*;

@FunctionalInterface
interface  Calculator{

    //void show();

    //void sum(int input);

    int substract(int x,int y);
}

public class TestLambda {

    public static void main(String[] args) {

        //Calculator calculator = ()-> System.out.println("In lambda ");
        //Calculator calculator = (x) -> System.out.println("In lambda "+x);

//        Calculator calculator = (x,y) -> {
//            return (y-x);
//        };
        Calculator calculator = (x,y) ->(y-x);




        int x=calculator.substract(17,28);
        out.println("x= "+x);
    }

}
