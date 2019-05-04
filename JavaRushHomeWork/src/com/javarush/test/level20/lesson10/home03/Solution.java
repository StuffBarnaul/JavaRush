package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/

public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        new Solution().test();
    }
    public void test() throws IOException, ClassNotFoundException{
        B object = new B("");
        System.out.println(object.name);
        FileOutputStream fileOutput = new FileOutputStream("4");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(object);
        fileOutput.close();
        outputStream.close();
        object = new B("C");
        System.out.println(object.name);

        FileInputStream fiStream = new FileInputStream("4");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        object = (B) objectStream.readObject();
        fiStream.close();
        objectStream.close();
        System.out.println(object.name);
    }
    public static class A {
        protected String name = "A";
        public A(){}
        public A(String name) {
            this.name += name;
        }
    }
    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            name = (String) ois.readObject();
        }
        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
            oos.writeObject(this.name);
        }
    }
}

