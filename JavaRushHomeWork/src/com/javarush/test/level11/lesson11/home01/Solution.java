package com.javarush.test.level11.lesson11.home01;

/* Адам и Ева
Написать два класса Adam(Адам) и Eve(Ева).
Унаследовать Еву от Адама.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    //Адам
    public class Adam
    {
        String name;
        public Adam(){}
    }

    //Ева
    public class Eve extends Adam
    {
        String name;
        public Eve(){}
    }
}
