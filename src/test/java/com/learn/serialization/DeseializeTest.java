package com.learn.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeseializeTest {
    public static void main(String[] args) {

        try{

            ObjectInputStream in =new ObjectInputStream(new FileInputStream("SerializeTest.txt"));
            Employee e1 = (Employee) in.readObject();
            Employee e2 = (Employee) in.readObject();
            Employee e3 = (Employee) in.readObject();
            System.out.println("e1 = "  + e1);
            System.out.println("e2 = "  + e2);
            System.out.println("e3 = "  + e3);
            in.close();

        }
        catch(Exception e){

        }

    }
}
