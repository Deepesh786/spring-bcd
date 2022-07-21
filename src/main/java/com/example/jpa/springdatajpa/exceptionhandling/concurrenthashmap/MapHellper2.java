package com.example.jpa.springdatajpa.exceptionhandling.concurrenthashmap;


import java.util.Map;

class MapHellper2 implements Runnable {

    Map<String, Integer> map;

    public MapHellper2(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, " MapHellper1 ").start();
    }


    public void run() {
        map.put("two", 2);
        try {
            System.out.println("MapHelper2 Sleeping");
            //Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);

        }

    }
}