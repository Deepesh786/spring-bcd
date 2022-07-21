package com.example.jpa.springdatajpa.exceptionhandling.concurrenthashmap;




import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TestConcurrentHashMap {



    public static void main(String[] args) {

        //Map <String,Integer> hasMap = new HashMap<String,Integer>();
        Map<String,Integer> conMpa = new ConcurrentHashMap<>();

        MapHellper1 mh1  = new MapHellper1(conMpa);
        MapHellper2 mh2  = new MapHellper2(conMpa);
        MapHellper3 mh3  = new MapHellper3(conMpa);
        MapHellper4 mh4  = new MapHellper4(conMpa);


        for(Map.Entry<String, Integer> dp : conMpa.entrySet()){
            System.out.println(dp.getKey() + "=" + dp.getValue());

        }
    }
}
