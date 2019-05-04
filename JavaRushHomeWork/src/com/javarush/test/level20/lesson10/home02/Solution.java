package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        new Solution().test();
    }
    public void test() throws IOException, ClassNotFoundException{
        A object = new A();
        FileOutputStream fileOutput = new FileOutputStream("4");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(object);
        fileOutput.close();
        outputStream.close();

        FileInputStream fiStream = new FileInputStream("4");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        getOriginalObject(objectStream);
        fiStream.close();
        objectStream.close();
        System.out.println(object);
    }
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException,ClassNotFoundException{
        objectStream.mark(0);
        A object = (A) objectStream.readObject();
        System.out.println(object.serialVersionUID);
        objectStream.reset();
        //B objectb = (B) objectStream.readObject();
        //System.out.println(objectb.serialVersionUID);
        if (object.serialVersionUID == 1L) {A ao = (A) objectStream.readObject(); return ao;}
        if (object.serialVersionUID == 2L) {B bo = (B) objectStream.readObject(); return bo;}
        return null;
    }

    public class A implements Serializable{
        private static final long serialVersionUID = 1L;
    }

    public class B extends A {
        private static final long serialVersionUID = 2L;
        public B() {
            System.out.println("inside B");
        }
    }

    public class C extends B{
        private static final long serialVersionUID = 3L;
        public C() {
            System.out.println("inside C");
        }
    }
}
