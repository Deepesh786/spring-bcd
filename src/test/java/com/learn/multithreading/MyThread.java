package com.learn.multithreading;

public class MyThread extends Thread{

    public void run() {

        for(int i=10;i>0;i--){


            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("In MyThread class run method i= "+i);
        }
    }
    public static void main(String[] args) {

        Runnable runnable = ()->{

            for(int i=10;i>0;i--){

                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                Thread t = Thread.currentThread();
                t.setName("Deepesh");
                System.out.println("functional interface i= "+i+" Thread name "+t.getName());
            }

        };

        Thread th = new Thread(runnable);

        th.start();

//        MyRunnable myRunnable = new MyRunnable();
//        Thread th = new Thread(myRunnable);
//        MyThread myThread = new MyThread();
//        th.run(); treat as normal method
//        myThread.run(); treat as normal method
//
//        th.start();
//        myThread.start();


    }
}
