package com.learn.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeTest {
    public static void main(String[] args) {

        try {
            Employee e1 = new Employee(1,"Deepesh");
            Employee e2 = new Employee(2,"Bahvanee");
            Employee e3 = new Employee(3,"Chandan");

            FileOutputStream fout = new FileOutputStream("SerializeTest.txt");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(e1);
            oout.writeObject(e2);
            oout.writeObject(e3);
            oout.flush();
            oout.close();
            System.out.println("Serialization and Deserialization is been successfully executed");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
