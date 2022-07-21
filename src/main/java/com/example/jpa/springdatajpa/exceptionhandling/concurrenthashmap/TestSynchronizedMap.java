package com.example.jpa.springdatajpa.exceptionhandling.concurrenthashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestSynchronizedMap {
    public static void main(String[] args) {

        Map<String,Integer> hasMap = new HashMap<String,Integer>();
        Map<String,Integer> syncMpa = Collections.synchronizedMap(hasMap);

        MapHellper1 mh1  = new MapHellper1(syncMpa);
        MapHellper2 mh2  = new MapHellper2(syncMpa);
        MapHellper3 mh3  = new MapHellper3(syncMpa);
        MapHellper4 mh4  = new MapHellper4(syncMpa);


        for(Map.Entry<String, Integer> dp : syncMpa.entrySet()){
            System.out.println(dp.getKey() + "=" + dp.getValue());

        }
    }
}
