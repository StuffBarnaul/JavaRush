package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static String method1()
    {
        method2();
        StackTraceElement[] stackTraceElements1 = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements1[2];
        String methodName = element.getMethodName();
        return methodName;
    }

    public static String method2()
    {
        method3();
        StackTraceElement[] stackTraceElements1 = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements1[2];
        String methodName = element.getMethodName();
        return methodName;
    }

    public static String method3()
    {
        method4();
        StackTraceElement[] stackTraceElements1 = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements1[2];
        String methodName = element.getMethodName();
        return methodName;
    }

    public static String method4()
    {
        method5();
        StackTraceElement[] stackTraceElements1 = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements1[2];
        String methodName = element.getMethodName();
        return methodName;
    }

    public static String method5()
    {
        StackTraceElement[] stackTraceElements1 = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements1[2];
        String methodName = element.getMethodName();
        return methodName;
    }
}
