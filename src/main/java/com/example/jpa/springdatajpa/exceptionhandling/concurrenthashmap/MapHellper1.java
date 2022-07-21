package com.example.jpa.springdatajpa.exceptionhandling.concurrenthashmap;

import java.util.Map;

class MapHellper1 implements Runnable {

    Map<String, Integer> map;

    public MapHellper1(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, " MapHellper1 ").start();
    }


    public void run() {
        map.put("One", 1);
        try {
            System.out.println("MapHelper1 Sleeping");
            //Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);

        }

    }
}
