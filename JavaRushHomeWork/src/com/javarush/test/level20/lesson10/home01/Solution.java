package com.javarush.test.level20.lesson10.home01;

import java.io.*;

/* Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        new Solution().test();
    }
    public void test() throws IOException, ClassNotFoundException{
        C p1 = new C("C");
        System.out.println(p1);
        FileOutputStream fileOutput = new FileOutputStream("4");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(p1);
        fileOutput.close();
        outputStream.close();
        p1 = new C("CC");
        System.out.println(p1);

        FileInputStream fiStream = new FileInputStream("4");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        p1 = (C) objectStream.readObject();
        fiStream.close();
        objectStream.close();
        System.out.println(p1);
    }
    public class A implements Serializable{
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }
}
