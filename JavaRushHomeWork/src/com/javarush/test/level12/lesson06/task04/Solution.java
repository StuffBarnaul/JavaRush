package com.javarush.test.level12.lesson06.task04;

/* Класс Cow от Animal
Унаследуй класс Cow от Animal.
Реализуй все недостающие методы в классе Cow.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static abstract class Animal
    {
        String name;
        public abstract String getName();
    }

    public static class Cow extends Animal
    {
        String name;
        public Cow(String name){this.name = name;}
        public String getName(){return name;}
    }

}
