package com.javarush.test.level11.lesson11.home03;

/* Эволюция
Написать четыре класса: Fish(Рыбы), Animal(Животные), Ape(Обезьяны), Human (Человек).
Унаследовать животных от рыб, обезьян от животных и человека от обезьян.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Fish
    {
        String name;
    }

    public class Animal extends Fish
    {
        String name;
    }

    public class Ape extends Animal
    {
        String name;
    }

    public class Human extends Ape
    {
        String name;
        public Human(){}
    }

}
