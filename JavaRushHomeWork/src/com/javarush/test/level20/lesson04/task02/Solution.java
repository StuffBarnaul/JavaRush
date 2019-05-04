package com.javarush.test.level20.lesson04.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать JavaRush?
Сделайте так, чтобы сериализация класса JavaRush была возможной
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User u1 = new User();
        User u2 = new User();

        JavaRush baseObject = new JavaRush();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("4"));
        oos.writeObject(baseObject);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("4"));
        JavaRush newObject = (JavaRush) ois.readObject();
        ois.close();

        System.out.println(newObject.users.size());
        //System.out.println(h2.assets.size());
        //System.out.println("=========================================================");
        //System.out.println("Object reference check : " + h2);
        //System.out.println("Object reference check : " + h1);
    }

    public static class JavaRush implements Serializable{
        public List<User> users = new ArrayList<>();

        //public JavaRush() {}

        public JavaRush(User... users){
            if (users != null) {
                this.users.addAll(Arrays.asList(users));
            }
        }
    }
}
