package com.javarush.test.level11.lesson06.task03;

/* В гостях у бабушки
Написать шесть классов: Animal (животное), Cow(корова) и Pig(свинья), Sheep(овца), Bull(бык), Goat(козел).
Унаследовать корову, свинью, овцу, быка и козла от животного.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Animal
    {
        String name;
    }

    public class Cow extends Animal
    {
        String name;
        public Cow (String name){this.name = name;}
    }

    public class Pig extends Animal
    {
        String name;
        public Pig (String name){this.name = name;}
    }

    public class Sheep extends Animal
    {
        String name;
        public Sheep (String name){this.name = name;}
    }

    public class Bull extends Animal
    {
        String name;
        public Bull (String name){this.name = name;}
    }

    public class Goat extends Animal
    {
        String name;
        public Goat (String name){this.name = name;}
    }

}
