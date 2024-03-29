package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Apartment p1 = new Apartment("qwe",12);
        System.out.println(p1);
        FileOutputStream fileOutput = new FileOutputStream("4");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(p1);
        fileOutput.close();
        outputStream.close();
        p1 = new Apartment("123",13);
        System.out.println(p1);

        FileInputStream fiStream = new FileInputStream("4");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        p1 = (Apartment) objectStream.readObject();
        fiStream.close();
        objectStream.close();
        System.out.println(p1);
    }
    public static class Apartment implements Externalizable{

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }
}
