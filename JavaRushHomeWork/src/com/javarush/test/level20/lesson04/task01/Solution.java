package com.javarush.test.level20.lesson04.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Human h1 = new Human("Name", new Asset("home"), new Asset("car"));

        //Serializing the singleton instance
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("4"));
        oos.writeObject(h1);
        oos.close();

        //Recreating the instance by reading the serialized object data store
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("4"));
        Human h2 = (Human) ois.readObject();
        ois.close();

        //The singleton behavior have been broken
        System.out.println(h2.name);
        System.out.println(h2.assets.size());
        //System.out.println("=========================================================");
        //System.out.println("Object reference check : " + h2);
        //System.out.println("Object reference check : " + h1);
    }

    public static class Human implements Serializable{
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }
}
