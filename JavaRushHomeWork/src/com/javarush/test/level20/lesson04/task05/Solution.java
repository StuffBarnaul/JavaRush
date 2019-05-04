package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {
    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException
    {
        Object baseObject = new Object();
        baseObject.string1 = new String();
        baseObject.string2 = new String();
        baseObject.string1.print();
        baseObject.string2.print();
        System.out.println(baseObject.string1+" "+baseObject.string2);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("4"));
        oos.writeObject(baseObject);
        oos.close();
        baseObject.string1 = new String();
        baseObject.string2 = new String();
        baseObject.string1.print();
        baseObject.string2.print();
        System.out.println(baseObject.string1+" "+baseObject.string2);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("4"));
        baseObject = (Object) ois.readObject();
        ois.close();

        baseObject.string1.print();
        baseObject.string2.print();
        System.out.println(baseObject.string1+" "+baseObject.string2);
    }

    public static class Object implements Serializable{
        public String string1;
        public String string2;
        public Object(){}
    }

    public static int countStrings;

    public static class String implements Serializable{
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
