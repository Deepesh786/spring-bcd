package com.example.jpa.springdatajpa.exceptionhandling.concurrenthashmap;

import java.util.Map;

class MapHellper4 implements Runnable{

    Map<String, Integer> map ;

    public MapHellper4(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, " MapHellper1 ").start();
    }

    public void run(){
        map.put("four",4);
        try{
            System.out.println("MapHelper4 Sleeping");
            //Thread.sleep(10000);
        }
        catch(Exception e){
            System.out.println(e);

        }

    }
}
