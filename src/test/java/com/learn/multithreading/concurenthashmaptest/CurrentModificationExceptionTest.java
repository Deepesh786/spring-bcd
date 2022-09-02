package com.learn.multithreading.concurenthashmaptest;


import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class CurrentModificationExceptionTest extends Thread {
    static HashMap m = new HashMap();

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("Child Thread updating Map");
        m.put(103, "C");
    }

    public static void main(String arg[]) throws InterruptedException {
        m.put(101, "A");
        m.put(102, "B");
        CurrentModificationExceptionTest t = new CurrentModificationExceptionTest();
        t.start();
        Set s1 = m.keySet();
        Iterator itr = s1.iterator();
        while (itr.hasNext()) {
            Integer I1 = (Integer) itr.next();
            System.out.println("Main Thread Iterating Map and Current Entry is:" + I1 + "..." + m.get(I1));
            Thread.sleep(3000);
        }
        System.out.println(m);
    }
}
