package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static void print(int i){System.out.println(i);}
    public static void print(Integer i){System.out.println(i);}
    public static void print(String s){System.out.println(s);}
    public static void print(String s,Integer i){System.out.println(s+i);}
    public static void print(String s,int i){System.out.println(s+i);}
}
