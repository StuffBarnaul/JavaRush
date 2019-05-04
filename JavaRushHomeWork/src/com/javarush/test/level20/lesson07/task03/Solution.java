package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Person mother = new Person("m","m",40);
        Person father = new Person("f","f",40);
        Person c1 = new Person("c1","c1",0);
        Person c2 = new Person("c2","c2",2);
        List list = new ArrayList();
        list.add(c1);
        list.add(c2);
        Person p1 = new Person("fn","ln",20);
        p1.setMother(mother);
        p1.setFather(father);
        p1.setChildren(list);
        System.out.println(p1.firstName+" "+p1.mother.firstName+" "+p1.children.size());
        FileOutputStream fileOutput = new FileOutputStream("4");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(p1);
        fileOutput.close();
        outputStream.close();
        p1 = new Person("f","l",13);
        System.out.println(p1.firstName);
        //System.out.println(p1.mother.firstName);
        //System.out.println(p1.children.size());

        FileInputStream fiStream = new FileInputStream("4");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        p1 = (Person) objectStream.readObject();
        fiStream.close();
        objectStream.close();
        System.out.println(p1.firstName+" "+p1.mother.firstName+" "+p1.children.size());
    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){super();}
        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }
    }
}
