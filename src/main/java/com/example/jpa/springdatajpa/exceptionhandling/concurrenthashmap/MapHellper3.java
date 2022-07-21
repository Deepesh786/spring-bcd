package com.example.jpa.springdatajpa.exceptionhandling.concurrenthashmap;

import java.util.Map;

class MapHellper3 implements Runnable {

    Map<String, Integer> map;

    public MapHellper3(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, " MapHellper3 ").start();
    }


    public void run() {
        map.put("three", 3);
        try {
            System.out.println("MapHelper1 Sleeping");
            //Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);

        }

    }
}