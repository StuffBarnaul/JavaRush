package com.javarush.test.level11.lesson11.home02;

/* AppleIPhone и SamsungGalaxyS2
Написать два класса AppleIPhone и SamsungGalaxyS2.
Унаследовать SamsungGalaxyS2 от AppleIPhone.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class AppleIPhone
    {
        String name;
    }

    public class SamsungGalaxyS2 extends AppleIPhone
    {
        String name;
        public SamsungGalaxyS2(){}
    }
}
