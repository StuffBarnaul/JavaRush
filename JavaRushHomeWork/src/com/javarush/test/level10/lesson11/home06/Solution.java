package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        Integer age;
        Integer weight;
        Boolean sex;
        String eyes;
        Integer rost;

        public  Human (String name,Integer weight,Boolean sex,Integer rost)
        {this.name = name;this.age = 25;this.weight = weight;this.sex = sex;this.eyes = "red";this.rost = rost;}
        public  Human (String name,Boolean sex,String eyes,Integer rost)
        {this.name = name;this.age = 30;this.weight = 60;this.sex = sex;this.eyes = eyes;this.rost = rost;}
        public  Human (String name,Integer age,String eyes,Integer rost)
        {this.name = name;this.age = age;this.weight = 60;this.sex = true;this.eyes = eyes;this.rost = rost;}
        public  Human (String name,Integer age,Integer weight,String eyes)
        {this.name = name;this.age = age;this.weight = weight;this.sex = true;this.eyes = eyes;this.rost = 150;}
        public  Human (String name,Integer age,Boolean sex,String eyes,Integer rost)
        {this.name = name;this.age = age;this.weight = 60;this.sex = sex;this.eyes = eyes;this.rost = rost;}
        public  Human (String name,Integer age,Integer weight,Boolean sex)
        {this.name = name;this.age = age;this.weight = weight;this.sex = sex;this.eyes = "red";this.rost = 150;}
        public  Human (String name,Integer age,Integer weight,String eyes,Integer rost)
        {this.name = name;this.age = age;this.weight = weight;this.sex = true;this.eyes = eyes;this.rost = rost;}
        public  Human (String name,Integer age,Integer weight,Boolean sex,Integer rost)
        {this.name = name;this.age = age;this.weight = weight;this.sex = sex;this.eyes = "red";this.rost = rost;}
        public  Human (String name,Integer age,Integer weight,Boolean sex,String eyes)
        {this.name = name;this.age = age;this.weight = weight;this.sex = sex;this.eyes = eyes;this.rost = 150;}
        public  Human (String name,Integer age,Integer weight,Boolean sex,String eyes,Integer rost)
        {this.name = name;this.age = age;this.weight = weight;this.sex = sex;this.eyes = eyes;this.rost = rost;}
    }
}
