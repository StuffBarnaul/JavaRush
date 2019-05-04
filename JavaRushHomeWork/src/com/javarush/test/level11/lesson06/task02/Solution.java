package com.javarush.test.level11.lesson06.task02;

/* Домашние животные
Написать три класса: Pet (домашнее животное), Cat(кот) и Dog(собака).
Унаследовать кота и собаку от животного.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Pet
    {
        String name;
    }

    public class Cat extends Pet
    {
        String name;
        public Cat (String name){this.name = name;}
    }

    public class Dog extends Pet
    {
        String name;
        public Dog (String name){this.name = name;}
    }
}
