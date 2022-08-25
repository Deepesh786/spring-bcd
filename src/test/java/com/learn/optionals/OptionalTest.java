package com.learn.optionals;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        String str = new String("dipesh");

        Optional.ofNullable(str).ifPresent(st->{

            System.out.println("str= "+str+" st= "+st);

            st= new String("dp");

            System.out.println("str= "+str+" st= "+st);

        });



    }

}
