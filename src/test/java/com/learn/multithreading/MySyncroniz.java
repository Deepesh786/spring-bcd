package com.learn.multithreading;


import java.util.HashMap;
import java.util.Map;

class TotalEarning extends Thread{

        static int total=0;
        public void run(){
            for(int i=1;i<=10;i++){

                total = total + 100;
                System.out.println("i = "+i);
            }
            System.out.println("Total "+total);
            this.setDaemon(true);
        }
    }

    public class MySyncroniz {


        public static int dp()
        {
            return 1;
        }

        public int dp(int dp)
        {
            return dp;
        }

        public static void main(String[] args) {

            Map<String,Integer> m =new HashMap();

            TotalEarning totalEarning = new TotalEarning();
           // totalEarning.setDaemon(true);
            totalEarning.start();

            System.out.println(new MySyncroniz().dp(1728));
            System.out.println("Total : "+totalEarning.total);
        }
    }
