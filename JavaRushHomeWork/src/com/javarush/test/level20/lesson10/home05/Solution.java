package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person object = new Person("1","2","3",Sex.MALE);
        System.out.println(object.fullName);
        FileOutputStream fileOutput = new FileOutputStream("4");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(object);
        fileOutput.close();
        outputStream.close();
        object = new Person("4","5","6",Sex.FEMALE);
        System.out.println(object.fullName);

        FileInputStream fiStream = new FileInputStream("4");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        object = (Person) objectStream.readObject();
        fiStream.close();
        objectStream.close();
        System.out.println(object.fullName);
    }
    public static class Person implements Serializable{
        String firstName;
        String lastName;
        String fullName;
        final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        //Person () {}
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
