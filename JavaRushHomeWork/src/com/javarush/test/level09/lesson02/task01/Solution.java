package com.javarush.test.level09.lesson02.task01;

/* Каждый метод должен возвращать свой StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать свой StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static StackTraceElement[] method1()
    {
        method2();
        StackTraceElement[] stackTraceElements2 = Thread.currentThread().getStackTrace();//напишите тут ваш код
        return stackTraceElements2;
    }

    public static StackTraceElement[] method2()
    {
        method3();
        StackTraceElement[] stackTraceElements3 = Thread.currentThread().getStackTrace();//напишите тут ваш код
        return stackTraceElements3;
    }

    public static StackTraceElement[] method3()
    {
        method4();
        StackTraceElement[] stackTraceElements4 = Thread.currentThread().getStackTrace();//напишите тут ваш код
        return stackTraceElements4;
    }

    public static StackTraceElement[] method4()
    {
        method5();
        StackTraceElement[] stackTraceElements5 = Thread.currentThread().getStackTrace();//напишите тут ваш код
        return stackTraceElements5;
    }

    public static StackTraceElement[] method5()
    {
        StackTraceElement[] stackTraceElements6 = Thread.currentThread().getStackTrace();//напишите тут ваш код
        return stackTraceElements6;
    }
}
