package com.javarush.test.level20.lesson04.task04;

import java.io.*;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ClassWithStatic baseObject = new ClassWithStatic();
        System.out.println(baseObject.staticString+" "+baseObject.s);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("4"));
        oos.writeObject(baseObject);
        baseObject.serializeStatic(oos);
        oos.close();
        baseObject.staticString = "1";
        baseObject.s = "2";
        System.out.println(baseObject.staticString+" "+baseObject.s);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("4"));
        baseObject = (ClassWithStatic) ois.readObject();
        baseObject.deserializeStatic(ois);
        ois.close();

        System.out.println(baseObject.staticString+" "+baseObject.s);
        //System.out.println(h2.assets.size());
        //System.out.println("=========================================================");
        //System.out.println("Object reference check : " + h2);
        //System.out.println("Object reference check : " + h1);
    }

    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;
        public String s = staticString;

        public static void serializeStatic (ObjectOutputStream oos) throws IOException{
            oos.writeObject(staticString);
        }
        public static void deserializeStatic(ObjectInputStream ois) throws IOException, ClassNotFoundException{
            staticString = (String) ois.readObject();
        }
        //public ClassWithStatic(){}
    }
}
