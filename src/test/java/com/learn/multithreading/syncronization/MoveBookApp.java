package com.learn.multithreading.syncronization;

class BookTheaterSet{

    int total_seat = 10;
    synchronized public void bookSeat(int seats){

        if(total_seat>= seats){

            System.out.println("Seat booked successfuly" + seats);
            total_seat = total_seat - seats;
            System.out.println("seats left" +total_seat);
        }
        else{
            System.out.println("seat can not be booked "+ seats);
            System.out.println("seats left "+ total_seat);
        }
    }
}

public class MoveBookApp extends Thread{

    static BookTheaterSet b;
    int seat;

    public void run(){
        b.bookSeat(seat);
    }

    public static void main(String[] args) {

        b = new BookTheaterSet();
        MoveBookApp dp = new MoveBookApp();
        dp.seat = 6;
        dp.start();

        MoveBookApp dp1 = new MoveBookApp();
        dp1.seat = 7;
        dp1.start();
    }
}
