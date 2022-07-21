package com.learn.multithreading;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread t = Thread.currentThread();
            System.out.println("In MyRunnable class run method i= "+i +" Thread name = "+t.getName());

        }

    }
}
